package ru.gb.gexterio;


import java.util.Random;

public class Human implements Heroes {
    public String getName() {
        return name;
    }

    Random random = new Random();
    private final String name;
    private int runLimit = random.nextInt(2000);
    private int jumpLimit = random.nextInt(25);
    private boolean tired = false;

    public Human(String name) {
        this.name = name;
    }

    private void setEndChallenge() {
        setTired(true);
        System.out.println(getName() + " не дошел до конца");

    }

    public boolean isTired() {
        return tired;
    }

    public void setTired(boolean tired) {
        this.tired = tired;
    }

    public void run(int length) {
        if (runLimit >= length) {
            runLimit -= length;
            System.out.println(getName() + " пробежал" + length + " метров!");
        } else {
            setEndChallenge();
        }
    }

    @Override
    public void jump(int height) {

        if (jumpLimit >= height) {
            jumpLimit -= height;
            System.out.println(getName() + " перепрыгнул " + height + " метров!");
        } else {
            setEndChallenge();
        }
    }
}
