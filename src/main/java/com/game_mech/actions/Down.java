package com.game_mech.actions;

import com.board.Board;
import com.figures.Block;
import com.figures.Figure;
import com.game_mech.GameService;
import com.utils.ActionException;

import java.util.ArrayList;
import java.util.List;

public class Down implements Actions{
    private char[][] board = Board.getBoard();
    private Figure figure;

    public Down(Figure figure) {
        this.figure = figure;
    }

    public Figure performAction() throws ActionException {
        down();
        return figure;
    }

    private void down() throws ActionException {
        List<Block> bottomBlocks = getBottomBlocks(figure);
        for (Block block: bottomBlocks) {
            if (block.getX() + 1 == board.length || board[block.getX() + 1][block.getY()] != '_'){

                figure = new GetFigure().performAction();
                //System.out.println("EXC");
                return;
                //throw new ...
            }
        }
        GameService.clear(board, figure);
        for (Block b : figure.getBlocks()) {
            b.setX(b.getX() + 1);
        }
        figure.getPivot().setX(figure.getPivot().getX() + 1);
        GameService.placeFigure(board, figure);
    }

    private List<Block> getBottomBlocks(Figure figure) {
        List<Block> bottomBlocks = new ArrayList<>();
        int minYIndex = GameService.getMinYIndex(figure, board.length);
        int maxYIndex = GameService.getMaxYIndex(figure);
        for (int i = minYIndex; i <= maxYIndex; i++) {
            int maxX = 0;
            for (Block b : figure.getBlocks()) {
                if (b.getY() == i && b.getX() > maxX){
                    maxX = b.getX();
                }
            }
            bottomBlocks.add(new Block(maxX, i));
        }
        return bottomBlocks;
    }
}
