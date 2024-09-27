package com.company;

import java.util.Arrays;
import java.util.Random;

public class EvenNumberCounter {

    public static void main(String[] args) {
        // Генерация случайного набора чисел
        int[] randomNumbers = generateRandomNumbers();

        // Подсчет четных чисел
        int evenCount = countEvenNumbers(randomNumbers);

        System.out.println("Сгенерированные числа: " + Arrays.toString(randomNumbers));
        System.out.println("Количество четных чисел: " + evenCount);
    }

    // Метод для генерации массива случайных чисел
    private static int[] generateRandomNumbers() {
        Random random = new Random();
        return random.ints(50, 0, 100).toArray(); // Генерация чисел от 0 до 99
    }

    // Метод для подсчета четных чисел с использованием Stream API
    private static int countEvenNumbers(int[] numbers) {
        return (int) Arrays.stream(numbers)
                .filter(number -> number % 2 == 0) // Фильтруем чётные числа
                .count(); // Считаем их количество
    }
}

