package ru.gb.gexterio;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {                //Знаю, что нужы проверки для введенных данных,
        Scanner IntConsole = new Scanner(System.in);        //но так лень да и очень плохо еще разобрался
        Scanner lineConsole = new Scanner(System.in);       //в теме  проверок =(
        System.out.println("Введите целое число");
        int a = IntConsole.nextInt();
        System.out.println("Введите второе целое число");
        int b = IntConsole.nextInt();
        System.out.println("Введите строку");
        String line = lineConsole.nextLine();
        System.out.println("Какой сейчас год?");
        int year = IntConsole.nextInt();
        System.out.println("Сумма чисел " + a + " и " + b + " находятся в диапозоне? " + ArrayCheck(a, b));
        System.out.println(CheckPositiveInt(a));
        System.out.println("Число " + b + " является отрицательным? " + CheckNegativeInt(a));
        PrintWord(a, line);
        System.out.println("Сейчас високосный год? " + WhatYear(year));
    }

    public static boolean ArrayCheck(int a, int b) {   //Задача №1
        boolean result;
        int sum = a + b;
        result = sum >= 10 && sum <= 20;
        return result;
    }

    public static String CheckPositiveInt(int a) {     //Задача №2
        String NEGATIVE_INT = "Число " + a + " отрицательное";
        String POSITIVE_INT = "Число " + a + " положительное";
        return (a >= 0 ? POSITIVE_INT : NEGATIVE_INT);
    }

    public static boolean CheckNegativeInt(int a) {     //Задача №3
        boolean result = a < 0;
        return result;
    }

    public static void PrintWord(int count, String word) { //Задача №4
        for (int i = 0; i < count; i++) {
            System.out.print(word + " ");
            System.out.println();
        }
    }

    public static boolean WhatYear(int Year) {  //Задача №5
        boolean result;
        if (Year % 400 == 0) {
            result = true;
        } else if (Year % 4 == 0 && Year % 100 != 0) {
            result = true;
        }
        else result = false;
        return result;
    }
}
