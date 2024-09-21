package com.company;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

    public static void main(String[] args) {
        // Создаем массив с повторяющимися словами
        String[] words = {
                "яблоко", "банан", "апельсин", "яблоко", "банан",
                "киви", "лимон", "апельсин", "киви", "банан",
                "яблоко", "виноград", "киви", "банан", "манго",
                "лимон", "виноград", "киви", "яблоко", "апельсин"
        };

        // Используем HashMap для хранения слов и их частоты
        HashMap<String, Integer> wordCount = new HashMap<>();

        // Подсчитываем количество каждого слова
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Выводим уникальные слова и их количество
        System.out.println("Уникальные слова и их количество:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)");
        }
    }
}