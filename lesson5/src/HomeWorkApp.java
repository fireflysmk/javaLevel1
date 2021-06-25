public class HomeWorkApp {
    public static void main(String[] args) {

        /*

        4. Создать массив из 5 сотрудников.
            Пример:
            Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
            persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
            persArray[1] = new Person(...);
            ...
            persArray[4] = new Person(...);

        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
         */

        Employee[] empArr = new Employee[5];

        empArr[0] = new Employee("Ivan", "Ivanov", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);

        empArr[1] = new Employee("Andrey", "Kuznetsov", "Programmer",
                "123123@mailbox.com", "892312312", 30000, 11);

        empArr[2] = new Employee("Petya", "Petrov", "Engineer",
                "sdfsdf@mailbox.com", "892312312", 30000, 12);

        empArr[3] = new Employee("Dima", "Sidorov", "Engineer",
                "123123@mailbox.com", "892312312", 30000, 70);

        empArr[4] = new Employee("Denis", "Denisov", "Engineer",
                "777777@mailbox.com", "892312312", 30000, 150);

        for (Employee a : empArr) {
            if (a.getAge() > 40)  a.employeeInfo();
        }



    }
}
