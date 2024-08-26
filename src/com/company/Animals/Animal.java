package com.company.Animals;

abstract class Animal {
    private static int animalCount = 0; // Счетчик животных

    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
}