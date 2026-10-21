package dtisoy.shapes;

/**
 *
 * @author dtisoy
 */
public class Sphere extends GeometricShape {

    private final double radio;

    public Sphere(double radio) {
        this.radio = radio;
        this.setVolume(calculateVolume());
        this.setSurface(calculateSurface());
    }

    private double calculateVolume() {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(this.radio, 3);
        return volume;
    }

    private double calculateSurface() {
        double surface = 4 * Math.PI * Math.pow(this.radio, 2);
        return surface;
    }
}
