
/*
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.

 */

public abstract class Animal {

    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    private static int animalCounter;

    public Animal(String name) {
        this.name = name;
        incrimentAnimalCounter();
    }

    public int getAnimalCounter() {
        return animalCounter;
    }

    public void incrimentAnimalCounter(){
        animalCounter++;
    }

    public void decrimentAnimalCounter(){
        animalCounter--;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {

        if (Math.abs(distance) <= maxRunDistance) {
            System.out.println(this.name + " пробежал " + distance +" м.");
        } else {
            System.out.println(this.name + " пробежал из " + distance + "м, только " + maxRunDistance + "м. и прилег отдохнуть");
        }
    }

    public void swim (int distance) {

        if (maxSwimDistance == 0) {
            System.out.println("Злая судьба направила бедного " + this.name + " в речку и он утонул" +
                    "\n (играет грустная музыка)");
            decrimentAnimalCounter();
        } else if (Math.abs(distance) <= maxSwimDistance) {
            System.out.println(this.name + " проплыл " + distance +" м.");
        } else {
            System.out.println(this.name + " проплыл из " + distance + "м. только " + maxSwimDistance + "м. и пошел ко дну" +
                    "\n (играет грустная музыка)");
            decrimentAnimalCounter();
        }
    }

    public boolean overcomeObstacles(Obtacles obtacles){
        int obtDist;

        obtDist = obtacles.getDistance();

        if (obtacles instanceof Road) {
            if (obtDist <= maxRunDistance) {
                System.out.println(name + " прошел препятствие " + obtacles.getObtacleName() + "(" + obtDist + "м.)");
                return true;
            } else {
                System.out.println(name + " не смог преодолеть препятствие " + obtacles.getObtacleName() + "(" + obtDist + "м.)");
            }
        } else if (obtacles instanceof River) {
            if (obtDist <= maxSwimDistance) {
                System.out.println(name + " прошел препятствие " + obtacles.getObtacleName() + "(" + obtDist + "м.)");
                return true;
            } else {
                System.out.println(name + " не смог преодолеть препятствие " + obtacles.getObtacleName() + "(" + obtDist + "м.)");
            }
        }
        return false;
    }

    /*

    5 **** Сделать классы препятствий дорога и водоём. У них будет длина.
    Сделать в животных методы преодоления препятствий.
    Сделать массив разных животных и массив препятствий.
    Заставить животных пройти все препятствия, причем если животное не преодолело одно из - то оно выбывает и дальше не пробует.
     */


}
