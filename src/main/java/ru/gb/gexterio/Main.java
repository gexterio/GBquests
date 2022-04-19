package ru.gb.gexterio;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
         System.out.println("Конечный массив: " + Arrays.toString(arrayFix(randomArray(20, 1))));
         System.out.println("Массив от 1 до 100: " + Arrays.toString(hundredArray()));
         System.out.println("Умножение чисел меньше 6: " + Arrays.toString(multiplication()));
         printCross();
         System.out.println(Arrays.toString(arrayConstructor(10, 9)));
         maxAndMinValue();
         System.out.println(checkBalance(randomArray(20, 8)));  //передается максимальная длина массива и максимальное значение элемента


    }

    public static int[] randomArray(int len, int value) {        // создание и заполнение массива длинной от 2 до 20
        int arrayLength = (int) Math.round(Math.random() * len + 2); // раномными значениями в заданном диапозоне
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * value);
        }
        System.out.println("Исходный массив: " + Arrays.toString(array));
        return array;
    }


    public static int[] arrayFix(int[] array) {  //Задание №1
        System.out.println("-----------------");
        int[] fixedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                fixedArray[i] = 1;
            else if (array[i] == 1)
                fixedArray[i] = 0;
        }
        return fixedArray;
    }

    public static int[] hundredArray() { //Задание №2
        System.out.println("-----------------");
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] multiplication() { //Задание №3
        System.out.println("-----------------");
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("исходный массив" + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        return array;
    }

    public static void printCross() { //Задание №4
        System.out.println("-----------------");
        int[][] array = new int[9][9];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || j == array.length - 1 - i) {
                    array[i][j] = 1;
                } else array[i][j] = 0;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

    public static int[] arrayConstructor(int len, int initialValue) { //Задание №5
        int[] array = new int[len];
        System.out.print("Заполнение массива: ");
        Arrays.fill(array, initialValue);
        return array;

    }

    public static void maxAndMinValue() { //Задание №6
        System.out.println("-----------------");
        int[] array = randomArray(20, 100); //создание и заполнение массива с помощью ранее написанного метода
        int max = 0;
        int min = max;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }

    public static boolean checkBalance(int[] array) { //Задание №7
        System.out.println("-----------------");
        System.out.println("Исходный массив: " + Arrays.toString(array));
        boolean result = false;
        int leftSum = 0;
        int rightSum = 0;
        int len = array.length;

        for (int border = 0; border < len; border++) {  //Установка точки, разделяющей две половины массива
            if (leftSum == rightSum && leftSum != 0 && rightSum != 0) { //Сравнение частей массива
                result = true;
                break;
            } else {                            //Обнуление сумм частей массива и ее шаг
                leftSum = 0;
                rightSum = 0;
            }
            for (int i = 0; i < border; i++) {  //Суммирование элементов левой части массива
                leftSum = leftSum + array[i];
            }
            for (int j = border; j < array.length; j++) { //Суммирование элементов правой части массива
                rightSum = rightSum + array[j];
            }
        }
        return result;
    }
}