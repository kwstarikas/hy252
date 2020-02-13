package csd.uoc.gr.A22;

public class DoorsOpenException extends Exception{


    /**
     * @see throws an exception "Door is open "
     */
    public DoorsOpenException(){
        super("Door is open");
    }
}
