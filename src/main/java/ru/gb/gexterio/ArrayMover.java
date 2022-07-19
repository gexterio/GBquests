package ru.gb.gexterio;

import java.util.ArrayList;
import java.util.List;

public class ArrayMover<T extends Object> {

    public <T> void changeItemsBetweenArrays (T[] array, int firstIndex, int secondIndex ) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public <T> ArrayList<T> arrayToList (T[] array) {
        return new ArrayList<T>(List.of(array));
    }
}
