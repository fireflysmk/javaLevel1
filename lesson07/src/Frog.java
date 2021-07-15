package ru.geekbrains.java1.lesson7_OOP;

public class Frog {
    private String name;
    private Heart heart;
    private Paw pawFrontLeft;
    private Paw pawFrontRight;
    private Paw pawBackLeft;
    private Paw pawBackRight;
    private Liver liver;

     public Frog(String name) {
        this.name = name;
        this.heart = new Heart();
        this.pawFrontLeft = new Paw();
        this.pawFrontRight = new Paw();
        this.pawBackLeft = new Paw();
        this.pawBackRight = new Paw();
        this.liver = new Liver();
    }

    public void doSomething() {
//        System.out.println(weight); // нельзя напрямую обратиться к полю или методу внутреннего класса
        System.out.println(this.heart.weight);
    }

    public String getName() {
        return name;
    }

    public Heart getHeart() {
        return heart;
    }

    public Paw getPawFrontLeft() {
        return pawFrontLeft;
    }

    public Paw getPawFrontRight() {
        return pawFrontRight;
    }

    public Paw getPawBackLeft() {
        return pawBackLeft;
    }

    public Paw getPawBackRight() {
        return pawBackRight;
    }

    public Liver getLiver() {
        return liver;
    }

    @Override
    public String toString() {
        return "Frog{" +
                "name='" + name + '\'' +
                ", heart=" + heart +
                ", pawFrontLeft=" + pawFrontLeft +
                ", pawFrontRight=" + pawFrontRight +
                ", pawBackLeft=" + pawBackLeft +
                ", pawBackRight=" + pawBackRight +
                ", liver=" + liver +
                '}';
    }

    class Heart { //Inner class
        private int weight;

        public Heart() {
            this.weight = 10;
        }

        public void doSomething() {
//            Frog.this.doSomething();
            NestedClass nc = new NestedClass("ldfjnb");
            System.out.println(nc.field);
            System.out.println(name); // Из внутреннего класса можно обратиться к любому полю или методу внешнего
        }
    }

    class Paw {

    }

    class Liver {

    }

    static class NestedClass { //Nested class
         private String field;

        public NestedClass(String field) {
            this.field = field;
        }

        public void doSomething() {
            Frog f = new Frog("ljdjf b");
            System.out.println(f.name);
//            System.out.println(name);
        }
    }
}
