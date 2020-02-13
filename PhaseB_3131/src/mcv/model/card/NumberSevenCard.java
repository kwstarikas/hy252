package mcv.model.card;

public class NumberSevenCard extends NumberCard {
	
	 private boolean moveBoth;
    private int move1;
    private int move2;


    /**
     * <b>Transformer</b> checks if move1 + move2 is seven in total
     * @return
     */
    public boolean isMoveBoth() {
        if (move1+move2 == 7) return true;
        return false;
    }


    /**
     * <b>Accessor</b> gets move1
     * @return
     */
    public int getMove1() {
        return move1;
    }


    /**
     * <b>Accessor</b> gets move2
     * @return
     */
    public int getMove2() {
        return move2;
    }


    /**
     * <b>Transformer</b>  sets moveboth
     * @param moveBoth
     */
    public void setMoveBoth(boolean moveBoth) {
        this.moveBoth = moveBoth;
    }

    /**
     * <b>Transformer</b>  sets move1
     * @param move1
     */
    public void setMove1(int move1) {
        this.move1 = move1;
    }

    /**
     * <b>Transformer</b>  sets move2
     * @param move2
     */
    public void setMove2(int move2) {
        this.move2 = move2;
    }

    /**
     * <b>Observer</b> checks if move can be played
     * @return
     */
    public boolean canBePlayed() {
    	return true;
    }


    /**
     * Constructor
     */
    public NumberSevenCard() {
    	super(7);
    }
    
}