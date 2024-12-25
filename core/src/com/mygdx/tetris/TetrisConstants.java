package com.mygdx.tetris;

import com.mygdx.tetris.cell.CellState;

public class TetrisConstants {
    public static final int
            SCREEN_WIDTH = 300,
            SCREEN_HEIGHT = 600,
            SCREEN_CENTER_X = SCREEN_WIDTH / 2,
            SCREEN_CENTER_Y = SCREEN_HEIGHT / 2,
            GAME_HEIGHT = 450,
            GAME_WIDTH = 300,
            CELL_SPAWN_HEIGHT = 570,
            GAME_LOWEST_X = 0,
            GAME_LOWEST_Y = 0;
    public static final int CELL_SIZE = 30;
    public static final int LIMIT_LINE_LENGTH = 60;
    public static final double
            TIME_BETWEEN_MOVES_MILLISECONDS = 150,
            TIME_BETWEEN_DROPS_MILLISECONDS = 400;
    public static final int
            SCORE_X = 10,
            SCORE_Y = SCREEN_HEIGHT - 10;
    public static final CellState
            LEFT_L_TETRONIMO_COLOR = CellState.ORANGE,
            RIGHT_L_TETRONIMO_COLOR = CellState.BLUE,
            LEFT_ZIGZAG_TETRONIMO_COLOR = CellState.GREEN,
            RIGHT_ZIGZAG_TETRONIMO_COLOR = CellState.RED,
            SQUARE_TETRONIMO_COLOR = CellState.YELLOW,
            MOUNT_TETRONIMO_COLOR = CellState.PURPLE,
            LINE_TETRONIMO_COLOR = CellState.LIGHT_BLUE;
}