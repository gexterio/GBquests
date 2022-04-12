package ru.gb.gexterio.HomeWork_1;

public class HomeWorkApp {
    public static void main(String[] args) {  //Задание 1
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() { //Задание 2
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() { //Задание 3
        int a = 12, b = 20;
        int sum = a + b;
        System.out.println(sum >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    public static void printColor() { //Задание 4
        int value = 1;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers() { //Задание 5
        int a = 34,  b = 45;
        System.out.println(a>=b? "a>=b0": "a<b");
    }
}
