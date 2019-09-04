package com.figures;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FigureFactory {
    private char [] figures = {'T', 'Z', 'L', 'I', 'O'};
    private Random random = new Random();

    public Figure getFigure(char type){
        if (type == 'T'){
            return getTFigure();
        } else if (type == 'Z') {
            return getZFigure();
        } else if (type == 'L') {
            return getLFigure();
        } else if (type == 'I') {
            return getIFigure();
        } else return getOFigure();
    }

    public Figure getFigure(){
        int index = random.nextInt(figures.length);
        if (figures[index] == 'T'){
            return getTFigure();
        } else if (figures[index] == 'Z') {
            return getZFigure();
        } else if (figures[index] == 'L') {
            return getLFigure();
        } else if (figures[index] == 'I') {
            return getIFigure();
        } else return getOFigure();
    }

    private Figure getTFigure(){
        Figure figure = new Figure();
        figure.setType('T');
        figure.setPivot(new Pivot(1,5));
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(1,4));
        blocks.add(new Block(1,5));
        blocks.add(new Block(1,6));
        blocks.add(new Block(0,5));
        figure.setBlocks(blocks);
       return figure;
    }

    private Figure getZFigure(){
        Figure figure = new Figure();
        figure.setType('Z');
        figure.setPivot(new Pivot(0,5));
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(0, 4));
        blocks.add(new Block(0,5));
        blocks.add(new Block(1,5));
        blocks.add(new Block(1,6));
        figure.setBlocks(blocks);
        return figure;
    }

    private Figure getLFigure(){
        Figure figure = new Figure();
        figure.setType('L');
        /*figure.setPivot(new Pivot(2,5));
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(0,5));
        blocks.add(new Block(1,5));
        blocks.add(new Block(2,5));
        blocks.add(new Block(2,6));*/
        figure.setPivot(new Pivot(1,6));
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(1,4));
        blocks.add(new Block(1,5));
        blocks.add(new Block(1,6));
        blocks.add(new Block(0,6));
        figure.setBlocks(blocks);
        return figure;
    }

    private Figure getIFigure(){
        Figure figure = new Figure();
        figure.setType('I');
        /*figure.setPivot(new Pivot(1,5));
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(0,5));
        blocks.add(new Block(1,5));
        blocks.add(new Block(2,5));
        blocks.add(new Block(3,5));*/
        figure.setPivot(new Pivot(0,5));
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(0,4));
        blocks.add(new Block(0,5));
        blocks.add(new Block(0,6));
        blocks.add(new Block(0,7));

        figure.setBlocks(blocks);
        return figure;
    }

    private Figure getOFigure(){
        Figure figure = new Figure();
        figure.setType('O');
        figure.setPivot(new Pivot(1,5));
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(0,5));
        blocks.add(new Block(1,5));
        blocks.add(new Block(0,4));
        blocks.add(new Block(1,4));
        figure.setBlocks(blocks);
        return figure;
    }

}
