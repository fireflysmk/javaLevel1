package ru.geekbrains.java1.lesson7_OOP;

public class Bowl {
    private int foodAmount;

    public void putFood(int amount) {
        this.foodAmount += amount;
    }

    public void decreaseFood(int amount) {
        if (this.foodAmount - amount < 0 ) {
            System.out.println("в миске недостаточно еды");
        } else {
            this.foodAmount -= amount;
        }

    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
