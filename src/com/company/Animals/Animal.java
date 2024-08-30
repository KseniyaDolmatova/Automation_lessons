package com.company.Animals;

abstract class Animal {
    protected String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public abstract int getTotalRunDistance();

    public abstract int getTotalSwimDistance();

    public static int getAnimalCount() {
        return animalCount;
    }
}
