package ru.gb.gexterio;

public class MyArraySizeException extends RuntimeException{
    private final String MESSAGE = "Invalid array size!";
    private int size;
    public MyArraySizeException (int size) {
        this.size = size;

    }

}
