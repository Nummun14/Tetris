package tetrominoes;

import utilities.TetrominoPosition;

public abstract class Tetromino {
    private final TetrominoPosition position = new TetrominoPosition();

    public void rotate() {
        position.getRotation().setRotation(position.getRotation().getRotation() + 90);
    }
}
