package ru.gb.gexterio;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberBox <T extends Number>{

    private T[] arr;

    public NumberBox(T... arr) {
        this.arr = arr;
    }



    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public T[] arrayItemSwap ( int item1, int item2) {
        if (item1 >= 0 && item1 <arr.length && item2 >= 0 && item2 <arr.length) {
            System.out.println(Arrays.toString(arr));
            T temp = arr[item1];
            arr[item1] = arr[item2];
            arr[item2] = temp;
            return arr;
        }
        System.out.println("Не удалось провести свап, переданы неверные аргументы");
        return arr;
    }

    public ArrayList <T> arrToList (T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        return list;
    }
}
