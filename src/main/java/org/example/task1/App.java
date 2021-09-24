package org.example.task1;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        List<Integer> list = fillList(new ArrayList<>());
        Map<Integer, Integer> map = new TreeMap<>();
        list.forEach(key -> {
            if (map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        });
        System.out.println(list);
        System.out.println("Items amount: " + map);
    }

    public static List<Integer> fillList(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }
}
