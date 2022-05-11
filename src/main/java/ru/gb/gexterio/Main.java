package ru.gb.gexterio;

import java.util.Random;

public class Main {

    private static final int HEIGHT = 20;
    private static final int WIDTH = 15;
    private static final int MINES = 40;
    private static final int MINE_TILE = 1000;
    private static final int FLAG_TILE = 101;
    private static final char MINE_CHAR= '*';
    private static final char EMPTY_CHAR = '.';

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        boolean win = true;
        int[][] board = generateBoard();
        printBoard(board);
    }

    private static void printBoard(int[][] board) {
        System.out.print("  ");
        for (char i = 'A'; i < 'A' +WIDTH; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i<HEIGHT; i++) {
            System.out.print(i + " ");
            for (int j = 0; j<WIDTH; j++) {
                if (board[i][j] ==0) {
                    System.out.print(" " + EMPTY_CHAR);
                } else if (board[i][j] ==MINE_TILE) {
                    System.out.print(" "+ MINE_CHAR);
                } else {
                    System.out.print(" " + board[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static int[][] generateBoard() {
        int[][] board = new int[HEIGHT][WIDTH];
        Random random = new Random();
        int mines = MINES;
        while (mines > 0) {
            int x, y;
            do {
                x = random.nextInt(HEIGHT);
                y = random.nextInt(WIDTH);
            } while (board[x][y] == MINE_TILE);
            board[x][y] = MINE_TILE;
            mines--;
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == MINE_TILE) {
                    continue;
                }
                int mineCount = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k < 0 || k >= HEIGHT || l < 0 || l >= WIDTH) {
                            continue;
                        }
                        if (board[k][l] == MINE_TILE) {
                            mineCount++;
                        }
                    }
                }
                board[i][j] = mineCount;
            }
        }
        return board;
    }
}
