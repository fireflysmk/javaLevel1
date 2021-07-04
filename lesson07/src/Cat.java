package ru.geekbrains.java1.lesson7_OOP;

import java.util.Arrays;
/*

1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
 */
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
