package com.company.Animals;

class FoodBowl {
    private int food;

    public FoodBowl(int food) {
        this.food = Math.max(food, 0);
    }

    public void decreaseFood(int amount) {
        if (amount <= food) {
            food -= amount;
        } else {
            System.out.println("Недостаточно еды в тарелке.");
        }
    }

    public int getFood() {
        return food;
    }
}

