package com.company.WordsFrequency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordFrequency {

    private String[] words; // Массив слов
    private Map<String, Integer> wordCount; // Хранит частоту слов
    private Set<String> uniqueWords; // Хранит уникальные слова

    // Конструктор
    public WordFrequency(String[] words) {
        this.words = words;
        this.wordCount = new HashMap<>();
        this.uniqueWords = new HashSet<>();
        countWords();
    }

    // Метод для подсчёта слов
    private void countWords() {
        for (String word : words) {
            uniqueWords.add(word); // Добавляем слово в уникальные слова
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1); // Обновляем частоту слова
        }
    }

    // Метод для вывода уникальных слов и их количества
    public void printWordFrequencies() {
        System.out.println("Уникальные слова и их количество:");
        for (String uniqueWord : uniqueWords) {
            System.out.println(uniqueWord + ": " + wordCount.get(uniqueWord) + " раз(а)");
        }
    }
}