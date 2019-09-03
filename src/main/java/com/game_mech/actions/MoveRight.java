package com.game_mech.actions;

import com.board.Board;
import com.figures.Block;
import com.figures.Figure;
import com.game_mech.GameService;
import com.utils.ActionException;

import java.util.ArrayList;
import java.util.List;

public class MoveRight implements Actions{
    private char[][] board = Board.getBoard();
    private Figure figure;

    public MoveRight(Figure figure) {
        this.figure = figure;
    }

    public Figure performAction() throws ActionException {
        moveRight();
        return figure;
    }

    private void moveRight() throws ActionException {
        List<Block> rightBlocks = getRightBlocks(figure);
        for (Block block: rightBlocks) {
            if (block.getY() + 1 == board[0].length || board[block.getX()][block.getY() + 1] != '_'){
                throw new ActionException();
            }
        }
        GameService.clear(board, figure);
        for (Block b : figure.getBlocks()) {
            b.setY(b.getY() + 1);
        }
        figure.getPivot().setY(figure.getPivot().getY() + 1);
        GameService.placeFigure(board, figure);
    }

    private List<Block> getRightBlocks(Figure figure){
        List<Block> rightBlocks = new ArrayList<>();
        int minXIndex = GameService.getMinXIndex(figure, board.length);
        int maxXIndex = GameService.getMaxXIndex(figure);
        for (int i = minXIndex; i <= maxXIndex; i++) {
            int maxY = 0;
            for (Block b : figure.getBlocks()) {
                if (b.getX() == i && b.getY() > maxY){
                    maxY = b.getY();
                }
            }
            rightBlocks.add(new Block(i, maxY));
        }
        return rightBlocks;
    }
}
