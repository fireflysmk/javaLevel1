public class HomeWork {
    public static void main(String[] args) {

        Animal cat = new Cat("Barsik");
        System.out.println("количество животных: " + cat.getAnimalCounter());
        cat.run(444);
        cat.run(20);
        cat.swim(5);
        System.out.println("количество животных: " + cat.getAnimalCounter());

        Animal dog = new Dog("Kasper");
        System.out.println("количество животных: " + cat.getAnimalCounter());
        dog.run(1000);
        dog.run(20);
        dog.swim(5);
        dog.swim(15);
        System.out.println("количество животных: " + cat.getAnimalCounter());

        River river1 = new River(5);
        River river2 = new River(8);

        Road road1 = new Road(190);
        Road road2 = new Road(220);

        Animal[] animals = new Animal[2];
        animals[0] = cat;
        animals[1] = dog;

        Obtacles[] obtacles = new Obtacles[4];
        obtacles[0] = road1;
        obtacles[1] = road2;
        obtacles[2] = river1;
        obtacles[3] = river2;

        for (int i = 0; i < animals.length; i++) {
            boolean checkResult = false;
            for (int j = 0; j < obtacles.length; j++) {
                checkResult = animals[i].overcomeObstacles(obtacles[j]);
                if (!checkResult) break;
            }
            if (checkResult) {
                System.out.println(animals[i].getName() + " прошел все препятствия");
            }
            else {
                System.out.println(animals[i].getName() + " сошел с дистанции");
            }

        }

    }
}
