package org.example.task2;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> list = new DeleteSafeArrayList<>();
        list.add("Some value");
        try {
            list.remove(0);
        } catch (UnsupportedOperationException e) {
            System.err.println("Can`t delete from this list.");
        }
        System.out.println(list);
    }
}
