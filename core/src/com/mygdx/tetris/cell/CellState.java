package com.mygdx.tetris.cell;

import com.badlogic.gdx.graphics.Texture;

public enum CellState {
    EMPTY(CellConstants.EMPTY_TEXTURE),
    RED(CellConstants.RED_TEXTURE),
    GREEN(CellConstants.GREEN_TEXTURE),
    BLUE(CellConstants.BLUE_TEXTURE),
    LIGHT_BLUE(CellConstants.LIGHT_BLUE_TEXTURE),
    YELLOW(CellConstants.YELLOW_TEXTURE),
    PURPLE(CellConstants.PURPLE_TEXTURE),
    ORANGE(CellConstants.ORANGE_TEXTURE);

    public final Texture texture;

    CellState(Texture texture) {
        this.texture = texture;
    }
}