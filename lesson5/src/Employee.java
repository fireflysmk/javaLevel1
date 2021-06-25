
/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 */

public class Employee {

    private String name;
    private String lastName;
    private String position;
    private String email;
    private String phoneNum;
    private int salary;
    private int age;

    public Employee(String name, String lastName, String position, String email, String phoneNum, int salary, int age) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }



    public void employeeInfo () {
        System.out.println("name: " + this.name);
        System.out.println("lastName: " + this.lastName);
        System.out.println("position: " + this.position);
        System.out.println("email: " + this.email);
        System.out.println("phoneNum: " + this.phoneNum);
        System.out.println("salary: " + this.salary);
        System.out.println("age: " + this.age);
        System.out.println("======================");

    }


}
