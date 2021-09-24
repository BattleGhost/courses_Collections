package org.example.task3;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    private int currentIndex;
    private final T[] array;

    public MyIterator(T[] array) {
        this.array = array;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public T next() {
        return array[currentIndex++];
    }
}
