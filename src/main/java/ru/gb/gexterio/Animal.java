package ru.gb.gexterio;

public abstract class Animal {
    private String name;
    private int age;
    final String TOO_MUCH_MESSAGE = "Это слишком, мужик, столько не проплыть!";

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void doRun(int distance) {
        if (distance <= 0 && distance > 0) {
            printRun(distance);
        } else {
            System.out.println(TOO_MUCH_MESSAGE);
        }
    }

    public void printRun(int distance) {
        System.out.println(name + " пробежал " + distance + " метров!");

    }

    public void doSwim(int distance) {
        if (distance <= 0 && distance > 0) {
            printRun(distance);
        } else {
            System.out.println("Это слишком, мужик!");
        }
    }

    public void printSwim(int distance) {
        System.out.println(name + " проплыл " + distance + " метров!");
    }

    public void printInfo() {
        System.out.println("name: " + name);
        System.out.println("age: " + age);

    }

    public abstract void printLimits();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

