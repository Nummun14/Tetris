package com.mygdx.tetris.tetronimoes;

import com.badlogic.gdx.utils.Array;
import com.mygdx.tetris.cell.Cell;
import com.mygdx.tetris.TetrisConstants;

public class SquareTetronimo extends Tetronimo {
    public SquareTetronimo(Cell centerCell, Array<Cell> boardCells) {
        super(centerCell, boardCells, TetrisConstants.SQUARE_TETRONIMO_COLOR);
    }

    @Override
    void setRotationStateUp(Array<Cell> boardCells) {
        setRotationStateLeft(boardCells);
        currentRotationState = TetronimoState.UP;
    }

    @Override
    void setRotationStateRight(Array<Cell> boardCells) {
        setRotationStateLeft(boardCells);
        currentRotationState = TetronimoState.RIGHT;
    }

    @Override
    void setRotationStateDown(Array<Cell> boardCells) {
        setRotationStateLeft(boardCells);
        currentRotationState = TetronimoState.DOWN;
    }

    @Override
    void setRotationStateLeft(Array<Cell> boardCells) {

        Array<Cell> newCells = new Array<>();
        newCells.add(tetronimoCells.get(0));
        newCells.add(new Cell(tetronimoCells.get(0).x + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x, tetronimoCells.get(0).y + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).currentState));
        newCells.add(new Cell(tetronimoCells.get(0).x + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).y + TetrisConstants.CELL_SIZE, tetronimoCells.get(0).currentState));

        if (isPlaceable(newCells, boardCells)) {
            currentRotationState = TetronimoState.LEFT;
            tetronimoCells = newCells;
        }
    }
}