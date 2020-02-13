package csd.uoc.gr.A21;

public class Cylinder extends SolidShape {

    private double radius, height;

    /**
     * constructor for a cylinder
     * @param x
     * @param y
     * @param z
     * @param radius
     * @param height
     */

    public Cylinder(double x, double y, double z, double radius, double height) {
        super(x,y,z);
        this.radius = radius;
        this.height = height;
    }

    /**
     * gets number of faces
     * @return 2
     */
    public int getNumberOfFaces() {
        return 2;
    }

    /**
     *
     * @return volume of a cylinder
     */
    public double getVolume() {
        return Math.PI * Math.pow(radius,2)*height;
    }

    /**
     * prints the Cylinder
     * @return string
     */
    public String toString() {
        return "Cylinder "+super.toString()+"\nradius :"+radius
                +"\nheight "+height;
    }
}
