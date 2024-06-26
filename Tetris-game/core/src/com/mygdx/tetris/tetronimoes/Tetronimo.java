package com.mygdx.tetris.tetronimoes;


import com.badlogic.gdx.utils.Array;
import com.mygdx.tetris.Cell;
import com.mygdx.tetris.TetrisConstants;

public abstract class Tetronimo {
    public boolean isFalling;
    Array<Cell> tetronimoCells;
    boolean
            isRotationStateUp,
            isRotationStateRight,
            isRotationStateDown,
            isRotationStateLeft;

    public Tetronimo(Cell centerCell, Array<Cell> boardCells) {
        isFalling = true;
        tetronimoCells = new Array<>();
        tetronimoCells.add(centerCell);

        setRotationStateDown(boardCells);
    }

    public void rotate(Array<Cell> boardCells) {
        if (isRotationStateUp) {
            setRotationStateRight(boardCells);
        } else if (isRotationStateRight) {
            setRotationStateDown(boardCells);
        } else if (isRotationStateDown) {
            setRotationStateLeft(boardCells);
        } else if (isRotationStateLeft)
            setRotationStateUp(boardCells);
    }

    public void moveLeft(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        for (Cell tetronimoCell : tetronimoCells) {
            newCells.add(new Cell(tetronimoCell.x - TetrisConstants.CELL_SIZE, tetronimoCell.y));
        }
        if (isPlaceable(newCells, boardCells))
            tetronimoCells = newCells;
    }

    public void moveRight(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        for (Cell tetronimoCell : tetronimoCells) {
            newCells.add(new Cell(tetronimoCell.x + TetrisConstants.CELL_SIZE, tetronimoCell.y));
        }
        if (isPlaceable(newCells, boardCells))
            tetronimoCells = newCells;
    }

    public void moveDown(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        for (Cell tetronimoCell : tetronimoCells) {
            newCells.add(new Cell(tetronimoCell.x, tetronimoCell.y - TetrisConstants.CELL_SIZE));
        }
        if (isPlaceable(newCells, boardCells)) {
            tetronimoCells = newCells;
            return;
        }
        isFalling = false;
    }

    public Array<Cell> getTetronimoCells() {
        return tetronimoCells;
    }

    public Cell getHighestPoint(Array<Cell> tetronimoCells) {
        Cell highestCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.y > highestCell.y) {
                highestCell = cell;
            }
        }
        return highestCell;
    }

    public Cell getLowestPoint(Array<Cell> tetronimoCells) {
        Cell lowestCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.y < lowestCell.y) {
                lowestCell = cell;
            }
        }
        return lowestCell;
    }

    public Cell getRightmostPoint(Array<Cell> tetronimoCells) {
        Cell rightmostCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.x > rightmostCell.x) {
                rightmostCell = cell;
            }
        }
        return rightmostCell;
    }

    public Cell getLeftmostPoint(Array<Cell> tetronimoCells) {
        Cell leftmostCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.x < leftmostCell.x) {
                leftmostCell = cell;
            }
        }
        return leftmostCell;
    }

    public boolean isFalling() {
        return isFalling;
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
            } else if (tetronimoCell.x < TetrisConstants.GAME_LOWEST_X
                    || tetronimoCell.x >= TetrisConstants.GAME_WIDTH) {
                return false;
            }
            for (Cell boardCell : boardCells) {
                if (tetronimoCell.equals(boardCell)) {
                    if (boardCell.isFull)
                        return false;
                }
            }
        }
        return true;
    }
}
