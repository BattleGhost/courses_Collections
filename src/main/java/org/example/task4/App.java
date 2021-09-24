package org.example.task4;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        List<Integer> list = fillList(new ArrayList<>());
        Supplier<IntStream> streamSupplier = () -> list.stream().mapToInt(Integer::intValue);

        // 1. Найти среднее значение элементов массива
        double mean = streamSupplier.get().average().orElse(0);

        // 2. Найти минимальный элемент, значение и индекс
        int min = streamSupplier.get().min().orElse(Integer.MIN_VALUE);

        int minIndex = IntStream.range(0,list.size()).boxed()
                .min(Comparator.comparingInt(list::get)).orElse(-1);

        // 3. Посчитать количество элементов равных нулю
        long zeroes = streamSupplier.get().filter(v -> v == 0).count();

        // 4. Посчитать количество элементов больше нуля
        long graterThanZeroAmount = streamSupplier.get().filter(v -> v > 0).count();

        // 5. Помножить элементы массива на число
        int number = 2;
        List<Integer> newList = streamSupplier.get().boxed().map(v -> v*number).collect(Collectors.toList());

        System.out.println(list);
        System.out.println("Mean: " + mean);
        System.out.println("Min: " + min);
        System.out.println("Index of min: " + minIndex);
        System.out.println("Zeroes: " + zeroes);
        System.out.println("Grater than zero: " + graterThanZeroAmount);
        System.out.println(newList);
    }

    public static List<Integer> fillList(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }
}
