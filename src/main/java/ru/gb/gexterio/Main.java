package ru.gb.gexterio;


public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ivan", "DevopsDeveloper", "ivan@com", "+1232220022", 2000, 22);
        Employee emp2 = new Employee("Nadya","Manager", 1000, 20 );
        Employee emp3 = new Employee("Vasya", 41);
        Employee emp4 = new Employee("Dima", 24);
        Employee emp5 = new Employee("Larisa", 44);
        Employee[] employees = new Employee[5];
       employees[0] = emp1;
       employees[1] = emp2;
       employees[2] = emp3;
       employees[3] = emp4;
       employees[4] = emp5;
        for (Employee employee : employees) { //Вывод работников с возрастом >40 лет
            int temp = employee.getAge();
            if (temp > 40) {
                employee.printEmployee();
            }
        }
    }
}
