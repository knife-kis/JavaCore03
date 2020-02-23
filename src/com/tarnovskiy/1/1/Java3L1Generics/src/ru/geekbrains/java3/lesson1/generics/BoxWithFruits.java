package ru.geekbrains.java3.lesson1.generics;

import ru.geekbrains.java3.lesson1.generics.fruits.Fruit;

public class BoxWithFruits<T extends Fruit> {
    private float weight;

    public float getWeight() {
        return weight;
    }

    public BoxWithFruits(float weight) {
        this.weight = weight;
    }

    public boolean compareByWeight(BoxWithFruits<?> b2) {
        if(getWeight() == b2.getWeight()) return true;
        return false;
    }

    public boolean compareByType(BoxWithFruits<?> b2) {
        if(this.getClass() == b2.getClass()) return true;
        return false;
    }

    public boolean compareByTypeAndWeight(BoxWithFruits<T> b2) { // типы должны совпадать
        if(getWeight() == b2.getWeight()) return true;
        return false;
    }
}
