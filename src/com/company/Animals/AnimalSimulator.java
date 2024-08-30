package com.company.Animals;

public class AnimalSimulator {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        dog1.run(300);
        dog1.swim(-5);

        Dog dog2 = new Dog("Шарик");
        dog2.run(-200);
        dog2.swim(3);

// Создание котов
        Cat[] cats = {
                new Cat("Мурзик"),
                new Cat("Симба"),
                new Cat("Барсик")
        };

        FoodBowl bowl = new FoodBowl(15);

        cats[0].eat(bowl);
        cats[0].run(5);

        cats[1].eat(bowl);
        cats[1].run(-7);

        cats[2].eat(bowl);
        cats[2].run(10);

        for (Cat cat : cats) {
            System.out.println("Кот " + cat.name + (cat.isFull() ? " сыт" : " голоден"));
        }

        System.out.println("Создано животных: " + Animal.getAnimalCount());
        System.out.println("Создано собак: " + Dog.getDogCount());
        System.out.println("Создано котов: " + Cat.getCatCount());
    }
}