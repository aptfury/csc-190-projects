package module5.nsidedpolygon;

/**
 * @author Blake
 * @version 10.04.26
 *
 * Initializes instances of RegularPolygon objects to run their code and print the relevant measurements.
 *
 * @implNote The project in this module5.nsidedpolygon package is taken from my answer to Chapter 9: Auto-Graded Programming
 * Project 2 in Introduction to Java Programming and Data Structures by Y. Daniel Liang.
 */
public class Exercise {
    /**
     * @param args [String[]] - no args used
     */
    public static void main(String[] args) {
        RegularPolygon rp1 = new RegularPolygon();
        RegularPolygon rp2 = new RegularPolygon(6, 4);
        RegularPolygon rp3 = new RegularPolygon(10, 4, 5.6, 7.8);
    }
}