package ru.gb.gexterio.HomeWork_1;

public class Contact {
    private final String name;
    private final String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String  getInfo() {
         return getName() + ": "+getPhone();
    }
}
