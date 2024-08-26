package com.company.Animals;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.run(300);
        dog.swim(5);

        Cat[] cats = {new Cat(), new Cat(), new Cat()};
        FoodBowl bowl = new FoodBowl(15);

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + (cats[i].isFull() ? " сыт" : " голоден"));
        }

        System.out.println("Создано животных: " + Animal.getAnimalCount());
        System.out.println("Создано собак: " + Dog.getDogCount());
        System.out.println("Создано котов: " + Cat.getCatCount());
    }
}
