package com.game_mech.actions;

import com.board.Board;
import com.figures.Block;
import com.figures.Figure;
import com.figures.FigureFactory;
import com.game_mech.GameService;
import com.utils.ActionException;

public class GetFigure implements Actions {
    private char[][] board = Board.getBoard();
    private Figure figure = new FigureFactory().getFigure();

    public Figure performAction() throws ActionException {
        for (Block block: figure.getBlocks()) {
            if (board[block.getX()][block.getY()] != '_')
                throw new ActionException();
        }
        GameService.placeFigure(board, figure);
        return figure;
    }



}
