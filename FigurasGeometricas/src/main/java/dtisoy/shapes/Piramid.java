package dtisoy.shapes;

/**
 *
 * @author dtisoy
 */
public class Piramid extends GeometricShape {
    private final double base;
    private final double height;
    private final double apothem;

    public Piramid(double base, double height, double apothem) {
        this.base = base;
        this.height = height;
        this.apothem = apothem;
        this.setVolume(calculateVolume());
        this.setSurface(calculateSurface());
    }

    private double calculateVolume() {
        double volume = (Math.pow(base, 2)*this.height)/3;
        return volume;
    }

    private double calculateSurface() {
        double areaBase = Math.pow(this.base, 2);
        double areaSide = 2*this.base*this.apothem; 
        return areaBase + areaSide;
    }
    
}
