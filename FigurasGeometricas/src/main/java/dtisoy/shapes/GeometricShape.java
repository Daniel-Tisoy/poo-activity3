package dtisoy.shapes;

/**
 *
 * @author dtisoy
 */
abstract class GeometricShape {
    private double volume;
    private double surface;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }
}
