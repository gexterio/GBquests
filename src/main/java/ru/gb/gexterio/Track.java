package ru.gb.gexterio;

public class Track implements Challenges{
    private final int length;

    public Track(int height) {
        this.length = height;
    }

    public int getLength() {
        return this.length;
    }
}
