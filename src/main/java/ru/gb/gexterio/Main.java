package ru.gb.gexterio;

import java.util.Scanner;

public class Main {

    private static boolean GAME_OVER = false;
    private static  int CELL_TO_WIN = 3;
    private static  int FIELD_SIZE = 3;  //размер поля
    private static final int EMPTY_CELL = 42; // *
    private static final int X = 88;  //X (крестик)
    private static final int O = 79;  //O (нолик)
    private static final String HUMAN_TURN_MESSAGE = "Сделай свой ход, храбрец в формате: столбец, строка";
    private static final String AI_TURN_MESSAGE = "Свой ход делает Искусственный интеллект";
    private static final String GAME_OVER_MESSAGE = "GAME_OVER, Сэр";
    private static final String WIN_MESSAGE = "Ты победил, круто!";
    private static final String LOSE_MESSAGE = "Ты проиграл, рандом оказался сильнее!";
    private static final String NOBODY_MESSAGE = "Ничья! Люди и Компьютер равны";
    private static char[][] actualField; //актуальное состояние игрового поля

    private static int turnCount = 0; //счетчик ходов


    public static void main(String[] args) {
        initialField();
        printField();
        while (!GAME_OVER) {
            humanTurn();
            gameOverChecker();
            AITurn();
            gameOverChecker();
        }
    }

    private static void gameOverChecker() {
        if (turnCount == FIELD_SIZE * FIELD_SIZE) { //проверка на заполнение поля
            doNobody();

        }

    }
    private static void direction (int row, int column, int dir) {
        if () {
        }
    }


    private static void doWin() {
        GAME_OVER = true;
        System.out.println(GAME_OVER_MESSAGE + ". " + WIN_MESSAGE);
        System.exit(0);
    }

    private static void doLose() {
        GAME_OVER = true;
        System.out.println(GAME_OVER_MESSAGE + ". " + LOSE_MESSAGE);
        System.exit(0);
    }
    private static void doNobody () {
        GAME_OVER = true;
        System.out.println(GAME_OVER_MESSAGE + "." + NOBODY_MESSAGE);
        System.exit(0);
    }


    private static void humanTurn() {  //Ход игрока
        Scanner scanner = new Scanner(System.in);
        boolean isEmpty = true;
        System.out.println(HUMAN_TURN_MESSAGE);
        while (isEmpty) {
            int column = scanner.next().toUpperCase().charAt(0) - 'A';
            int row = scanner.nextInt();
            if (actualField[row][column] == EMPTY_CELL) {
                actualField[row][column] = X;
                printField();
                turnCount++;
                isEmpty = false;
            }
        }
    }

    private static void AITurn() {  //Ход искусственного интеллекта
        boolean isEmpty = true;
        System.out.println(AI_TURN_MESSAGE);
        while (isEmpty) {
            int column = (int) (Math.random() * FIELD_SIZE);
            int row = (int) (Math.random() * FIELD_SIZE);
            if (actualField[row][column] == EMPTY_CELL) {
                actualField[row][column] = O;
                printField();
                turnCount++;
                isEmpty = false;
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
    }

    public static void initialField() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажи размер поля");
        FIELD_SIZE = scanner.nextInt();
        if (FIELD_SIZE>3) {
            CELL_TO_WIN = 4;
        } else {
            CELL_TO_WIN = FIELD_SIZE;
        }
        actualField = new char[FIELD_SIZE][FIELD_SIZE]; //создание пустого поля
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                actualField[i][j] = EMPTY_CELL;
            }
        }
    }


}
