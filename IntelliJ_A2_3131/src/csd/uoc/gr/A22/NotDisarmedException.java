package csd.uoc.gr.A22;

public class NotDisarmedException extends Exception {


    /**
     * @see throws exception if alarm is not disarmed
     */
    NotDisarmedException(){
        super("Alarm is not disarmed");
    }
}
