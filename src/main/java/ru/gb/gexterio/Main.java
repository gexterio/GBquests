package ru.gb.gexterio;

import java.util.Scanner;

public class Main {

    private static boolean GAME_OVER = false;
    private static final int FIELD_SIZE = 5;
    private static final int EMPTY_CELL = 42; // *
    private static final int X = 88;  //X
    private static final int O = 79;  //O
    private static final String HUMAN_TURN_MESSAGE = "Сделай свой ход, храбрец в формате: столбец, строка";
    private static final String AI_TURN_MESSAGE = "Свой ход делает Искусственный интеллект";
    private static final String GAME_OVER_MESSAGE = "GAME_OVER, Сэр";
    private static final String WIN_MESSAGE = "Ты победил, круто!";
    private static char[][] actualField;

    private static int turnCount = 0;


    public static void main(String[] args) {
        initialField();
        printField();
        while (!GAME_OVER) {
            humanTurn();
            gameOverChecker();
            //   AITurn();
            //   gameOverChecker();
        }
    }

    private static void gameOverChecker() {
        if (turnCount == FIELD_SIZE * FIELD_SIZE + 1) {
            System.out.println(GAME_OVER_MESSAGE);
            GAME_OVER = true;
            System.exit(0);
        } else if (isWin()) {
            GAME_OVER = true;
            System.out.println(WIN_MESSAGE);
        }
    }

    private static boolean isWin() {
        int XCellCountRow = 0;
        int XCellCountColum = 0;
        int XCellCountMajorDiagonal = 0;
        int XCellCountMinorDiagonal = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (actualField[i][j] == X) {  // проверка на 3 в ряд
                    XCellCountRow++;
                }
            }
        }
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (actualField[i][i] == X) { // проверка на 3 в столбец
                    XCellCountColum++;
                }
            }
        }
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (i == j && actualField[i][j] == X) { //проверка на 3 по главной диагонали
                    XCellCountMajorDiagonal++;
                }
            }
        }
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (j == FIELD_SIZE - 1 - i && actualField[i][j] == X) {  //проверка на 3 по побочной диагонали
                    XCellCountMinorDiagonal++;
                }
            }
        }

        if (XCellCountRow ==1 || XCellCountColum ==1 || XCellCountMajorDiagonal ==1 || XCellCountMinorDiagonal ==1) {
            return true;
        } else {
            return false;
        }
    }


    private static void humanTurn() {
        System.out.println(HUMAN_TURN_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        boolean isEmpty = true;
        while (isEmpty) {
            int colum = scanner.next().toUpperCase().charAt(0) - 'A';
            int row = scanner.nextInt();
            if (actualField[row][colum] == EMPTY_CELL) {
                actualField[row][colum] = X;
                isEmpty = false;
                printField();
            }
        }
    }

    private static void AITurn() {
        boolean isEmpty = true;
        System.out.println(AI_TURN_MESSAGE);
        while (isEmpty) {
            int colum = (int) (Math.random() * FIELD_SIZE);
            int row = (int) (Math.random() * FIELD_SIZE);
            if (actualField[row][colum] == EMPTY_CELL) {
                actualField[row][colum] = O;
                isEmpty = false;
                printField();
            }
        }
    }


    public static void printField() {
        System.out.print("  ");
        for (char c = 'A'; c < 'A' + FIELD_SIZE; c++) {
            System.out.print(" " + c);
        }
        System.out.println();
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(" " + actualField[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        turnCount++;
    }

    public static void initialField() {
        actualField = new char[FIELD_SIZE][FIELD_SIZE]; //создание пустого поля
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                actualField[i][j] = EMPTY_CELL;
            }
        }
    }


}
