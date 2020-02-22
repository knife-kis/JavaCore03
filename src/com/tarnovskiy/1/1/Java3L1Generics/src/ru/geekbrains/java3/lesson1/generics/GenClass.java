package ru.geekbrains.java3.lesson1.generics;

public class GenClass<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public GenClass(T obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("type: " + obj.getClass());
        System.out.println("obj: " + obj);
    }
}
