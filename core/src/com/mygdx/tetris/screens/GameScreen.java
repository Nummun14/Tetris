package com.mygdx.tetris.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.tetris.cell.Cell;
import com.mygdx.tetris.cell.CellConstants;
import com.mygdx.tetris.cell.CellState;
import com.mygdx.tetris.Tetris;
import com.mygdx.tetris.TetrisConstants;
import com.mygdx.tetris.tetronimoes.*;

public class GameScreen implements Screen {
    private final Tetris game;
    private final Texture limitLine;
    private final OrthographicCamera camera;
    private final Array<Cell> boardCells;
    private int score;
    private Tetronimo tetronimo;
    private long lastMovedRightTime, lastMovedLeftTime, lastMovedDownTime, lastRotateTime, lastFallTime;

    public GameScreen(final Tetris game) {
        this.game = game;

        Gdx.graphics.setForegroundFPS(30);

        limitLine = new Texture("thinRedLine.png");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, TetrisConstants.SCREEN_WIDTH, TetrisConstants.SCREEN_HEIGHT);

        boardCells = new Array<>();
        score = 0;
        lastMovedRightTime = 0;
        lastMovedLeftTime = 0;
        lastMovedDownTime = 0;
        lastRotateTime = 0;
        lastFallTime = 0;

        spawnTetromino();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        drawCells();
        drawLimitLine();
        game.font.draw(game.batch, "Score:" + score, TetrisConstants.SCORE_X, TetrisConstants.SCORE_Y);
        drawTetromino();
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (TimeUtils.timeSinceMillis(lastMovedRightTime) > TetrisConstants.TIME_BETWEEN_MOVES_MILLISECONDS) {
                tetronimo.moveRight(boardCells);
                lastMovedRightTime = TimeUtils.millis();
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (TimeUtils.timeSinceMillis(lastMovedLeftTime) > TetrisConstants.TIME_BETWEEN_MOVES_MILLISECONDS) {
                tetronimo.moveLeft(boardCells);
                lastMovedLeftTime = TimeUtils.millis();
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (TimeUtils.timeSinceMillis(lastMovedDownTime) > TetrisConstants.TIME_BETWEEN_MOVES_MILLISECONDS) {
                tetronimo.moveDown(boardCells);
                score += 1;
                lastMovedDownTime = TimeUtils.millis();
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (TimeUtils.timeSinceMillis(lastRotateTime) > TetrisConstants.TIME_BETWEEN_MOVES_MILLISECONDS) {
                tetronimo.rotate(boardCells);
                lastRotateTime = TimeUtils.millis();
            }
        }

        if (TimeUtils.timeSinceMillis(lastFallTime) > TetrisConstants.TIME_BETWEEN_DROPS_MILLISECONDS) {
            tetronimo.moveDown(boardCells);
            lastFallTime = TimeUtils.millis();
        }

        if (!tetronimo.isFalling()) {
            score += 10;
            updateBoard();
            if (tetronimo.getHighestPoint(tetronimo.getTetronimoCells()).y >= TetrisConstants.GAME_HEIGHT) {
                game.setScreen(new GameOverScreen(game, score));
            }
            Array<Integer> fullRows = getFullRows();
            for (Integer fullRow : fullRows) {
                clearRow(fullRow);
                moveRowsDown(fullRow);
                score += 75;
            }
            spawnTetromino();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        CellConstants.disposeCellImages();
        limitLine.dispose();
    }

    private void drawLimitLine() {
        for (int i = 0; i < TetrisConstants.SCREEN_WIDTH; i += TetrisConstants.LIMIT_LINE_LENGTH) {
            game.batch.draw(limitLine, i, TetrisConstants.GAME_HEIGHT);
        }
    }

    private void drawCells() {
        if (boardCells.size == 0) {
            createCells();
        }
        for (Cell cell : boardCells) {
            if (cell.isFull() && cell.currentState != CellState.EMPTY)
                game.batch.draw(cell.currentState.texture, cell.x, cell.y);
        }
    }

    private void createCells() {
        for (int i = 0; i < TetrisConstants.SCREEN_HEIGHT; i += TetrisConstants.CELL_SIZE) {
            for (int j = 0; j < TetrisConstants.SCREEN_WIDTH; j += TetrisConstants.CELL_SIZE) {
                boardCells.add(new Cell(j, i));
            }
        }
    }

    private void drawTetromino() {
        for (Cell cell : tetronimo.getTetronimoCells()) {
            game.batch.draw(cell.currentState.texture, cell.x, cell.y);
        }
    }

    private void spawnTetromino() {
        int random = MathUtils.random(6);
        switch (random){
            case 0:
                tetronimo = new LeftLTetronimo(new Cell(TetrisConstants.SCREEN_CENTER_X, TetrisConstants.SPAWN_HEIGHT), boardCells);
                break;
            case 1:
                tetronimo = new RightLTetronimo(new Cell(TetrisConstants.SCREEN_CENTER_X, TetrisConstants.SPAWN_HEIGHT), boardCells);
                break;
            case 2:
                tetronimo = new SquareTetronimo(new Cell(TetrisConstants.SCREEN_CENTER_X, TetrisConstants.SPAWN_HEIGHT), boardCells);
                break;
            case 3:
                tetronimo = new LineTetronimo(new Cell(TetrisConstants.SCREEN_CENTER_X, TetrisConstants.SPAWN_HEIGHT), boardCells);
                break;
            case 4:
                tetronimo = new LeftZigzagTetronimo(new Cell(TetrisConstants.SCREEN_CENTER_X, TetrisConstants.SPAWN_HEIGHT), boardCells);
                break;
            case 5:
                tetronimo = new RightZigzagTetronimo(new Cell(TetrisConstants.SCREEN_CENTER_X, TetrisConstants.SPAWN_HEIGHT), boardCells);
                break;
            case 6:
                tetronimo = new MountTetronimo(new Cell(TetrisConstants.SCREEN_CENTER_X, TetrisConstants.SPAWN_HEIGHT), boardCells);
                break;
        }
    }

    private void updateBoard() {
        for (Cell boardCell : boardCells) {
            for (Cell cell : tetronimo.getTetronimoCells()) {
                if (cell.equals(boardCell)) {
                    boardCell.currentState = cell.currentState;
                }
            }
        }
    }

    private void moveRowsDown(int startY) {
        for (int y = startY; y < TetrisConstants.SCREEN_HEIGHT; y += TetrisConstants.CELL_SIZE) {
            for (int x = 0; x < TetrisConstants.SCREEN_WIDTH; x += TetrisConstants.CELL_SIZE) {
                Cell aboveCell = getCellAtPosition(x, y + TetrisConstants.CELL_SIZE);
                Cell currentCell = getCellAtPosition(x, y);
                if (aboveCell != null && currentCell != null) {
                    currentCell.currentState = aboveCell.currentState;
                }
            }
        }
    }

    private void clearRow(int y) {
        for (int x = 0; x < TetrisConstants.SCREEN_WIDTH; x += TetrisConstants.CELL_SIZE) {
            Cell cell = getCellAtPosition(x, y);
            if (cell != null) {
                cell.currentState = CellState.EMPTY;
            }
        }
    }

    private Array<Integer> getFullRows() {
        Array<Integer> fullRows = new Array<>();
        for (int i = 0; i < TetrisConstants.SCREEN_HEIGHT; i += TetrisConstants.CELL_SIZE) {
            boolean isRowFull = true;
            for (int j = 0; j < TetrisConstants.SCREEN_WIDTH; j += TetrisConstants.CELL_SIZE) {
                Cell cell = getCellAtPosition(j, i);
                if (cell == null || !cell.isFull()) {
                    isRowFull = false;
                    break;
                }
            }
            if (isRowFull) {
                fullRows.insert(0, i);
            }
        }
        return fullRows;
    }

    private Cell getCellAtPosition(int x, int y) {
        for (Cell cell : boardCells) {
            if (cell.x == x && cell.y == y) {
                return cell;
            }
        }
        return null;
    }
}