package com.tarnovskiy.lesson01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tarnovskiy Maksim
 */
class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array.clone();
    }

    public T[] changeIndex(T[] array, int index1, int index2) {
        if(array.length > index1 && array.length > index2 && index1 >= 0 && index2 >= 0){
            T i = array[index1];
            array[index1] = array[index2];
            array[index2] = i;
            return array;
        }
        else {
            System.out.println("Вы ввели значение индекса за пределы массива");
            return array;
        }
    }

    public List<T> createList (T[] array){
        List<T> list = new ArrayList<>();
        for (T v : array){
            list.add(v);
        }
        return list;
    }
}
