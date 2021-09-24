package org.example.task3;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private Node head;
    private int currentPosition;
    private Node currentNode;
    private int length;

    public MyLinkedList() {
        head = null;
        currentPosition = -1;
        length = 0;
    }

    class Node {
        private T value;
        private Node next;

        public Node() {
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public void add(T value, int position) {
        if (position > length) {
            throw new IndexOutOfBoundsException();
        }
        if (position < currentPosition) {
            currentPosition = 0;
            currentNode = head;
        }
        if (position == 0) {
            if (length == 0) {
                head = new Node(value, null);
                currentNode = head;
                currentPosition = 0;
            } else {
                head = new Node(value, head);
            }

        } else {
            while (currentPosition <= position) {
                currentNode = currentNode.getNext();
                currentPosition++;
            }
            Node newNode = new Node(value, currentNode.getNext());
            currentNode.setNext(newNode);
        }

        length++;
    }

    @Override
    public void add(T value) {
        add(value, length);
    }

    @Override
    public void remove(int position) {
        if (position >= length || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (position < currentPosition) {
            currentPosition = 0;
            currentNode = head;
        }
        if (position == 0) {
            head = head.getNext();
        } else {
            while (currentPosition < position) {
                currentNode = currentNode.getNext();
                currentPosition++;
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        length--;
    }

    @Override
    public void update(T newValue, int position) {
        if (position >= length || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (position < currentPosition) {
            currentPosition = 0;
            currentNode = head;
        }
        while (currentPosition <= position) {
            currentNode = currentNode.getNext();
            currentPosition++;
        }
        currentNode.setValue(newValue);

    }

    @Override
    public T get(int position) {
        if (position >= length || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (position < currentPosition) {
            currentPosition = 0;
            currentNode = head;
        }
        while (currentPosition <= position) {
            currentNode = currentNode.getNext();
            currentPosition++;
        }
        return currentNode.getValue();
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedIterator<>(head);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        this.forEach(val -> sb.append(val).append(", "));
        return sb.deleteCharAt(sb.length()-1).append("]").toString();
    }
}
