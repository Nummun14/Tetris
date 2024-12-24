package com.mygdx.tetris.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.tetris.Tetris;
import com.mygdx.tetris.TetrisConstants;

public class GameOverScreen implements Screen {
    final Tetris game;
    final int score;
    OrthographicCamera camera;

    public GameOverScreen(Tetris game, int score) {
        this.game = game;
        this.score = score;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, TetrisConstants.SCREEN_WIDTH, TetrisConstants.SCREEN_HEIGHT);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Score: " + score, 100, TetrisConstants.SCREEN_HEIGHT / 2 + 50);
        game.font.draw(game.batch, "Game Over!", 100, TetrisConstants.SCREEN_HEIGHT / 2);
        game.font.draw(game.batch, "Tap anywhere to try again!", 100, TetrisConstants.SCREEN_HEIGHT / 2 - 50);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
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

    }
}
