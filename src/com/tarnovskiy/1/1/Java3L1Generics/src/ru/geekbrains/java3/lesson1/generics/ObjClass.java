package ru.geekbrains.java3.lesson1.generics;

public class ObjClass {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public ObjClass(Object obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("type: " + obj.getClass());
        System.out.println("obj: " + obj);
    }
}
