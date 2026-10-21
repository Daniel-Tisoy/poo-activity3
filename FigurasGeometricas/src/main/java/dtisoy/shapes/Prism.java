package dtisoy.shapes;

/**
 *
 * @author dtisoy
 */
public class Prism extends GeometricShape {

    private final double side;
    private final double height;
    private final double apothem;
    private double areaBase;

    public Prism(double side, double height, double apothem) {
        this.side = side;
        this.height = height;
        this.apothem = apothem;
        this.areaBase = calculateBaseArea();

        this.setVolume(calculateVolume());
        this.setSurface(calculateSurface());
    }

    private double calculateBaseArea() {
        return (6 * this.side * this.apothem) / 2;
    }

    private double calculateVolume() {
        double volume = this.areaBase * this.height;
        return volume;
    }

    private double calculateSurface() {
        double surface = this.areaBase * 2 + this.height * this.side * 6;
        return surface;
    }
}
