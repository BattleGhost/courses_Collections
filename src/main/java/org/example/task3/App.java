package org.example.task3;

public class App {
    public static void main(String[] args) {
        MyList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(1);
        myArrayList.add(2);
        myArrayList.update(2, 1);
        myArrayList.update(3, 2);
        myArrayList.add(4);
        myArrayList.add(0, 0);
        System.out.println(myArrayList);
    }
}
