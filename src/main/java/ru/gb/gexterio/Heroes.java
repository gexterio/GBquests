package ru.gb.gexterio;

// 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
//        классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
//        консоль).
public interface Heroes {
    String getName();
    boolean isTired();

    void jump(int height);

    void run(int length);

}


