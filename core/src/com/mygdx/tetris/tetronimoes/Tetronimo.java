package com.mygdx.tetris.tetronimoes;


import com.badlogic.gdx.utils.Array;
import com.mygdx.tetris.cell.Cell;
import com.mygdx.tetris.TetrisConstants;
import com.mygdx.tetris.cell.CellState;

public abstract class Tetronimo {
    public boolean isFalling;
    Array<Cell> tetronimoCells;
    TetronimoState currentRotationState;

    Tetronimo(Cell centerCell, Array<Cell> boardCells, CellState cellState) {
        centerCell.currentState = cellState;
        this.isFalling = true;
        this.tetronimoCells = new Array<>();
        this.tetronimoCells.add(centerCell);

        setRotationStateDown(boardCells);
    }

    public void rotate(Array<Cell> boardCells) {
        switch (currentRotationState) {
            case UP:
                setRotationStateRight(boardCells);
                break;
            case RIGHT:
                setRotationStateDown(boardCells);
                break;
            case DOWN:
                setRotationStateLeft(boardCells);
                break;
            case LEFT:
                setRotationStateUp(boardCells);
                break;
        }
    }

    public void moveLeft(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        for (Cell tetronimoCell : tetronimoCells)
            newCells.add(new Cell(tetronimoCell.x - TetrisConstants.CELL_SIZE, tetronimoCell.y, tetronimoCell.currentState));
        if (isPlaceable(newCells, boardCells))
            tetronimoCells = newCells;
    }

    public void moveRight(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        for (Cell tetronimoCell : tetronimoCells)
            newCells.add(new Cell(tetronimoCell.x + TetrisConstants.CELL_SIZE, tetronimoCell.y, tetronimoCell.currentState));
        if (isPlaceable(newCells, boardCells))
            tetronimoCells = newCells;
    }

    public void moveDown(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        for (Cell tetronimoCell : tetronimoCells)
            newCells.add(new Cell(tetronimoCell.x, tetronimoCell.y - TetrisConstants.CELL_SIZE, tetronimoCell.currentState));
        if (isPlaceable(newCells, boardCells)) {
            tetronimoCells = newCells;
            return;
        }
        isFalling = false;
    }

    public Array<Cell> getTetronimoCells() {
        return tetronimoCells;
    }

    public Cell getHighestCell(Array<Cell> tetronimoCells) {
        Cell highestCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.y > highestCell.y)
                highestCell = cell;
        }
        return highestCell;
    }

    public Cell getLowestCell(Array<Cell> tetronimoCells) {
        Cell lowestCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.y < lowestCell.y)
                lowestCell = cell;
        }
        return lowestCell;
    }

    public Cell getRightmostCell(Array<Cell> tetronimoCells) {
        Cell rightmostCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.x > rightmostCell.x)
                rightmostCell = cell;
        }
        return rightmostCell;
    }

    public Cell getLeftMostCell(Array<Cell> tetronimoCells) {
        Cell leftmostCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.x < leftmostCell.x)
                leftmostCell = cell;
        }
        return leftmostCell;
    }

    public boolean isFalling() {
        return isFalling;
    }

    public TetronimoState getCurrentRotationState() {
        return currentRotationState;
    }

    abstract void setRotationStateUp(Array<Cell> boardCells);

    abstract void setRotationStateRight(Array<Cell> boardCells);

    abstract void setRotationStateDown(Array<Cell> boardCells);

    abstract void setRotationStateLeft(Array<Cell> boardCells);

    boolean isPlaceable(Array<Cell> tetronimoCells, Array<Cell> boardCells) {
        for (Cell tetronimoCell : tetronimoCells) {
            if (tetronimoCell.y < TetrisConstants.GAME_LOWEST_Y) {
                isFalling = false;
                return false;
            }
            if (tetronimoCell.x < TetrisConstants.GAME_LOWEST_X || tetronimoCell.x >= TetrisConstants.GAME_WIDTH)
                return false;
            for (Cell boardCell : boardCells) {
                if (tetronimoCell.equals(boardCell)) {
                    if (boardCell.isFull())
                        return false;
                }
            }
        }
        return true;
    }
}