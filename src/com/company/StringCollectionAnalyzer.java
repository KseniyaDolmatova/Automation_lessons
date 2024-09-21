package com.company;

import java.util.Arrays;
import java.util.List;

public class StringCollectionAnalyzer {

    public static void main(String[] args) {
        // Заданная коллекция строк
        List<String> strings = Arrays.asList("Highload", "High", "Load", "Highload");

        // Подсчет количества вхождений "High"
        long countHigh = strings.stream()
                .filter(s -> s.equals("High"))
                .count();
        System.out.println("Объкт 'High' встречается " + countHigh + " раз(а)");

        // Получение первого элемента
        String firstElement = strings.stream()
                .findFirst()
                .orElse("0"); // Если коллекция пуста, возвращаем "0"
        System.out.println("Первый элемент: " + firstElement);

        // Получение последнего элемента
        String lastElement = strings.stream()
                .reduce((first, second) -> second)
                .orElse("0"); // Если коллекция пуста, возвращаем "0"
        System.out.println("Последний элемент: " + lastElement);
    }

}