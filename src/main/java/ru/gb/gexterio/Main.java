package ru.gb.gexterio;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Cat[] cats = {
                new Cat("Барсик", 12),
                new Cat("Фунтик", 10),
                new Cat("Сфинск", 11),
                new Cat("Бутер", 16),
                new Cat("Пушок", 8)

        };
        Plate plate = new Plate(0);

        for (Cat cat : cats) {
            do {
                if (plate.getFood() >= cat.getAppetite()) {
                    cat.eat(plate);
                    cat.setSatiety(true);
                    System.out.println(cat.getName() + " покушал " + cat.getAppetite() + " из " + (plate.getFood() +
                            cat.getAppetite()) + "    cat.isSatiety():  " + cat.isSatiety());
                    break;
                } else {
                    System.out.println(cat.getName() + " не покушал." + "    cat.isSatiety():  " + cat.isSatiety());
                    int addingFood = random.nextInt(20);
                    plate.addFood(addingFood);
                    System.out.println("Добавили " + addingFood + " еды");

                }
            }
            while (true);
        }
    }
}

