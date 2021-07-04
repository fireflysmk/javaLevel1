package ru.geekbrains.java1.lesson7_OOP;

public class Fighter {
    private String name;
    private int health;
    private int damage;

    public Fighter(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void hit(Fighter another) {
        another.health -= this.damage;
        System.out.printf("%s hits %s and makes %d damage. %s health left: %d\n", this.name, another.name, this.damage, another.name, another.health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}
