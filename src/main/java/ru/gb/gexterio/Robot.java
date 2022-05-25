package ru.gb.gexterio;

import java.util.Random;

public class Robot implements Heroes {
    Random random = new Random();
    private final String name;
    private int runLimit = random.nextInt(500);
    private int jumpLimit = random.nextInt(20);
    private boolean tired;

    public Robot(String name) {
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

    public String getName() {
        return name;
    }
}
