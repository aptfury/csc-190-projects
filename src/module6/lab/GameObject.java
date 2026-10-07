package module6.lab;

/**
 * @author Blake
 * @version 10.07.26
 *
 * A class for the game object to manage its positioning.
 */
public class GameObject {
    private int x;
    private int y;
    private int layer;

    /**
     * Initializes x, y, and layer to 0
     */
    public GameObject() {
        this.x = 0;
        this.y = 0;
        this.layer = 0;
    }

    /**
     * Initializes coordinate x and y
     *
     * @param x [int]
     * @param y [int]
     */
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.layer = 0;
    }

    /**
     * Initializes coordinate x, y, and the layer
     *
     * @param x [int]
     * @param y [int]
     * @param layer [int]
     */
    public GameObject(int x, int y, int layer) {
        this.x = x;
        this.y = y;
        this.layer = layer;
    }

    /**
     * Retrieve x
     *
     * @return int
     */
    public int getX() {
        return this.x;
    }

    /**
     * Update x
     *
     * @param x [int]
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retrieve y
     *
     * @return int
     */
    public int getY() {
        return this.y;
    }

    /**
     * Update y
     *
     * @param y [int]
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Retrieve layer
     *
     * @return int
     */
    public int getLayer() {
        return this.layer;
    }

    /**
     * Update layer
     *
     * @param layer [int]
     */
    public void setLayer(int layer) {
        this.layer = layer;
    }
}
