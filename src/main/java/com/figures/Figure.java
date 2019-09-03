package com.figures;

import java.util.List;

public class Figure {
    private char type;
    private Pivot pivot;
    private List<Block> blocks;

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Pivot getPivot() {
        return pivot;
    }

    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
