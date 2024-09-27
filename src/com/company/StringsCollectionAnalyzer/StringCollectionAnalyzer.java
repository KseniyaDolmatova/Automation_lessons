package com.company.StringsCollectionAnalyzer;

import java.util.Arrays;
import java.util.List;

public class StringCollectionAnalyzer {

    public static void main(String[] args) {
        // Заданная коллекция строк
        List<String> strings = Arrays.asList("Highload", "High", "Load", "Highload");

        // Подсчет количества вхождений "High"
        long countHigh = StringCollectionUtil.countOccurrences(strings, "High");
        System.out.println("Объект 'High' встречается " + countHigh + " раз(а)");

        // Получение первого элемента
        try {
            String firstElement = StringCollectionUtil.getFirstElement(strings);
            System.out.println("Первый элемент: " + firstElement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Получение последнего элемента
        try {
            String lastElement = StringCollectionUtil.getLastElement(strings);
            System.out.println("Последний элемент: " + lastElement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}