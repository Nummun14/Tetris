package com.mygdx.tetris.cell;

import com.mygdx.tetris.TetrisConstants;

import java.awt.*;

public class Cell {
    public CellState currentState;
    public Rectangle rectangle;
    public int x, y;

    public Cell() {
        this(0, 0);
    }

    public Cell(int x, int y) {
        this(x, y, CellState.EMPTY);
    }

    public Cell(int x, int y, CellState currentState) {
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(x, y, TetrisConstants.CELL_SIZE, TetrisConstants.CELL_SIZE);
        this.currentState = currentState;
    }

    public boolean equals(Cell cell) {
        return x == cell.x && y == cell.y;
    }

    public boolean isFull() {
        return currentState != CellState.EMPTY;
    }
}