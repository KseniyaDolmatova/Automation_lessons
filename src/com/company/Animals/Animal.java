package com.company.Animals;

abstract class Animal {
    private static int animalCount = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
    public abstract int getTotalRunDistance();
    public abstract int getTotalSwimDistance();
}
