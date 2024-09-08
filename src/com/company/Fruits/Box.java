package com.company.Fruits;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    // Метод добавления фрукта в коробку
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    // Метод вычисления веса коробки
    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    // Метод сравнения двух коробок
    public boolean compare(Box<?> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    // Метод пересыпания фруктов в другую коробку
    public void pourFruitsTo(Box<T> otherBox) {
        if (otherBox == null) {
            return;
        }

        // Проверка на совместимость фруктов
        if (this.fruits.isEmpty()) {
            return; // Если текущая коробка пустая, ничего не пересыпаем
        }

        if (otherBox.fruits.isEmpty() || this.fruits.get(0).getClass().equals(otherBox.fruits.get(0).getClass())) {
            otherBox.fruits.addAll(this.fruits); // Пересыпаем фрукты, если типы совпадают
            this.fruits.clear(); // Очищаем текущую коробку
        } else {
            throw new IllegalArgumentException("Нельзя пересыпать фрукты разных типов!");
        }
    }

    // Метод получения списка фруктов (для вывода, если нужно)
    public List<T> getFruits() {
        return fruits;
    }
}