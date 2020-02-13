package mcv.model.card;

import mcv.model.pawn.Pawn;
import mcv.controller.Controller;

public class NumberTwoCard extends NumberCard{
	

    /**
     * <b>Transformer</b> sets the turn to be the same again
     * @return
     */
    public int setTurn() {

    	int turn = setTurn();
    	return turn;
    }


    /**
     * <b>Transformer</b>  A pawn can be started
     * @param pawn
     */

	public void setStart(Pawn pawn){
        pawn.setLocked(false);
    }
    /**
     * Constructor
     */
    public NumberTwoCard() {
    	super(2);
    }

}