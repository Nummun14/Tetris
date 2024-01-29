package tetrominoes;

import utilities.TetrominoPosition;
import utilities.TetrominoTranslation;
import utilities.TetronimoRotation;

public class SquareTetromino {
    private final TetrominoPosition tetrominoPosition;
    public SquareTetromino(TetrominoPosition tetrominoPosition) {
        this.tetrominoPosition = tetrominoPosition;
    }

    public SquareTetromino(TetrominoTranslation tetrominoTranslation, TetronimoRotation tetrominoRotation) {
        this.tetrominoPosition = new TetrominoPosition(tetrominoTranslation, tetrominoRotation);
    }
}
