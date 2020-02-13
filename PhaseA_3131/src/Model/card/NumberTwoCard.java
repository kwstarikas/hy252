package Model.card;

import Model.pawn.Pawn;

public class NumberTwoCard extends NumberCard {


    /**
     * <b>Transformer</b> sets the turn to be the same again
     * @return
     */
    public int setTurn();


    /**
     * <b>Transformer</b>  A pawn can be started
     * @param pawn
     * @return
     */
    public boolean setStart(Pawn pawn);


    /**
     * Constructor
     */
    public NumberTwoCard();
}
