package ru.gb.gexterio;

import java.util.ArrayList;
import java.util.Arrays;

//
//       *** a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//        b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
//        фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можно использовать ArrayList;
//        d. Сделать метод getFruitWeight(), который высчитывает вес коробки, зная вес одного фрукта
//        и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//        e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
//        коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
//        равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
//        апельсинами;
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
//        объекты, которые были в первой;
//        g. Не забываем про метод добавления фрукта в коробку.

public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        appleBox.add(new Apple(),new Apple(),new Apple(),new Apple(),new Apple(),new Apple(),new Apple(),new Apple(),new Apple());
        orangeBox.add(new Orange(),new Orange(),new Orange(),new Orange(),new Orange(),new Orange());
        System.out.println(appleBox.getFruitWeight());
        System.out.println(orangeBox.getFruitWeight());
        System.out.println(appleBox.compare(orangeBox));
        appleBox.pour(appleBox2);
    }



}
