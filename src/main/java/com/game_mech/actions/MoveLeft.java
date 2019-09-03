package com.game_mech.actions;

import com.board.Board;
import com.figures.Block;
import com.figures.Figure;
import com.game_mech.GameService;
import com.utils.ActionException;

import java.util.ArrayList;
import java.util.List;

public class MoveLeft implements Actions{
    private char[][] board = Board.getBoard();
    private Figure figure;

    public MoveLeft(Figure figure) {
        this.figure = figure;
    }

    public Figure performAction() throws ActionException {
        moveLeft();
        return figure;
    }

    private void moveLeft() throws ActionException {
        List<Block> leftBlocks = getLeftBlocks(figure);
        for (Block block: leftBlocks) {
            if (block.getY() - 1 < 0 || board[block.getX()][block.getY() - 1] != '_'){
                throw new ActionException();
            }
        }
        GameService.clear(board, figure);
        for (Block block : figure.getBlocks()) {
            block.setY(block.getY() - 1);
        }
        figure.getPivot().setY(figure.getPivot().getY() - 1);
        GameService.placeFigure(board, figure);
    }

    private List<Block> getLeftBlocks(Figure figure){
        List<Block> leftBlocks = new ArrayList<>();
        int minXIndex = GameService.getMinXIndex(figure, board.length);
        int maxXIndex = GameService.getMaxXIndex(figure);
        for (int i = minXIndex; i <= maxXIndex; i++) {
            int minY = board[0].length;
            for (Block b : figure.getBlocks()) {
                if (b.getX() == i && b.getY() < minY){
                    minY = b.getY();
                }
            }
            leftBlocks.add(new Block(i, minY));
        }
        return leftBlocks;
    }

}
