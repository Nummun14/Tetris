package utilities;

public class TetrominoTranslation {
    private double
            x,
            y;

    public TetrominoTranslation() {
        this(0.0, 0.0);
    }

    public TetrominoTranslation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
