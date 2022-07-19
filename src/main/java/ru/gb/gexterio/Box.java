package ru.gb.gexterio;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    public ArrayList<T> getFruits() {
        return fruits;
    }

    private ArrayList<T> fruits;
    private float fruitWeight;

    public Box() {
        fruits = new ArrayList<T>(10);
    }


    public void add(T... fruit) {
        fruits.addAll(List.of(fruit));
        fruitWeight = (fruits.get(0)).getWeight();
    }
    private void addAll(ArrayList<T> fruit) {
        fruits.addAll(fruit);
    }



    public float getFruitWeight() {
        return fruits.size() * fruitWeight;
    }

    public boolean compare (Box<?> box) {
        return this.getFruitWeight() == box.getFruitWeight();
    }

    public void pour ( Box<T> targetBox) {
        targetBox.addAll(this.getFruits());
        fruits.clear();
    }

}

