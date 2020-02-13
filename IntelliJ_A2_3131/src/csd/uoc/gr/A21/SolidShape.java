package csd.uoc.gr.A21;

public class SolidShape {

    private double x,y,z;


    /**
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }


    /**
     *
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }


    /**
     *
     * @return z
     */
    public double getZ() {
        return z;
    }

    /**
     *
     * @param z
     */
    public void setZ(double z) {
        this.z = z;
    }


    /**
     * constructor of a solid shape
     * @param x
     * @param y
     * @param z
     */
    public SolidShape(double x , double y , double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @return 0
     */
    public int getNumberOfFaces() {
        return 0;
    }

    /**
     *
     * @return 0
     */
    public int getNumberOfVertices() {
        return 0;
    }

    /**
     * gets number of edges
     * @return 0
     */
    public int getNumberOfEdges() {
        return 0;
    }

    /**
     * gets volume
     * @return 0
     */
    public double getVolume() {
        return 0;
    }

    /**
     * prints  a sholid shape
     * @return a string
     */
    public String toString() {

        return "Solid shape centered at("+
                x +","+y+","+z+") with\nfaces :"+getNumberOfFaces()+"\nverticles:"
                +getNumberOfVertices()+"\nedges  :" +getNumberOfEdges()+
                "\nvolume: "+getVolume();
    }

}

