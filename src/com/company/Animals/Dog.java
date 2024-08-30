package com.company.Animals;

class Dog extends Animal {
    private static int dogCount = 0;
    private int totalRunDistance = 0;
    private int totalSwimDistance = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println(name + " не может пробежать отрицательную дистанцию.");
        } else if (distance <= 500) {
            totalRunDistance += distance;
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 0) {
            System.out.println(name + " не может плыть отрицательную дистанцию.");
        } else if (distance <= 10) {
            totalSwimDistance += distance;
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public int getTotalRunDistance() {
        return totalRunDistance;
    }

    @Override
    public int getTotalSwimDistance() {
        return totalSwimDistance;
    }
}