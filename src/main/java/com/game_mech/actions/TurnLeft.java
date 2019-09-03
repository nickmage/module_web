package com.game_mech.actions;

import com.board.Board;
import com.figures.Block;
import com.figures.Figure;
import com.figures.FigureFactory;
import com.game_mech.GameService;
import com.utils.ActionException;

public class TurnLeft implements Actions {
    private char[][] board = Board.getBoard();
           /* {
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', 'T', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', 'T', 'T', 'T', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_', 'L', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', 'L', 'L', 'L', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', 'I', 'I', 'I', 'I', '_', '_', '_'},
                    {'T', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z'},
                    {'T', 'T', 'Z', 'L', 'Z', 'Z', 'Z', 'Z', 'Z', '_', '_'},
                    {'T', 'L', 'L', 'L', '_', 'T', '_', 'O', 'O', 'O', 'O'},
                    {'I', 'I', 'I', 'I', 'T', 'T', 'T', 'O', 'O', 'O', 'O'}
            };*/
    private Figure figure;

    public TurnLeft(Figure figure) {
        this.figure = figure;
    }

    public static void main(String[] args) throws ActionException {
        TurnLeft left = new TurnLeft(new FigureFactory().getFigure('I'));
        //left.turnILeft();
    }

    public Figure performAction() throws ActionException {
        turnLeft();
        return figure;
    }

    private void turnLeft() throws ActionException {
        switch (figure.getType()) {
            case 'O':
                return;
            case 'I':
                break;
            case 'T':
                break;
            case 'Z':
                break;
            case 'L':
                break;
        }
    }

    private void turnILeft() throws ActionException {

        //will be deleted
        GameService.placeFigure(board, figure);
        //GameService.print(board);
        GameService.clear(board, figure);
        for (Block block : figure.getBlocks()) {
            block.setX(block.getX() + 3);
        }
        figure.getPivot().setX(figure.getPivot().getX() + 3);
        GameService.placeFigure(board, figure);
        //wbd


        System.out.println(isIHorizontal());

        //System.out.println(figure.getPivot().getX() + " " + figure.getPivot().getY());


    }

    private boolean isIHorizontal(){
        int pivotX = figure.getPivot().getX();
        int pivotY = figure.getPivot().getY();
        for (Block block : figure.getBlocks()) {
            if (pivotY - 1 >= 0 && board[pivotX][pivotY - 1] != 'I') {
                return false;
            }
            if (pivotY + 1 < board[0].length && board[pivotX][pivotY + 1] != 'I') {
                return false;
            }
        }
        return true;
    }

    /*private void trimRows(char[][] board, int clearRow){
        for (int i = clearRow; i > 0 ; i--) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i - 1][j];
                board[i - 1][j] = '_';
            }
        }
    }*/




}
