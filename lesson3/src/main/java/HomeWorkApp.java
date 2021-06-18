import java.util.ArrayList;
import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {
        /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */

        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) a[i] = 1;
            else a[i] = 0;
        }

        System.out.println(Arrays.toString(a));

        /*
        2. Задать пустой целочисленный массив длиной 100.
        С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
         */
        int[] b = new int[100];
        for (int i = 0; i < b.length; i++) {
            b[i] = i + 1;
        }
        System.out.println(Arrays.toString(b));

        /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */

        int[] c = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < c.length; i++) {
            if (c[i] < 6) c[i] = c[i] * 6;
        }
        System.out.println(Arrays.toString(c));

        /*
        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        Определить элементы одной из диагоналей можно по следующему принципу:
        индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
         */
        int[][] aa = new int[5][5];
        System.out.println(aa.length);
        for (int i = 0; i < aa.length; i++){
            aa[i][i] = 1;
            aa[aa.length - 1 - i][i] = 1;
        }

        for (int i = 0; i < aa.length; i++) {
            System.out.println(Arrays.toString(aa[i]));
        }
        /*
        result:
        [1, 0, 0, 0, 1]
        [0, 1, 0, 1, 0]
        [0, 0, 1, 0, 0]
        [0, 1, 0, 1, 0]
        [1, 0, 0, 0, 1]
         */

        System.out.println(Arrays.toString( getIntArray(5, 22)));

        initArrayAndPrintMinMaxValues();

        int[] shiftArr = {1,2,3,4,5};
        int[] shiftArr2 = {20,30,40,5,5, 10, 20};

        arrayShiftIndex(shiftArr, 2);
        arrayShiftIndex(shiftArr2, 3);

    }

         /*
        5. Написать метод, принимающий на вход два аргумента: len и initialValue,
        и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
         */

    public static int[] getIntArray (int len, int initialValue) {

        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    /*
    6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
     */

    public static void initArrayAndPrintMinMaxValues() {

        int[] arr = {0, 4, 5, -40, 222, 0, 0, -2, 55};

        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("array: " + Arrays.toString(arr));
        System.out.println("min value: " + min);
        System.out.println("max value: " + max);


        int[]ccc = {2, 2, 2, 1, 2, 2, 10, 1};

        System.out.println(checkBalanceArray(ccc));

    }

    /*
    7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
**Примеры:
checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
     */

    public static boolean checkBalanceArray (int[] arr ) {

        int sumLeft = 0;
        int sumRight = 0;
        // {2, 2, 2, 1, 2, 2, 10, 1}

        for (int i = 0; i < arr.length; i++) {
            sumLeft+= arr[i];

            for (int j = arr.length - 1; j > i; j--) {
                sumRight+= arr[j];
            }
          //
          //  System.out.println("sumLeft: " + sumLeft);
          //  System.out.println("sumRight: " + sumRight);

            if (sumLeft == sumRight) {
                System.out.println("sumLeft == sumRight, Balance position  between arr[" + i + "] and arr[" + (i + 1)+ "]");
                return true;
            } else {
                sumRight = 0;
            }
        }
        return false;
    }

    /*
    8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций.
    Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    Примеры:
    [ 1, 2, 3 ]
    при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    [ 3, 5, 6, 1]
    при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.
     */

    public static void arrayShiftIndex (int[] arr, int delta) {

        System.out.println("input array: " + Arrays.toString(arr));

        // { 1, 2 ,3 }
        // { 2, 1 ,3 }
        // { 2, 3, 1 }

        int tempVal = 0;

        if (delta > 0 ) {
            for (int n = 0; n < delta; n++) {

                for (int i = 0; i < arr.length - 1; i++) {
                    tempVal = arr[i]; // 1 // 1
                    arr[i] = arr[i + 1]; //a[0] = 2 // a[1] = 3
                    arr[i + 1] = tempVal;// a[1] = 1 // a[2] = 1

                }
            }
        } else if (delta < 0) {
            delta = Math.abs(delta);

            /*

            Не успел продумать отрицательное смещение, начал за пару часов до урока...
            


            for (int n = 0; n < delta; n++) {
                // { 1, 2 ,3, 4}



                // {2, 3 ,4 ,1} <--


                for (int i = 0; i < arr.length - 1; i++) {
                    tempVal = arr[arr.length - 1]; // 3 // 1
                    arr[arr.length - 1] = arr[arr.length - 1 - 1]; //a[2] = 2 // a[1] = 3
                    arr[arr.length - 1 - 1] = tempVal;// a[1] = 1 // a[2] = 1

                }
            }

             */

        }

        System.out.println("result array: "  +Arrays.toString(arr));

    }


}
