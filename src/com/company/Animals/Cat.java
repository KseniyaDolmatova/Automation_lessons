package com.company.Animals;

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;
    private int totalRunDistance = 0;

    public Cat(String name) {
        super(name);
        catCount++;
        this.isFull = false; // Кот изначально голоден
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
        if (bowl.getFood() > 0) {
            if (bowl.getFood() >= 5) {
                bowl.decreaseFood(5);
                isFull = true;
                System.out.println(name + " поел и теперь сыт.");
            } else {
                System.out.println(name + " не поел, так как еды недостаточно.");
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

    @Override
    public int getTotalRunDistance() {
        return totalRunDistance;
    }

    @Override
    public int getTotalSwimDistance() {
        return 0; // Коты не плавают
    }
}