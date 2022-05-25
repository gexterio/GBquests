package ru.gb.gexterio;

//        1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
//        классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
//        консоль).
//        2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
//        должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
//        печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//        3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
//        этот набор препятствий.
//        4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
//        на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
//        препятствий не идет.



public class Main {
    public static void main(String[] args) {

        Heroes[] heroes = new Heroes[]{
                new Cat("Кузя"),
                new Human("Петр"),
                new Robot("BG-1"),
                new Human("Владимир"),
                new Cat("Васька"),
                new Robot("PZ-2000")
        };
        Challenges[] challenges = new Challenges[]{
                new Track(100),
                new Wall(5),
                new Track(500),
                new Track(150),
                new Wall(5),
                new Wall(5),
                new Track(300)
        };
        startChallenge(heroes, challenges);
    }


    public static void startChallenge(Heroes[] heroes, Challenges[] challenges) {
        for (Heroes hero : heroes) {
            System.out.println("-".repeat(20));
            for (Challenges challenge : challenges) {
                if (!hero.isTired()) {
                    if (challenge instanceof Track) {
                        hero.run(((Track) challenge).getLength());
                    } else if (challenge instanceof Wall) {
                        hero.jump(((Wall) challenge).getHeight());
                    }
                }
            }
            System.out.println("-".repeat(20));
            if (!hero.isTired()) {
                System.out.println("*".repeat(30));
                System.out.println("*** " + hero.getName() + " дошел до финиша!" + " ***");
                System.out.println("*".repeat(30));
            }
        }
    }
}
