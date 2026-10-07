package module5.nsidedpolygon;

/**
 * @author Blake
 * @version 10.04.26
 *
 * Creates a RegularPolygon instance with measurements based on which constructor is used. Getter and setter methods
 * are available for data access and mutation, as well as two methods available for getting the perimeter and area of
 * the polygon. Methods are automatically triggered when an instance is created.
 *
 * @implNote The project in this module5.nsidedpolygon package is taken from my answer to Chapter 9: Auto-Graded Programming
 * Project 2 in Introduction to Java Programming and Data Structures by Y. Daniel Liang.
 */
class RegularPolygon {
    private int n; // number of sides
    private double side; // length of a side
    private double x = 0; // x-coordinate of the center of the polygon; default: 0
    private double y = 0; // y-coordinate of the center of the polygon; default: 0

    /**
     * No-param constructor that creates a default polygon with 3 sides that are 1 (unit) long.
     * Automatically triggers getArea() and getPerimeter().
     */
    public RegularPolygon() {
        // data fields
        this.setN(3);
        this.setSide(1);

        // calculate and print perimeter and area
        System.out.print(this.getPerimeter());
        System.out.print(this.getArea());
    }

    /**
     * Constructor with params that only set the number and length of sides; Uses default coordinates.
     * Automatically triggers getArea() and getPerimeter().
     *
     * @param n [int] the number of sides
     * @param side [double] the length of a side
     */
    public RegularPolygon(int n, double side) {
        // set data fields
        this.setN(n);
        this.setSide(side);

        // calculate and print perimeter and area
        System.out.print(this.getPerimeter());
        System.out.print(this.getArea());
    }

    /**
     * Constructor with params that set number of sides, length of a side, and both coordinates.
     * Automatically triggers getArea() and getPerimeter().
     *
     * @param n [int] the number of sides
     * @param side [double] the length of a side
     * @param x [double] x-coordinate of the center
     * @param y [double] y-coordinate of the center
     */
    public RegularPolygon(int n, double side, double x, double y) {
        // set data fields
        this.setN(n);
        this.setSide(side);
        this.setX(x);
        this.setY(y);

        // calculate and print perimeter and area
        System.out.print(this.getPerimeter());
        System.out.print(this.getArea());
    }

    /**
     * Retrieves the number of sides.
     *
     * @return [int] number of sides
     */
    public int getN() {
        return this.n;
    }

    /**
     * Updates the number of sides.
     *
     * @param n [int] number of sides
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * Retrieves the length of a side.
     *
     * @return [double] length of a side
     */
    public double getSide() {
        return this.side;
    }

    /**
     * Updates the length of a side.
     *
     * @param side [double] length of a side
     */
    public void setSide(double side) {
        this.side = side;
    }

    /**
     * Retrieves the x-coordinate of polygon center.
     *
     * @return [double] x-coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * Updates the x-coordinate of polygon center.
     *
     * @param x [double] x-coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Retrieves the y-coordinate of polygon center.
     *
     * @return [double] y-coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * Updates the y-coordinate of polygon center.
     *
     * @param y [double] y-coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Calculates and returns the perimeter of the polygon.
     *
     * @return [double] perimeter
     */
    public double getPerimeter() {
        return this.getN() * this.getSide();
    }

    /**
     * Calculates and returns the area of the polygon.
     *
     * @return [double] area
     */
    public double getArea() {
        return (this.getN() * Math.pow(this.getSide(), 2)) / (4 * Math.tan(Math.PI / this.getN()));
    }
}