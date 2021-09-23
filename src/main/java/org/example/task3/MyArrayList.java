package org.example.task3;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private T[] innerArray;
    private int currentLength;
    private int capacity;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialLength) {
        capacity = initialLength;
        innerArray = (T[]) new Object[capacity];
        currentLength = 0;
    }

    private T[] arrayView() {
        return Arrays.copyOfRange(innerArray, 0, currentLength);
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayView());
    }

    @Override
    public void add(T value, int position) {
        if (currentLength >= capacity) {
            capacity *= 1.5;
            T[] tempArray = (T[]) new Object[capacity];
            if (currentLength >= 0) {
                System.arraycopy(innerArray, 0, tempArray, 0, currentLength);
            }
            innerArray = tempArray;
        }
        if (position > currentLength) {
            throw new IndexOutOfBoundsException();
        } else if (position < currentLength) {
            System.arraycopy(innerArray, position, innerArray, position+1, currentLength-position);
            innerArray[position] = value;
            currentLength++;
        } else {
            innerArray[currentLength++] = value;
        }
    }

    public void add(T value) {
        add(value, currentLength);
    }

    @Override
    public void remove(int position) {
        System.arraycopy(innerArray, position+1, innerArray, position, currentLength - (position + 1));
        currentLength--;
    }

    @Override
    public void update(T newValue, int position) {
        innerArray[position] = newValue;
    }

    @Override
    public T get(int position) {
        if (position >= currentLength) {
            throw new IndexOutOfBoundsException();
        }
        return innerArray[position];
    }

    @Override
    public int size() {
        return currentLength;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(arrayView());
    }
}
