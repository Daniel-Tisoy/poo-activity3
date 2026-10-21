package dtisoy.shapes;

/**
 *
 * @author dtisoy
 */
public class Cilinder extends GeometricShape {

    private double radio;
    private double height;

    public Cilinder(double radio, double height) {
        this.radio = radio;
        this.height = height;
        this.setVolume(calculateVolume());
        this.setSurface(calculateSurface());
    }

    private double calculateVolume() {
        double volume = Math.PI * this.height * Math.pow(radio, 2);
        return volume;
    }

    private double calculateSurface() {
        double areaSideA = 2 * Math.PI * this.radio * this.height;
        double areaSideB = 2 * Math.PI * Math.pow(radio, 2);
        return areaSideA + areaSideB;
    }

}
