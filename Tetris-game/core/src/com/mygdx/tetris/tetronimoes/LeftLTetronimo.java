package com.mygdx.tetris.tetronimoes;

import com.badlogic.gdx.utils.Array;
import com.mygdx.tetris.Cell;
import com.mygdx.tetris.TetrisConstants;

public class LeftLTetronimo extends Tetronimo {
    public boolean isFalling;
    public Cell
            centerCell,
            cell1,
            cell2,
            cell3;
    Array<Cell> tetronimoCells;
    boolean
            isRotationStateUp,
            isRotationStateRight,
            isRotationStateDown,
            isRotationStateLeft;

    public LeftLTetronimo(Cell centerCell, Array<Cell> boardCells) {
        isFalling = true;
        this.centerCell = centerCell;
        tetronimoCells = new Array<>();
        tetronimoCells.add(centerCell);
        tetronimoCells.add(cell1);
        tetronimoCells.add(cell2);
        tetronimoCells.add(cell3);

        setRotationStateDown(boardCells);
    }

    @Override
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

    @Override
    public void moveLeft(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        for (Cell tetronimoCell : tetronimoCells) {
            newCells.add(new Cell(tetronimoCell.x - TetrisConstants.CELL_SIZE, tetronimoCell.y));
        }
        if (isPlaceable(newCells, boardCells))
            tetronimoCells = newCells;
    }

    @Override
    public void moveRight(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        for (Cell tetronimoCell : tetronimoCells) {
            newCells.add(new Cell(tetronimoCell.x + TetrisConstants.CELL_SIZE, tetronimoCell.y));
        }
        if (isPlaceable(newCells, boardCells))
            tetronimoCells = newCells;
    }

    @Override
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

    @Override
    public Array<Cell> getTetronimoCells() {
        return tetronimoCells;
    }

    @Override
    public Cell getHighestPoint(Array<Cell> tetronimoCells) {
        Cell highestCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.y > highestCell.y) {
                highestCell = cell;
            }
        }
        return highestCell;
    }

    @Override
    public Cell getLowestPoint(Array<Cell> tetronimoCells) {
        Cell lowestCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.y < lowestCell.y) {
                lowestCell = cell;
            }
        }
        return lowestCell;
    }

    @Override
    public Cell getRightmostPoint(Array<Cell> tetronimoCells) {
        Cell rightmostCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.x > rightmostCell.x) {
                rightmostCell = cell;
            }
        }
        return rightmostCell;
    }

    @Override
    public Cell getLeftmostPoint(Array<Cell> tetronimoCells) {
        Cell leftmostCell = new Cell();
        for (Cell cell : tetronimoCells) {
            if (cell.x < leftmostCell.x) {
                leftmostCell = cell;
            }
        }
        return leftmostCell;
    }

    @Override
    public boolean isFalling() {
        return isFalling;
    }

    @Override
    void setRotationStateUp(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        newCells.add(tetronimoCells.get(0));
        newCells.add(new Cell(tetronimoCells.get(0).x + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y));
        newCells.add(new Cell(tetronimoCells.get(0).x - TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y));
        newCells.add(new Cell(tetronimoCells.get(0).x + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y - TetrisConstants.CELL_SIZE));

        if (isPlaceable(newCells, boardCells)) {
            isRotationStateUp = true;
            isRotationStateRight = false;
            isRotationStateDown = false;
            isRotationStateLeft = false;

            tetronimoCells = newCells;
        }
    }

    @Override
    void setRotationStateRight(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        newCells.add(tetronimoCells.get(0));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y + TetrisConstants.CELL_SIZE));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y - TetrisConstants.CELL_SIZE));
        newCells.add(new Cell(tetronimoCells.get(0).x - TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y - TetrisConstants.CELL_SIZE));

        if (isPlaceable(newCells, boardCells)) {
            isRotationStateRight = true;
            isRotationStateUp = false;
            isRotationStateDown = false;
            isRotationStateLeft = false;

            tetronimoCells = newCells;
        }
    }

    @Override
    void setRotationStateDown(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        newCells.add(tetronimoCells.get(0));
        newCells.add(new Cell(tetronimoCells.get(0).x - TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y));
        newCells.add(new Cell(tetronimoCells.get(0).x + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y));
        newCells.add(new Cell(tetronimoCells.get(0).x - TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y + TetrisConstants.CELL_SIZE));

        if (isPlaceable(newCells, boardCells)) {
            isRotationStateDown = true;
            isRotationStateUp = false;
            isRotationStateRight = false;
            isRotationStateLeft = false;

            tetronimoCells = newCells;
        }
    }

    @Override
    void setRotationStateLeft(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        newCells.add(tetronimoCells.get(0));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y - TetrisConstants.CELL_SIZE));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y + TetrisConstants.CELL_SIZE));
        newCells.add(new Cell(tetronimoCells.get(0).x + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y + TetrisConstants.CELL_SIZE));

        if (isPlaceable(newCells, boardCells)) {
            isRotationStateLeft = true;
            isRotationStateUp = false;
            isRotationStateRight = false;
            isRotationStateDown = false;

            tetronimoCells = newCells;
        }
    }

    @Override
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
