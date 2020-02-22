package com.tarnovskiy.lesson01.fruits;

/**
 * @author Tarnovskiy Maksim
 */
public class Fruit {
    protected float fruitWeight;

    public void setFruitWeight(float fruitWeight) {
        this.fruitWeight = fruitWeight;
    }

    public float getFruitWeight() {
        return fruitWeight;
    }

    private String variety;

    public String getVariety() {
        return variety;
    }
}
