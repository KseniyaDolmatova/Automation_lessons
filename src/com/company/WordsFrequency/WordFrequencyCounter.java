package com.company.WordsFrequency;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Создаем массив с повторяющимися словами
        String[] words = {
                "яблоко", "банан", "апельсин", "яблоко", "банан",
                "киви", "лимон", "апельсин", "киви", "банан",
                "яблоко", "виноград", "киви", "банан", "манго", "манго",
                "лимон", "виноград", "киви", "яблоко", "апельсин"
        };

        // Создаем экземпляр класса WordFrequency и выводим частоты
        WordFrequency wordFrequency = new WordFrequency(words);
        wordFrequency.printWordFrequencies();
    }
}
