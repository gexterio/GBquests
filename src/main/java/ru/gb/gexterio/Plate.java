package ru.gb.gexterio;

public class Plate {
    private int food;
    public Plate (int food) {
        this.food = food;
    }
    public void decreaseFood (int n) {
        food-= n;
    }

    public int getFood() {
        return food;
    }
    public void addFood(int n) {
       food += n;
    }
}

