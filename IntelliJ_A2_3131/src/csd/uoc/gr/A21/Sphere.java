package csd.uoc.gr.A21;

public class Sphere extends  SolidShape {

    private double radius;


    /**
     * gets radius
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * sets radius
     * @param radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * constructor for a sphere
     * @param x
     * @param y
     * @param z
     * @param radius
     */
    public Sphere(double x, double y, double z, double radius) {
        super(x, y, z);
        this.radius = radius;
    }

    /**
     *
     * @return 1
     */
    public int getNumberOfVertices() {
        return 1;
    }

    /**
     *
     * @return 1
     */
    public int getNumberOfFaces() {
        return 1;
    }

    /**
     *
     * @return volume
     */
    public double getVolume() {
        return ((double)4/3)*Math.PI*Math.pow(radius,3);
    }

    /**
     * prints a sphere
     * @return string
     */
    public String toString() {

        return "Sphere "+super.toString()+"\nradius :"+radius;
    }
}
