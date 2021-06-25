import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int winLineLenght;

    private static int scoreHuman;
    private static int scoreAI;

    private static int sneakyAiX;
    private static int sneakyAiY;

    public static void main(String[] args) {
        while (true) {
            playRound();
            System.out.printf("SCORE IS: HUMAN   AI\n            %d     %d\n", scoreHuman, scoreAI);
            System.out.print("Wanna play again? Y or N >>> ");
            if (!SCANNER.next().toLowerCase().equals("y")) break;
        }
    }

    private static void playRound() {
        System.out.println("please input field size, for example: 5 5 ");
        int inputSizeX = SCANNER.nextInt();
        int inputSizeY = SCANNER.nextInt();

        System.out.println("please input winLineLenght, for example: 3");

        int winLenght = SCANNER.nextInt();

        initField(inputSizeX, inputSizeY, winLenght);
        printField();
        while (true) {
            humanTurn();
            printField();
            if (gameCheck(DOT_HUMAN)) break;
            aiTurn();
            printField();
            if (gameCheck(DOT_AI)) break;
        }
    }

    private static boolean gameCheck(char dot) {
        if (checkDraw()) {
            System.out.println("DRAW!!!");
            return true;
        }

        if (checkWin(dot, fieldSizeX, fieldSizeY, winLineLenght)) {
            if (dot == DOT_HUMAN) {
                System.out.println("HUMAN wins!!!");
                scoreHuman++;
            } else {
                System.out.println("AI wins!!!");
                scoreAI++;
            }
            return true;
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) return false;
            }
        }
        return true;
    }

    /*
    * Сделать проверку победы с помощью циклов
    * ** Сделать проверку победы на поле 5х5 и длина последовательности 4
    * *** Сделть проверку на любой произвольный размер поля и произвольную длину последовательности
     */
    private static boolean checkWin(char dot, int fieldSizeX, int fieldSizeY, int winLineLenght) {

        // ------->
        // горизонталь по Х
        for (int y = 0; y < fieldSizeY; y++) {

            int winSeq = 0;

            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][y] == dot){
                    winSeq++;
                    if (winSeq == winLineLenght) return true;
                } else winSeq = 0;
            }
        }

        // вертикаль, проверка Y
        for (int x = 0; x < fieldSizeX; x++) {

            int winSeq = 0;

            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == dot){
                    winSeq++;
                    if (winSeq == winLineLenght) return true;
                } else winSeq = 0;
            }
        }
        // диагональ сверху вниз

        //проход по всем точкам поля (ХХ и YY)
        for (int XX = 0; XX < fieldSizeX; XX++) {
            for (int YY = 0; YY < fieldSizeY; YY++) {
                int winSeq = 0;
                // из каждой точки инкремент по диагонали вниз
                for (int y = YY, x = XX; isCellValid(x,y); y++, x++) {

                    if (field[x][y] == dot){
                        winSeq++;
                       // System.out.println("winseq: " + winSeq);
                        if (winSeq == winLineLenght) return true;
                    } else winSeq = 0;

                }

            }
        }
        // диагональ снизу вверх

        //проход по всем точкам поля (ХХ и YY)
        for (int XX = 0; XX < fieldSizeX; XX++) {
            for (int YY = 0; YY < fieldSizeY; YY++) {

                int winSeq = 0;
                // из каждой точки инкремент по диагонали вверх
                for (int y = YY, x = XX; isCellValid(x,y); y--, x++) {
                    if (field[x][y] == dot){
                        winSeq++;
                        if (winSeq == winLineLenght) return true;
                    } else winSeq = 0;
                }
            }
        }
        return false;
    }



    // копипаст метода выше для усложнения компа, проверяем если хитрый человек вот вот выйграет, делаем подлянку
    // отличие метода только в том что проверяем winSeq == winLineLenght - 1 (вместо winLineLenght)
    // если нашли то заполняем координаты "Блокирующего хода победы" [sneakyAiX,sneakyAiY]

    private static boolean checkAlmostWin(char dot, int fieldSizeX, int fieldSizeY, int winLineLenght) {

        // ------->
        // горизонталь по Х
        for (int y = 0; y < fieldSizeY; y++) {

            int winSeq1 = 0;

            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == dot){
                 //   System.out.println("field[x][y] == dot");
                    winSeq1++;
                 //   System.out.println("winSeq1: " + winSeq1);
                    if (winSeq1 == (winLineLenght - 1)) {

                       // System.out.println("winSeq == winLineLenght - 1)");
                        if (isCellValid(y, x+1)) {
                            sneakyAiX = x + 1;
                            sneakyAiY = y;
                            System.out.println("sneakyAiX: " + sneakyAiX);
                            System.out.println("sneakyAiY: " + sneakyAiY);

                        } else {
                          // значит уперлись в стенку, делаем ход с другой стороны последовательности
                            sneakyAiX = x - winSeq1 - 1 ;
                            sneakyAiY = y;
                        }
                        return true;
                    }
                } else {
                    System.out.println("else");
                    winSeq1 = 0;
                }
            }
        }

        // вертикаль, проверка Y
        for (int x = 0; x < fieldSizeX; x++) {

            int winSeq = 0;

            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == dot){
                    winSeq++;

                    if (winSeq == winLineLenght - 1) {
                        if (isCellValid(y +  1, x)) {
                            sneakyAiX = x;
                            sneakyAiY = y + 1;
                        } else {
                            // значит уперлись в стенку, делаем ход с другой стороны последовательности
                            sneakyAiX = x;
                            sneakyAiY = y - winSeq - 1;
                        }
                        return true;
                    }
                } else winSeq = 0;
            }
        }
        // диагональ сверху вниз

        //проход по всем точкам поля (ХХ и YY)
        for (int XX = 0; XX < fieldSizeX; XX++) {
            for (int YY = 0; YY < fieldSizeY; YY++) {
                int winSeq = 0;
                // из каждой точки инкремент по диагонали вниз
                for (int y = YY, x = XX; isCellValid(y,x); y++, x++) {

                    if (field[y][x] == dot){
                        winSeq++;

                        if (winSeq == winLineLenght - 1) {
                            if (isCellValid(y + 1, x + 1)) {
                                sneakyAiX = x + 1;
                                sneakyAiY = y + 1;
                                System.out.println("sneakyAiX: " + sneakyAiX);
                                System.out.println("sneakyAiY: " + sneakyAiY);
                            } else {
                                // значит уперлись в стенку, делаем ход с другой стороны последовательности
                                sneakyAiX = x - winSeq - 1;
                                sneakyAiY = y - winSeq - 1;
                            }
                            return true;
                        }

                    } else winSeq = 0;

                }

            }
        }
        // диагональ снизу вверх

        //проход по всем точкам поля (ХХ и YY)
        for (int XX = 0; XX < fieldSizeX; XX++) {
            for (int YY = 0; YY < fieldSizeY; YY++) {

                int winSeq = 0;
                // из каждой точки инкремент по диагонали вверх
                for (int y = YY, x = XX; isCellValid(y,x); y--, x++) {
                    if (field[y][x] == dot){
                        winSeq++;
                        if (winSeq == winLineLenght - 1) {
                            if (isCellValid(y - 1, x + 1)) {
                                sneakyAiX = x + 1;
                                sneakyAiY = y - 1;
                                System.out.println("sneakyAiX: " + sneakyAiX);
                                System.out.println("sneakyAiY: " + sneakyAiY);
                            } else {
                                // значит уперлись в стенку, делаем ход с другой стороны последовательности
                                sneakyAiX = x + winSeq + 1;
                                sneakyAiY = y - winSeq - 1;
                            }
                            return true;
                        }
                    } else winSeq = 0;
                }
            }
        }
        return false;
    }

    /*
    ***** Сделать более умного ИИ
     */
    private static void aiTurn() {
        int x, y;

        if (checkAlmostWin(DOT_HUMAN, fieldSizeX, fieldSizeY,  winLineLenght)) {
            x = sneakyAiX;
            y = sneakyAiY;

            if (isCellEmpty(y, x) && isCellValid(y,x)) {
                field[y][x] = DOT_AI;
            }
            else {
                do {
                    x = RANDOM.nextInt(fieldSizeX);
                    y = RANDOM.nextInt(fieldSizeY);
                } while (!isCellEmpty(y, x));
                field[y][x] = DOT_AI;
            }
        } else {
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isCellEmpty(y, x));
            field[y][x] = DOT_AI;
        }

    }

    private static void humanTurn() {
        int x, y;

        do {
            System.out.print("Please enter coordinates of your turn x & y with whitespace >>>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(y, x) || !isCellEmpty(y, x));

        field[y][x] = DOT_HUMAN;
    }

    private static boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void initField(int sizeX, int sizeY, int winLenght) {
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        winLineLenght = winLenght;

        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX * 2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
//        for (int y = 0; y < fieldSizeY; y++) {
//            for (int x = 0; x < fieldSizeX; x++) {
//                System.out.print(field[y][x] + " ");
//            }
//            System.out.println();
//        }
    }
}
