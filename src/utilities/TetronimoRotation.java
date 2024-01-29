package utilities;

public class TetronimoRotation {
    private double rotation;

    public TetronimoRotation() {
        this(0.0);
    }

    public TetronimoRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }
}
