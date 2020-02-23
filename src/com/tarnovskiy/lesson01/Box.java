package com.tarnovskiy.lesson01;

import com.tarnovskiy.lesson01.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tarnovskiy Maksim
 */
public class Box<T extends Fruit> {
    private float weight = 4.5f;
    private List<T> listFruit = new ArrayList<>();

    public void addFruit(T... variety) {
        for (int i = 0; i < variety.length; i++) {
            this.listFruit.add(variety[i]);
        }
    }
    public float getWeigth(){
        float weightBox = weight;
        for (T fruit : this.listFruit){
            weightBox += fruit.getFruitWeight();
        }
        return weightBox;
    }

    public boolean compere(Box<? extends Fruit> box){
        boolean com = false;
        if(box.getWeigth() == this.getWeigth())
            com = true;
        return com;
    }

    public void fold(Box<T> box){
        float countFruits = this.getListFruit().size();
        if(countFruits != 0){
            for (T fruit : this.listFruit){
                box.addFruit(fruit);
            }
            this.listFruit.clear();
        } else System.out.println("А в коразине ничего нету...");
    }

    public List<T> getListFruit() {
        return listFruit;
    }
}
