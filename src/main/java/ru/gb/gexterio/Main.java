package ru.gb.gexterio;

import java.util.Scanner;

public class Main {

    private static final int EMPTY_CELL = 42; // *
    private static final int HUMAN_TURN = 88;  //X (крестик)
    private static final int AI_TURN = 79;  //O (нолик)
    private static final String HUMAN_TURN_MESSAGE = "Сделай свой ход, храбрец в формате: столбец, строка";
    private static final String AI_TURN_MESSAGE = "Свой ход делает Искусственный интеллект";
    private static final String GAME_OVER_MESSAGE = "GAME_OVER, Сэр. ";
    private static final String WIN_MESSAGE = "Ты победил, круто!";
    private static final String LOSE_MESSAGE = "Ты проиграл, рандом оказался сильнее!";
    private static final String NOBODY_MESSAGE = "Ничья! Люди и Компьютер равны";
    private static boolean gameOver = false;
    private static int cellToWin = 3;
    private static int fieldSize = 3;
    private static char[][] field;
    private static int turnCount = 0;


    public static void main(String[] args) {
        initialField();
        printField();
        while (true) {
            doHumanTurn();
            printField();
            if (checkWin((char) HUMAN_TURN)) {
                System.out.println(GAME_OVER_MESSAGE +WIN_MESSAGE);
                System.exit(0);
            } else if (isFieldFull()) {
                System.out.println(GAME_OVER_MESSAGE + NOBODY_MESSAGE);
            }
            doAITurn();
            printField();
            if (checkWin((char) AI_TURN)) {
                System.out.println(GAME_OVER_MESSAGE + LOSE_MESSAGE);
                System.exit(0);
            } else if (isFieldFull()) {
                System.out.println(GAME_OVER_MESSAGE + NOBODY_MESSAGE);
            }
        }
    }

    private static void doAITurn() {
        int y = 0;
        int x = 0;
        boolean check = false;
        System.out.println(AI_TURN_MESSAGE);
        while (!check) {
            x = (int) (Math.random() * fieldSize);
            y = (int) (Math.random() * fieldSize);
            check = isValidTurn(y, x);
        }
        field[y][x] = AI_TURN;
        turnCount++;
    }

    private static void doHumanTurn() {
        System.out.println(HUMAN_TURN_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        int y=0;
        int x=0;
        boolean check = false;
        while (!check) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            check = isValidTurn(y, x);
        }
        field[y][x] = HUMAN_TURN;
        turnCount++;
    }

    private static boolean isLine(int x, int y, int stepVertical, int stepHorizontal, char symb) {
        for (int i = 0; i < cellToWin; i++) {
            if (!isIndexOutOfField(y + i * stepVertical, x + i * stepHorizontal) || field[y + i * stepVertical][x + i * stepHorizontal] != symb) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char symb) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (i == 0 || i == fieldSize - 1 || j == 0 || j == fieldSize - 1) {
                    if (    isLine(i, j, 0, 1, symb) ||
                            isLine(i, j, 0, -1, symb) ||
                            isLine(i, j, 1, 0, symb) ||
                            isLine(i, j, -1, 0, symb) ||
                            isLine(i, j, 1, 1, symb) ||
                            isLine(i, j, 1, -1, symb) ||
                            isLine(i, j, -1, 1, symb) ||
                            isLine(i, j, -1, -1, symb)
                    ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isIndexOutOfField (int x, int y) {
        return (x >= 0 && x < fieldSize && y >= 0 && y < fieldSize);
    }



    public static boolean isValidTurn(int y, int x) {
        if (y >= 0 && y < fieldSize && x >= 0 && x < fieldSize && field[y][x] == EMPTY_CELL) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isFieldFull () {
        return (turnCount ==fieldSize*fieldSize);
    }

    private static void printField() {
        System.out.print("   ");
        for (int l = 0; l < fieldSize; l++) {
            System.out.print(l + " ");
        }
        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(" " + field[i][j]);
            }
            System.out.println();
        }
    }

    private static void initialField() {
        System.out.println("Введите размер поля от 3 до 5");
        Scanner scanner = new Scanner(System.in);
        boolean checkFieldSize = true;
        while (checkFieldSize) {
            fieldSize = scanner.nextInt();
            if (fieldSize >= 3 && fieldSize <= 5)
                checkFieldSize = false;
        }
        if (fieldSize > 3) {
            cellToWin = 4;
        } else {
            cellToWin = 3;
        }
        field = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = EMPTY_CELL;
            }
        }
    }
}
