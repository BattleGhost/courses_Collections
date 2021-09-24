package org.example.task3;

import java.util.Iterator;

public class MyLinkedIterator<T> implements Iterator<T> {
    private MyLinkedList<T>.Node node;

    public MyLinkedIterator(MyLinkedList<T>.Node node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node.getNext() != null;
    }

    @Override
    public T next() {
        node = node.getNext();
        return node.getValue();
    }
}
