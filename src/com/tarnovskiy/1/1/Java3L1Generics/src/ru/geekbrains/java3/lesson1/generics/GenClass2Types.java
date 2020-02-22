package ru.geekbrains.java3.lesson1.generics;

public class GenClass2Types<T, K> {
    private T obj1;
    private K obj2;

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public K getObj2() {
        return obj2;
    }

    public void setObj2(K obj2) {
        this.obj2 = obj2;
    }

    public GenClass2Types(T obj1, K obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void info() {
        System.out.println("(1) type: " + obj1.getClass());
        System.out.println("(1) obj: " + obj1);
        System.out.println("(2) type: " + obj2.getClass());
        System.out.println("(2) obj: " + obj2);
    }
}
