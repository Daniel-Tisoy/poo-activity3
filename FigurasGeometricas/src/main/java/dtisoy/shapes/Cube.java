package dtisoy.shapes;

/**
 *
 * @author dtisoy
 */
public class Cube extends GeometricShape {

    private double side;

    public Cube(double side) {
        this.side = side;
        this.setSurface(this.calculateVolume());
        this.setVolume(this.calculateSurface());
    }

    private double calculateVolume() {
        return Math.pow(this.side, 3);
    }

    private double calculateSurface() {
        return 6 * Math.pow(side, 2);
    }

}
