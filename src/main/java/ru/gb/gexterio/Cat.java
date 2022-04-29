package ru.gb.gexterio;

public class Cat extends Animal {
    int maxRun = 200;
    int maxSwim = 0;
    String name ="Кот";

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void printLimits() {
        System.out.println("Максимальное расстояние бегом: " + maxRun);
        System.out.println("Максимальное расстояние вплавь: " + maxSwim);
    }

    @Override
    public void doRun(int distance) {

        if (distance <= maxRun && distance > 0) {
            printRun(distance);
        } else {
            System.out.println(TOO_MUCH_MESSAGE);
        }
    }

    @Override
    public void doSwim(int distance) {
        if (distance <= maxSwim && distance > 0) {
            printSwim(distance);
        } else {
            System.out.println(TOO_MUCH_MESSAGE);
        }
    }

}
