package ru.gb.gexterio;

//        Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
//        подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//        2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
//        просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
//        ячейке лежит символ или текст вместо числа), должно быть брошено исключение
//        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

//        3 В методе main() вызвать полученный метод, обработать возможные исключения
//        MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
//        при условии что подали на вход корректный массив).

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(intArraySummator(StringArrayConstructor()));

    }


    private static int intArraySummator(String[][] array) throws MyArrayDataException {
        try {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    sum += Integer.parseInt(array[i][j], 10);
                }
            }
            //  System.out.println();
            return sum;
        } catch (MyArrayDataException e) {
            throw e;
        }
    }

    private static String[][] StringArrayConstructor() throws MyArraySizeException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Задайте размер двумерного массива");
            String[][] array = new String[scanner.nextInt()][scanner.nextInt()];
            System.out.println("Задайте минимальное и максимальное число для заполнения массива диапозоном чисел");
            int min = scanner.nextInt();
            int max = scanner.nextInt();
            //   System.out.println("Массив строк:");
            for (int i = 0; i < array.length; i++) {
                //    System.out.println();
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = Integer.toString((int) (Math.random() * (max - min) + min));
                    // System.out.print(array[i][j] + " ");
                }
            }
            return array;
        } catch (MyArraySizeException e) {
            throw e;
        }
    }
}


