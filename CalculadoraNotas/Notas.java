package dtisoy.notas;

/**
 *
 * @author dtisoy
 */
public class Notas {

    public double[] gradeLst;

    public Notas() {
        gradeLst = new double[5];
      
    }

    public double calculateMean() {
        double sum = 0;
        for (double grade : this.gradeLst) {
            sum += grade;
        }
        return sum / this.gradeLst.length;
    }

    public double calculateDeviation() {
        double mean = this.calculateMean();

        double sum = 0;
        for (double grade : this.gradeLst) {
            sum += Math.pow(grade - mean, 2);

        }
        return Math.sqrt(sum / this.gradeLst.length);
    }

    public double getMinGrade() {
        double min = this.gradeLst[0];

        for (double grade : this.gradeLst) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

    public double getMaxGrade() {
        double max = this.gradeLst[0];

        for (double grade : this.gradeLst) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }
}
