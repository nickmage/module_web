package com.board;

public class BoardGenerator {
    private char[][] board = new char[20][11];

    public char[][] getBoard() {
        return board;
    }

    public BoardGenerator() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '_';
            }
        }
    }
}
