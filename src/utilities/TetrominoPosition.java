package utilities;

public class TetrominoPosition {
    private final TetrominoTranslation tetrominoTranslation;
    private final TetronimoRotation tetronimoRotation;
    public TetrominoPosition(TetrominoTranslation tetronimoTranslation, TetronimoRotation tetrominoRotation) {
        this.tetronimoRotation = tetrominoRotation;
        this.tetrominoTranslation = tetronimoTranslation;
    }
}
