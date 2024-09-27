package com.company.StringsCollectionAnalyzer;

import java.util.List;

public class StringCollectionUtil {

    // Метод для подсчета вхождений строки в коллекции
    public static long countOccurrences(List<String> strings, String target) {
        return strings.stream().filter(s -> s.equals(target)).count();
    }

    // Метод для получения первого элемента коллекции
    public static String getFirstElement(List<String> strings) throws Exception {
        if (strings.isEmpty()) {
            throw new Exception("Коллекция пуста, первый элемент не существует.");
        }
        return strings.get(0);
    }

    // Метод для получения последнего элемента коллекции
    public static String getLastElement(List<String> strings) throws Exception {
        if (strings.isEmpty()) {
            throw new Exception("Коллекция пуста, последний элемент не существует.");
        }
        return strings.get(strings.size() - 1);
    }
}