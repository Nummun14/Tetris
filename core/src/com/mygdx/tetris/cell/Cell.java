package com.mygdx.tetris.cell;

public class Cell {
    public CellState currentState;
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
        this.currentState = currentState;
    }

    public boolean equals(Cell cell) {
        return x == cell.x && y == cell.y;
    }

    public boolean isFull() {
        return currentState != CellState.EMPTY;
    }
}