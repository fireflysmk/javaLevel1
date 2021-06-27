
public class HomeWorkApp {
    public static void main(String[] args) {

        System.out.println(isSumInsideRange(5,10));
        System.out.println(isSumInsideRange(100,10));

        isNumberPositiveOrNegative(5);
        isNumberPositiveOrNegative(0);
        isNumberPositiveOrNegative(-4);

        System.out.println(isNumberPositiveOrNegativeBol(-20));

        printInputString("blabla", 4);

        isYearLeap(4);
        isYearLeap(100);
        isYearLeap(200);
        isYearLeap(400);
        isYearLeap(500);
        isYearLeap(800);

    }

    public static boolean isSumInsideRange(int num1, int num2) {
        if (num1 + num2 > 10 && num1 + num2 <= 20)
            return true;
        else
            return false;
    }

    public static void isNumberPositiveOrNegative(int num) {
        if (num >= 0) {
            System.out.println("input number is positive");
        } else {
            System.out.println("input number is negative");
        }
    }
    /*
    3. Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    */
    public static boolean isNumberPositiveOrNegativeBol (int num) {
        if (num >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
    4. Написать метод, которому в качестве аргументов передается строка и число,
    метод должен отпечатать в консоль указанную строку, указанное количество раз;
     */

    public static void printInputString (String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    /*
    5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */

    public static boolean isYearLeap (int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                System.out.println("year "+ year + "  is Leap!");
                return true;
            } else return false;
        } else return false;

    }

}