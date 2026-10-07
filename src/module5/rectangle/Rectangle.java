package module5.rectangle;

/**
 * @author Blake
 * @version 10.04.26
 *
 * Creates a module5.rectangle with measurements dependent upon which constructor is used, with attached methods for
 * calculating the area and the perimeter that automatically trigger when an instance is created.
 *
 * @implNote All data fields and constructors are protected while all methods are private simply for the sake of
 * getting practice using them and adding elements with protected status in UML elements since I don't use them much.
 *
 * @implNote The project in this module5.rectangle package is taken from my answer to Chapter 9: Auto-Graded Programming Project
 * 1 in Introduction to Java Programming and Data Structures by Y. Daniel Liang.
 */
class Rectangle {
    // I used protected here just to get a bit of practice writing it
    // both in the class and in the UML Diagram.
    protected double width;
    protected double height;

    /**
     * Constructor with no params that defaults to width of 1 and height of 2.
     * Automatically triggers getArea() and getPerimeter().
     */
    protected Rectangle() {
        this.width = 1;
        this.height = 2;

        System.out.print(this.width);
        System.out.print(this.height);
        System.out.print(this.getArea());
        System.out.print(this.getPerimeter());
    }

    /**
     * Constructor that takes width and height parameters.
     * Automatically triggers getArea() and getPerimeter().
     *
     * @param width [double] - the width of the module5.rectangle
     * @param height [double] - the height of the module5.rectangle
     */
    protected Rectangle(double width, double height) {
        this.width = width;
        this.height = height;

        System.out.print(this.width);
        System.out.print(this.height);
        System.out.print(this.getArea());
        System.out.print(this.getPerimeter());
    }

    /**
     * Calculates the area of the module5.rectangle using the width and height data fields.
     *
     * @return [double] - the area of the module5.rectangle
     */
    private double getArea() {
        return this.width * this.height;
    }

    /**
     * Calculates the perimeter of the module5.rectangle using the width and height data fields.
     *
     * @return [double] - the perimeter of the module5.rectangle
     */
    private double getPerimeter() {
        return this.width * 2 + this.height * 2;
    }
}