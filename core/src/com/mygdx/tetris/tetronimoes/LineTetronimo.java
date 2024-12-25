package com.mygdx.tetris.tetronimoes;

import com.badlogic.gdx.utils.Array;
import com.mygdx.tetris.cell.Cell;
import com.mygdx.tetris.TetrisConstants;

public class LineTetronimo extends Tetronimo{
    public LineTetronimo(Cell centerCell, Array<Cell> boardCells) {
        super(centerCell, boardCells, TetrisConstants.LINE_TETRONIMO_COLOR);
    }

    @Override
    void setRotationStateUp(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        newCells.add(tetronimoCells.get(0));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y - TetrisConstants.CELL_SIZE, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y - 2 * TetrisConstants.CELL_SIZE, tetronimoCells.get(0).currentState));

        if (isPlaceable(newCells, boardCells)) {
            currentRotationState = TetronimoState.UP;
            tetronimoCells = newCells;
        }
    }

    @Override
    void setRotationStateRight(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        newCells.add(tetronimoCells.get(0));
        newCells.add(new Cell(tetronimoCells.get(0).x + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x - TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x - 2 * TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y, tetronimoCells.get(0).currentState));

        if (isPlaceable(newCells, boardCells)) {
            currentRotationState = TetronimoState.RIGHT;
            tetronimoCells = newCells;
        }
    }

    @Override
    void setRotationStateDown(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        newCells.add(tetronimoCells.get(0));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y - TetrisConstants.CELL_SIZE, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y + 2 * TetrisConstants.CELL_SIZE, tetronimoCells.get(0).currentState));

        if (isPlaceable(newCells, boardCells)) {
            currentRotationState = TetronimoState.DOWN;
            tetronimoCells = newCells;
        }
    }

    @Override
    void setRotationStateLeft(Array<Cell> boardCells) {
        Array<Cell> newCells = new Array<>();
        newCells.add(tetronimoCells.get(0));
        newCells.add(new Cell(tetronimoCells.get(0).x + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x - TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x - 2 * TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y, tetronimoCells.get(0).currentState));

        if (isPlaceable(newCells, boardCells)) {
            currentRotationState = TetronimoState.LEFT;
            tetronimoCells = newCells;
        }
    }
}
