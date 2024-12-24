package com.mygdx.tetris.cell;

import com.badlogic.gdx.graphics.Texture;

public class CellConstants {
    private static final String
            EMPTY_IMAGE_NAME = "blackSquare.png",
            RED_IMAGE_NAME = "redSquare.png",
            GREEN_IMAGE_NAME = "greenSquare.png",
            BLUE_IMAGE_NAME = "blueSquare.png",
            LIGHT_BLUE_IMAGE_NAME = "lightBlueSquare.png",
            YELLOW_IMAGE_NAME = "yellowSquare.png",
            PURPLE_IMAGE_NAME = "purpleSquare.png",
            ORANGE_IMAGE_NAME = "orangeSquare.png";
    static final Texture
            EMPTY_TEXTURE = new Texture(EMPTY_IMAGE_NAME),
            RED_TEXTURE = new Texture(RED_IMAGE_NAME),
            GREEN_TEXTURE = new Texture(GREEN_IMAGE_NAME),
            BLUE_TEXTURE = new Texture(BLUE_IMAGE_NAME),
            LIGHT_BLUE_TEXTURE = new Texture(LIGHT_BLUE_IMAGE_NAME),
            YELLOW_TEXTURE = new Texture(YELLOW_IMAGE_NAME),
            PURPLE_TEXTURE = new Texture(PURPLE_IMAGE_NAME),
            ORANGE_TEXTURE = new Texture(ORANGE_IMAGE_NAME);

    public static void disposeCellImages() {
        EMPTY_TEXTURE.dispose();
        RED_TEXTURE.dispose();
        GREEN_TEXTURE.dispose();
        BLUE_TEXTURE.dispose();
        LIGHT_BLUE_TEXTURE.dispose();
        YELLOW_TEXTURE.dispose();
        PURPLE_TEXTURE.dispose();
        ORANGE_TEXTURE.dispose();
    }
}