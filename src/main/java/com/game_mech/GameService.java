package com.game_mech;

import com.figures.Block;
import com.figures.Figure;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public static void print(char[][] board) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void placeFigure(char[][] board, Figure figure) {
        char type = figure.getType();
        for (Block b : figure.getBlocks()) {
            board[b.getX()][b.getY()] = type;
        }
        print(board);
    }

    public static void clear(char[][] board, Figure figure) {
        for (Block b : figure.getBlocks()) {
            board[b.getX()][b.getY()] = '_';
        }
    }

    public static int getMinXIndex(Figure figure, int length){
        int minXIndex = length;
        for (Block block : figure.getBlocks()) {
            if (block.getX() < minXIndex){
                minXIndex = block.getX();
            }
        }
        return minXIndex;
    }

    public static int getMaxXIndex(Figure figure){
        int maxXIndex = 0;
        for (Block block : figure.getBlocks()) {
            if (block.getX() > maxXIndex){
                maxXIndex = block.getX();
            }
        }
        return maxXIndex;
    }

    public static int getMinYIndex(Figure figure, int length){
        int minYIndex = length;
        for (Block block : figure.getBlocks()) {
            if (block.getY() < minYIndex){
                minYIndex = block.getY();
            }
        }
        return minYIndex;
    }

    public static int getMaxYIndex(Figure figure){
        int maxYIndex = 0;
        for (Block block : figure.getBlocks()) {
            if (block.getY() > maxYIndex){
                maxYIndex = block.getY();
            }
        }
        return maxYIndex;
    }
}
