package com.tarnovskiy.lesson01;


import com.tarnovskiy.lesson01.fruits.Apple;
import com.tarnovskiy.lesson01.fruits.Orange;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        //------ test task1 ----
        Integer testArray[] = {1, 2, 3, 4};
        String testStringArray[] = {"1", "2", "3", "4"};
        Array<Integer> integerArray = new Array<>(testArray);
        Array<String> integerStringArray = new Array<>(testStringArray);
        Integer[] newArray = integerArray.changeIndex(testArray, -1, 2);
        String[] newStringArray = integerStringArray.changeIndex(testStringArray, 1, 2);
        System.out.println(Arrays.toString(newArray));
        System.out.println(Arrays.toString(newStringArray));

        //------ test task2 ----
        List<Integer> list = integerArray.createList(testArray);
        List<String> listString = integerStringArray.createList(testStringArray);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(listString.toArray()));

        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Apple apple = new Apple();
        Orange orange = new Orange();
        orangeBox.addFruit(orange, orange);
        appleBox.addFruit(apple, apple);
        appleBox2.addFruit(apple);

        System.out.println(orangeBox.compere(appleBox));

        System.out.println(appleBox.getWeigth());
        System.out.println(orangeBox.getWeigth());
        System.out.println();
        System.out.println(appleBox.getWeigth());
        System.out.println(appleBox2.getWeigth());
        appleBox.fold(appleBox2);
        System.out.println(appleBox.getWeigth());
        System.out.println(appleBox2.getWeigth());
        appleBox.fold(appleBox2);

    }
}
