package com.game_mech.actions;

import com.board.Board;
import com.figures.Block;
import com.figures.Figure;
import com.figures.FigureFactory;
import com.game_mech.GameService;
import com.utils.ActionException;

import java.util.ArrayList;
import java.util.List;

public class TurnRight implements Actions {
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

    public TurnRight(Figure figure) {
        this.figure = figure;
    }

    public static void main(String[] args) throws ActionException {
        TurnRight left = new TurnRight(new FigureFactory().getFigure('T'));
        //will be deleted
        GameService.placeFigure(left.board, left.figure);
        GameService.clear(left.board, left.figure);
        for (Block block : left.figure.getBlocks()) {
            block.setX(block.getX() + 3);
        }
        left.figure.getPivot().setX(left.figure.getPivot().getX() + 3);
        GameService.placeFigure(left.board, left.figure);
        //wbd

        left.turnRight();
        GameService.placeFigure(left.board, left.figure);
        left.turnRight();
        GameService.placeFigure(left.board, left.figure);
        left.turnRight();
        GameService.placeFigure(left.board, left.figure);
        left.turnRight();
        GameService.placeFigure(left.board, left.figure);
        left.turnRight();
        GameService.placeFigure(left.board, left.figure);
        left.turnRight();
        GameService.placeFigure(left.board, left.figure);
    }

    public Figure performAction() throws ActionException {
        turnRight();
        return figure;
    }

    private void turnRight() throws ActionException {
        if (figure.getType() != 'O'){
            int pivotX = figure.getPivot().getX();
            int pivotY = figure.getPivot().getY();
            GameService.clear(board, figure);
            List<Block> tempBlocks = new ArrayList<>();
            for (Block block: figure.getBlocks()) {
                int x = block.getY() - pivotY +  pivotX;
                int y = pivotX - block.getX() + pivotY;
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
