package ru.gb.gexterio.HomeWork_1;

import java.util.ArrayList;

public  class PhoneBook {
    private static final ArrayList<Contact> contacts = new ArrayList<>();

    public static void add(String name, String phone) {
        contacts.add(new Contact(name, phone));
    }

    public static void get (String name) {
        boolean isNamed = true;
        System.out.println("—".repeat(14));
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
               while (isNamed) {
                   System.out.println(contact.getName());
                   isNamed = false;
               }
                System.out.println(contact.getPhone());
            }
        }
        if (isNamed) {
            System.out.println("Контакт отсутствует");
        }
        System.out.println("—".repeat(14));
    }

    public static void print () {
        for (Contact contact : contacts) {
            System.out.println(contact.getInfo());
        }
    }
}
