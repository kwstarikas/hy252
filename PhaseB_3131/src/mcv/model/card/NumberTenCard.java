package mcv.model.card;

public class NumberTenCard extends NumberCard{
	 
	public boolean canPlayForward;
	public int backORfront;


    /**
     * <b>Accessor</b> gets canPlayForward
     * @return
     */
    public boolean isCanPlayForward() {
        return canPlayForward;
    }


    /**
     * <b>Accessor</b> gets backORfront
     * @return
     */
    public int getBackORfront() {
        return backORfront;
    }


    /**
     * <b>Transformer</b>  sets canPlayForward
     * @param canPlayForward
     */
    public void setCanPlayForward(boolean canPlayForward) {
        this.canPlayForward = canPlayForward;
    }


    /**
     * <b>Transformer</b>  sets backORfront
     * @param backORfront
     */
    public void setBackORfront(int backORfront) {
        this.backORfront = backORfront;
    }


    /**
     * Constructor
     */
    public NumberTenCard() {
    	super(10);
    }
    
    public NumberTenCard(int move) {
    	super(-1);
    }
}