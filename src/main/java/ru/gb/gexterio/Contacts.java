package ru.gb.gexterio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Contacts {
   public static HashMap <String, HashSet<String>> directory = new HashMap<>();




    public static void add(String name, String number) {
        if (directory.containsKey(name)) {

        }
        directory.put(name,insideAdd(number));

    }

    public static HashSet<String> insideAdd (String number) {
        HashSet<String> phones = new HashSet<>();
        phones.add(number);
        return phones;
    }


    public static HashMap<String,  HashSet<String>> getDirectory() {
        return directory;
    }
}
