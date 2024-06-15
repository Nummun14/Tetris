package com.mygdx.tetris.tetronimoes;


import com.badlogic.gdx.utils.Array;
import com.mygdx.tetris.Cell;
import com.mygdx.tetris.TetrisConstants;

public abstract class Tetronimo {

    public abstract void rotate(Array<Cell> boardCells);

    public abstract void moveLeft(Array<Cell> boardCells);

    public abstract void moveRight(Array<Cell> boardCells);

    public abstract void moveDown(Array<Cell> boardCells);

    public abstract Array<Cell> getTetronimoCells();
    public abstract Cell getHighestPoint(Array<Cell> tetronimoCells);
    public abstract Cell getLowestPoint(Array<Cell> tetronimoCells);
    public abstract Cell getRightmostPoint(Array<Cell> tetronimoCells);
    public abstract Cell getLeftmostPoint(Array<Cell> tetronimoCells);
    public abstract boolean isFalling();
    abstract void setRotationStateUp(Array<Cell> boardCells);
    abstract void setRotationStateRight(Array<Cell> boardCells);
    abstract void setRotationStateDown(Array<Cell> boardCells);
    abstract void setRotationStateLeft(Array<Cell> boardCells);
    abstract boolean isPlaceable(Array<Cell> tetronimoCells, Array<Cell> boardCells);
}
