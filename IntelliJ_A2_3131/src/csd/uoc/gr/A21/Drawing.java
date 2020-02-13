package csd.uoc.gr.A21;


class Drawing{

    private static int activeCapacity = 0;
    private SolidShape[] arr = new SolidShape[1000];
    int faces=0 , vertices=0 ,edges=0;
    double volume =0;
    SolidShape s ;

    /**
     * checks if active capacity is les than 1000 if so
     * add a shape
     * @param s
     */
    public void add(SolidShape s){
        if (activeCapacity < 1000)

        {
            arr[activeCapacity] = s;
            activeCapacity++;
        }

        else
            System.out.println("Array is full");
        return;
    }

    /**
     * prints the content of a drawing
     * @return string
     */
    public String toString(){
        String S;
        System.out.println("Activecapacity: " + activeCapacity+"\n");
        for (int i=0; i<activeCapacity; i++){
            faces += arr[i].getNumberOfFaces();
            vertices += arr[i].getNumberOfVertices();
            edges += arr[i].getNumberOfEdges();
            volume += arr[i].getVolume();
        }

        S = "Number of Shapes :" + activeCapacity
                +"\nTotal faces : "+ faces
                +"\nTotal verticles : "+vertices
                +"\nTotal edges : "+ edges
                +"\nTotal volume : "+ volume;

        return S;
    }
}
