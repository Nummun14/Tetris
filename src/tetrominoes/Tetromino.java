package tetrominoes;

import utilities.TetrominoPosition;

public abstract class Tetromino {
    private final TetrominoPosition position = new TetrominoPosition();

    public void rotate() {
        position.tetronimoRotation.setRotation(position.tetronimoRotation.rotation + 90);
    }
}
