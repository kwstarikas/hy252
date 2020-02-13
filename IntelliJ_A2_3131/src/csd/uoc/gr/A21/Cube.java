package csd.uoc.gr.A21;

public class Cube extends SolidShape {
    private double side;


    /**
     * get method for side
     * @return side
     */
    public double getSide() {
        return side;
    }

    /**
     * sets the side
     * @param side
     */
    public void setSide(double side) {
        this.side = side;
    }

    /**
     * constructor of cube sets a cube
     * @param x
     * @param y
     * @param z
     * @param side
     */
    public Cube(double x, double y, double z, double side) {

        super(x, y, z);
        this.side = side;

    }

    /**
     * gets number of faces
     * @return 6
     */
    public int getNumberOfFaces() {
        return 6;
    }

    /**
     * gets number of Vertices
     * @return 2
     */
    public int getNumberOfVertices() {
        return 2;
    }

    /**
     * gets number of edges
     * @return 12
     */
    public int getNumberOfEdges() {
        return 12;
    }

    /**
     * gets volume
     * @return 3 times the side
     */
    public double getVolume() {
        return 3*side;
    }


    /**
     * Prints the Cube
     * @return a string
     */
    public String toString() {
        return "Cube "+super.toString()+"\nside :"+side;
    }
}
