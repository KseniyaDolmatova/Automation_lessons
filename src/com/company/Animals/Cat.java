package com.company.Animals;

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat() {
        catCount++;
        this.isFull = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    public void eat(FoodBowl bowl) {
        if (bowl.getFood() > 0) {
            if (bowl.getFood() >= 5) {
                bowl.decreaseFood(5);
                isFull = true;
                System.out.println("Кот поел и теперь сыт.");
            } else {
                System.out.println("У еды в тарелке недостаточно, кот не поел.");
            }
        } else {
            System.out.println("В тарелке нет еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}