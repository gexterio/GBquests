package ru.gb.gexterio;

public class Wall implements Challenges {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
