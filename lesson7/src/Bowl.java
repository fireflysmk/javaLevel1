package ru.geekbrains.java1.lesson7_OOP;

public class Bowl {
    private int foodAmount;

    public void putFood(int amount) {
        this.foodAmount += amount;
    }

    public void decreaseFood(int amount) {
        this.foodAmount -= amount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
