package ru.gb.gexterio;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }


    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public void addManyFruit(T fruit, int count) {
        for (int i = 0; i <count; i++) {
            addFruit(fruit);
        }
    }


//    public float getWeight() {
//        float sum = 0;
//        for (T t : box) {
//            t.g
//        }
//        return sum;
//    }


    public ArrayList<T> getBox() {
        return box;
    }

    public void stat() {
        System.out.println("*".repeat(30));
        for (T t : box) {
            System.out.println(t.getClass());
        }
        System.out.println("*".repeat(30));



    }
}
