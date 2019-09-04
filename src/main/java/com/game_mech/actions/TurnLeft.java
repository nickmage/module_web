package com.game_mech.actions;

import com.board.Board;
import com.figures.Block;
import com.figures.Figure;
import com.figures.FigureFactory;
import com.game_mech.GameService;
import com.utils.ActionException;

import java.util.ArrayList;
import java.util.List;

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
        //will be deleted
        GameService.placeFigure(left.board, left.figure);
        GameService.clear(left.board, left.figure);
        for (Block block : left.figure.getBlocks()) {
            block.setX(block.getX() + 3);
        }
        left.figure.getPivot().setX(left.figure.getPivot().getX() + 3);
        GameService.placeFigure(left.board, left.figure);
        //wbd

        left.turnLeft();
        GameService.placeFigure(left.board, left.figure);
        left.turnLeft();
        GameService.placeFigure(left.board, left.figure);
        left.turnLeft();
        GameService.placeFigure(left.board, left.figure);
        left.turnLeft();
        GameService.placeFigure(left.board, left.figure);
        left.turnLeft();
        GameService.placeFigure(left.board, left.figure);
        left.turnLeft();
        GameService.placeFigure(left.board, left.figure);
    }

    public Figure performAction() throws ActionException {
        turnLeft();
        return figure;
    }

    private void turnLeft() throws ActionException {
        if (figure.getType() != 'O'){
            int pivotX = figure.getPivot().getX();
            int pivotY = figure.getPivot().getY();
            GameService.clear(board, figure);
            List<Block> tempBlocks = new ArrayList<>();
            for (Block block: figure.getBlocks()) {
                int x = pivotY - block.getY() + pivotX;
                int y = pivotY - pivotX + block.getX();
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
                    throw new ActionException();
                }
                tempBlocks.add(new Block(x,y));
                //block.setX(x);
                //block.setY(y);
            }
            figure.setBlocks(tempBlocks);
            GameService.placeFigure(board, figure);
        }
    }
}
