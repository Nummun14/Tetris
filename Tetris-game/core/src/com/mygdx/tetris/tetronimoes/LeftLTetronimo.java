package com.mygdx.tetris.tetronimoes;

import com.badlogic.gdx.utils.Array;
import com.mygdx.tetris.Cell;
import com.mygdx.tetris.TetrisConstants;

public class LeftLTetronimo extends Tetronimo {

    public LeftLTetronimo(Cell centerCell, Array<Cell> boardCells) {
        super(centerCell, boardCells);
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

}
