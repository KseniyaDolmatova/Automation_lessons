package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private final Map<String, List<String>> phoneBook;

    // Конструктор класса
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления записей
    public void add(String surname, String phoneNumber) {
        // Если фамилия уже существует в справочнике, добавляем номер к существующему списку
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для получения списка номеров по фамилии
    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи в телефонный справочник
        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Петров", "987-654");
        phoneBook.add("Иванов", "456-789");
        phoneBook.add("Сидоров", "321-123");
        phoneBook.add("Петров", "654-321");

        // Запрашиваем номера по фамилии
        System.out.println("Телефоны Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phoneBook.get("Петров"));
        System.out.println("Телефоны Сидорова: " + phoneBook.get("Сидоров"));
        System.out.println("Телефоны Смирнова: " + phoneBook.get("Смирнов")); // Не существует
    }
}