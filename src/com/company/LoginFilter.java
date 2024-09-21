package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoginFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();

        System.out.println("Введите логины (введите пустую строку для завершения ввода):");

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            logins.add(input); // добавляем логин в список
        }

        // Фильтрация логинов, начинающихся на 'f'
        List<String> filteredLogins = logins.stream()
                .filter(login -> login.startsWith("f")) // фильтрация по первой букве
                .collect(Collectors.toList());

        // Вывод результата
        System.out.println("Логины, начинающиеся на букву 'f':");
        filteredLogins.forEach(System.out::println);

        scanner.close(); // Закрываем сканер
    }
}