package com.game_mech.actions;

import com.board.Board;
import com.figures.Block;
import com.figures.Figure;
import com.game_mech.GameService;
import com.utils.ActionException;

import java.util.ArrayList;
import java.util.List;

public class FullDown implements Actions{
    private char[][] board = Board.getBoard();
    private Figure figure;

    public FullDown(Figure figure) {
        this.figure = figure;
    }

    public Figure performAction() throws ActionException {
        fullDown();
        return figure;
    }

    private void fullDown() throws ActionException {
        List<Block> bottomBlocks = getBottomBlocks(figure);
        int edgeX = board.length;
        for (Block block: bottomBlocks) {
            //System.out.println(block.getX() + " " + block.getY());
            int tmp = 0;
            for (int i = block.getX(); i < board.length; i++) {
                if (i + 1 < board.length && board[i + 1][block.getY()] == '_'){
                    tmp++;
                } else break;
            }
            if (edgeX > tmp){
                edgeX = tmp;
            }
        }
        GameService.clear(board, figure);
        for (Block b : figure.getBlocks()) {
            b.setX(b.getX() + edgeX);
        }
        figure.getPivot().setX(figure.getPivot().getX() + edgeX);
        GameService.placeFigure(board, figure);
        figure = new GetFigure().performAction();
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
