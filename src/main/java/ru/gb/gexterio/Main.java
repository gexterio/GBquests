package ru.gb.gexterio;

//        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
//        вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать, сколько раз встречается каждое слово.
//        2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
//        телефонных номеров. В этот телефонный справочник с помощью метода add() можно
//        добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
//        учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//        тогда при запросе такой фамилии должны выводиться все телефоны.
//
//        Желательно не добавлять
//        лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
//        через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
//        справочника.


import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static ru.gb.gexterio.HomeWork_1.PhoneBook.*;


public class Main {
    public static void main(String[] args) {
        duplicateCounter(generateStringArray());
        contactsAdder();
        print();
        get("Уткин");
    }



    private static void contactsAdder() {
        add("Уткин", "+0 000 955555");
        add("Уткин", "+1 111 111111");
        add("Власов", "+0 545 000000");
        add("Власов", "+0 148 124456");
        add("Бульбов", "+0 453 000000");
        add("Лизгинов", "+0 210 744456");
        add("Лизгинов", "+0 777 777652");
        add("Чкалов", "+0 211 654877");
        add("Уткин", "+0 000 955555");
        add("Уткин", "+1 111 111111");
        add("Власов", "+0 545 000000");
        add("Власов", "+0 148 124456");
        add("Бульбов", "+0 453 000000");
        add("Лизгинов", "+0 210 744456");
        add("Лизгинов", "+0 777 777652");
        add("Чкалов", "+0 211 654877");
    }


    private static void duplicateCounter(String[] array) {
        HashSet<String> setStrings = new HashSet<>(List.of(array));
        System.out.println("—".repeat(setStrings.size()*4+9));
        System.out.println("| " +setStrings+ " |");
        System.out.println("—".repeat(setStrings.size()*4+9));
        for (String item : setStrings) {
            int duplicateCount = Collections.frequency(List.of(array), item);
            System.out.println( item + " -> " + duplicateCount + " times");
        }
        System.out.println("—".repeat(setStrings.size()*4+9));
    }

    private static String[] generateStringArray() {
        return new String[]{
                "Ad", "Be", "Do", "Go", "Hi", "No", "Or", "Up",
                "Us", "We", "Cat", "Dog", "Sky", "Sun", "Owl",
                "Do", "Go", "No", "Up", "Ad",
        };
    }
}
