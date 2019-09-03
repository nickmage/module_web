package com.board;

public class Board {
    private static char[][] board;

    private Board() {
    }

    public static char[][] getBoard() {
        if(board == null){
            board = new BoardGenerator().getBoard();
        }
        return board;
    }
}
