package com.company.Fruits;

public class FruitBoxTest {
    public static void main(String[] args) {
        // Создаем коробки для яблок и апельсинов
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        // Добавляем фрукты
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        // Проверяем вес коробок
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        // Сравниваем коробки
        System.out.println("Коробки равны по весу? " + appleBox.compare(orangeBox));

        // Пересыпаем яблоки в другую коробку
        Box<Apple> anotherAppleBox = new Box<>();
        appleBox.pourFruitsTo(anotherAppleBox);
        System.out.println("После пересыпания:");
        System.out.println("Вес первой коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес второй коробки с яблоками: " + anotherAppleBox.getWeight());
    }
}
