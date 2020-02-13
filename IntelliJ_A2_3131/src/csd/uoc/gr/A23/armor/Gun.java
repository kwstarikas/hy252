package csd.uoc.gr.A23.armor;

public abstract class Gun {
    final int power ;

    /**
     * Customize the power of a Gun
     * @param power the minimum value of the integer
     */

    public Gun (int power){
        this.power = power;
    }

    /**
     * Returns  the power of a Gun
     */
    public int getPower(){
        return power;
    }

}
