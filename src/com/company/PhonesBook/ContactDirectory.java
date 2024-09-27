package com.company.PhonesBook;

public class ContactDirectory {
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
