package com.company;

import java.util.Arrays;
import java.util.List;

public class StringSorter {

    public static void main(String[] args) {
        // Заданная коллекция строк
        List<String> strings = Arrays.asList("f10", "f15", "f2", "f4", "f4");

        // Сортировка коллекции по возрастанию с учетом чисел в строках
        String[] sortedArray = strings.stream()
                .sorted((s1, s2) -> {
                    // Извлекаем численные части строк для сравнения
                    int num1 = Integer.parseInt(s1.replaceAll("\\D+", ""));
                    int num2 = Integer.parseInt(s2.replaceAll("\\D+", ""));
                    return Integer.compare(num1, num2);
                })
                .toArray(String[]::new);

        // Вывод отсортированного массива
        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));
    }
}
