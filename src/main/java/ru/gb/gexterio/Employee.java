package ru.gb.gexterio;
// position, email, phone, salary, age.
public class Employee {
    private String name = "";
    private String position ="";
    private String email = "";
    private String phone = "";
    private int salary;
    private int age;

    public void printEmployee () {
        System.out.println("Name: " + getName());
        System.out.println("Position: " + getPosition());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
        System.out.println("Salary: " + getSalary());
        System.out.println("Age: " + getAge());
        System.out.println("---------------");
    }

    public Employee (String name, int age) {
        this (name,"", 0, age);
    }

    public Employee (String name, String position, int salary, int age) {
        this (name, position,"", "", salary, age);
    }

    public Employee (String name, String position, String email, String phone, int salary, int age) {

        setName(name);
        setPosition(position);
        setEmail(email);
        setPhone(phone);
        setSalary(salary);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>0 && age<150){
            this.age = age;
        }
    }
}

