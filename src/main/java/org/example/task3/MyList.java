package org.example.task3;

public interface MyList<T> extends Iterable<T> {
    void add(T value, int position);
    void add(T value);
    void remove(int position);
    void update(T newValue, int position);
    T get(int position);
    int size();

}
