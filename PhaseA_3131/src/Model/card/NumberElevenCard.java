package Model.card;

import Model.pawn.Pawn;

public class NumberElevenCard extends NumberCard {

    private int move;


    /**
     * <b>Accessor</b> gets Move
     * @return
     */
    public int getMove() {
        return move;
    }


    /**
     * <b>Transformer</b>  sets move
     * @param move
     */
    public void setMove(int move) {
        this.move = move;
    }


    /**
     * <b>Observer<b/>  checks if a pawn is at start
     * @param pawn
     * @return
     */
    public boolean checkStart(Pawn pawn);


    /**
     * <b>Observer<b/> checks if a pawn is safe
     * @param pawn
     * @return
     */
    public boolean checkSafe(Pawn pawn);


    /**
     * Constructor
     */
    public NumberElevenCard();

}
