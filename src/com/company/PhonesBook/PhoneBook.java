package com.company.PhonesBook;

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
}
