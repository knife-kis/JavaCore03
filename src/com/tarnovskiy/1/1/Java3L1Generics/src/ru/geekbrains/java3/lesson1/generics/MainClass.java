package ru.geekbrains.java3.lesson1.generics;

public class MainClass {
    public static void main(String[] args) {

    }

    public static void problemWithObjClass() {
        ObjClass a = new ObjClass(new Integer(20));
        int x = (int)a.getObj();
        System.out.println("x: " + x);
        a.info();
        a.setObj("Hello"); // где-то в другом месте программы записали туда String
        // int y = (int)a.getObj(); // а мы все еще думаем что там int - тут будет исключение
        // чтобы защититься от ситуаций выше
        if(a.getObj() instanceof Integer) { // но так писать неудобно
            int z = (int)a.getObj();
            System.out.println("z: " + z);
        }
        a.info();
    }

    public static void genericTest() {
        GenClass<Integer> a = new GenClass<>(20); // теперь мы знаем что в a всегда будут int
        int x = a.getObj(); // не нужен cast
        // a.setObj("Hello"); // так сделать не получится
        a.info();
    }

    public static void generic2TypesTest() {
        GenClass2Types<Integer, String> a = new GenClass2Types<>(20, "Java");
        a.info();
    }
}
