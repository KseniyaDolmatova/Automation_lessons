package com.company.Animals;

class FoodBowl {
    private int food; // Количество еды в миске

    public FoodBowl(int food) {
        this.food = Math.max(food, 0); // Еда не может быть отрицательной
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

