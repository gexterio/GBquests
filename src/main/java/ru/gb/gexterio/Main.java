package ru.gb.gexterio;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Васька", 3),
                new Cat("Муся", 5),
        };
        Dog[] dogs = {
                new Dog("бульдозер", 7),
                new Dog("Роб", 4),
        };
        int catsCounter = cats.length;
        int dogsCounter = dogs.length;
        int sum = cats.length + dogs.length;
        System.out.println("Создано животных всего: " + sum);
        System.out.println("из них котов: " + catsCounter + ", собак: " + dogsCounter);
        System.out.println("-----------------------");
        for (Cat cat : cats) {
            cat.doRun((int) (Math.random() * 200));
        }
        System.out.println("-----------------------");
        for (Dog dog : dogs) {
            dog.doRun((int) (Math.random() * 500));
            dog.doSwim((int) (Math.random() * 10));
        }
    }

//    public static void animalCounter () {
//        int catsCounter = cats.length;
//        int dogsCounter = dogs.length;
//        int sum =cats.length + dogs.length;
//        System.out.println("Создано животных: " +sum);
//        System.out.println("из них котов: " +catsCounter + ", собак: " +dogsCounter);
//    }
}
