package utilities;

public class TetrominoPosition {
    private final TetrominoTranslation tetrominoTranslation;
    private final TetronimoRotation tetronimoRotation;

    public TetrominoPosition() {
        this(new TetrominoTranslation(), new TetronimoRotation());
    }

    public TetrominoPosition(TetrominoTranslation tetronimoTranslation, TetronimoRotation tetrominoRotation) {
        this.tetronimoRotation = tetrominoRotation;
        this.tetrominoTranslation = tetronimoTranslation;
    }

    public TetrominoPosition(double x, double y, double rotation) {
        this(new TetrominoTranslation(x, y), new TetronimoRotation(rotation));
    }

    public TetrominoTranslation getTranslation() {
        return tetrominoTranslation;
    }

    public TetronimoRotation getRotation() {
        return tetronimoRotation;
    }
}
