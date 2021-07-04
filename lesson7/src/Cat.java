package ru.geekbrains.java1.lesson7_OOP;

import java.util.Arrays;

public class Cat {
    private String name;
    private int appetite;
    private Flea[] fleas;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Bowl bowl) {
        bowl.decreaseFood(this.appetite);
        System.out.printf("Cat %s ate some food: %d\n", this.name, this.appetite);
    }

    public void setFleas(Flea[] fleas) {
        this.fleas = fleas;
    }

    public Flea[] getFleas() {
        return fleas;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", fleas=" + Arrays.toString(fleas) +
                '}';
    }
}
