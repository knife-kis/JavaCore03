package com.tarnovskiy.server;

import com.tarnovskiy.server.DB.AuthService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ServerMain server;
    private String nick;
    private List<String> blackList;

    public ClientHandler(ServerMain server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.blackList = new ArrayList<>();

            new Thread(() -> {
                authorization();
                readClient();
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void authorization() {
        while (true) {
            try {
                String str = in.readUTF();
                String[] tokes = str.split(" ");
                String nickName = AuthService.getnickByLoginAndPass(tokes[1], tokes[2]);
                if (server.searchName(nickName)) {
                    sendMsg("Пользователь авторизован");
                } else if (str.startsWith("/auth")) {
                    if (nickName != null) {
                        sendMsg("/authok");
                        nick = nickName;
                        server.subscribe(this);
                        break;
                    } else {
                        sendMsg("Неверный логин/пароль");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readClient() {
        try {
            while (true) {

                String str = in.readUTF();
                if (str.startsWith("/")) {
                    clearingChat(str);
                    cloasedServer(str);
                    sendPrivateMsg(str);
                    addBlackList(str);
                } else {
                    server.broadcastMsg(this, nick + ": " + str);
                    System.out.println("Client: " + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeInAndOutAndSocket();
            server.deleteClient(this);
        }
    }

    private void clearingChat(String str) {
        if (str.startsWith("/clear")) {
            try {
                out.writeUTF("/clear");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addBlackList(String str) {
        if (str.startsWith("/blacklist ")) {
            String[] blackNick = str.split(" ");
            blackList.add(blackNick[1]);
            sendMsg("Вы добавили пользователя  " + blackNick[1] + " в черный список!");
        }
    }

    private void sendPrivateMsg(String str) {
        if (str.startsWith("/w") || str.startsWith("/W")) {
            String[] tokes = str.split(" ", 3);
            String nickname = tokes[1];
            String msg = tokes[2];
            server.privatebroadcastMsg(this, msg, nickname);
        }
    }

    public void sendMsg(String str) {
        try {
            out.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cloasedServer(String str) {
        if (str.equals("/end")) {
            try {
                out.writeUTF("/serverClosed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeInAndOutAndSocket() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }

    public List<String> getBlackList() {
        return blackList;
    }

    public boolean checkBlackList(String nick) {
        return blackList.contains(nick);
    }

}