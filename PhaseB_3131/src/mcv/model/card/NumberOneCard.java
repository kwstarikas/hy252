package mcv.model.card;

import mcv.model.pawn.Pawn;

public class NumberOneCard extends NumberCard{
	
	
	
	public void setStart(Pawn pawn){
        pawn.setLocked(false);
    }


    public NumberOneCard() {
    	super(1);
    }
}