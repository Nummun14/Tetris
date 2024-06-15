package com.mygdx.tetris;

import java.awt.*;

public class Cell {
    public boolean isFull;
    public Rectangle rectangle;
    public int x, y;

    public Cell() {
        this(0, 0);
    }

    public Cell(int x, int y) {
        this(x, y, false);
    }

    public Cell(int x, int y, boolean isFull) {
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(x, y, TetrisConstants.CELL_SIZE, TetrisConstants.CELL_SIZE);
        this.isFull = isFull;
    }

    public boolean equals(Cell cell) {
        return x == cell.x && y == cell.y;
    }
}
