package com.company.Animals;

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;
    private int totalRunDistance = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println(name + " не может пробежать отрицательную дистанцию.");
        } else if (distance <= 200) {
            totalRunDistance += distance;
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(FoodBowl bowl) {
        if (!isFull && bowl.getFood() > 0) {
            isFull = true;
            bowl.decreaseFood(5);
            System.out.println(name + " поел из тарелки.");
        } else if (isFull) {
            System.out.println(name + " уже сыт.");
        } else {
            System.out.println(name + " не может поесть, в тарелке недостаточно еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public int getTotalRunDistance() {
        return totalRunDistance;
    }

    @Override
    public int getTotalSwimDistance() {
        return 0;
    }
}