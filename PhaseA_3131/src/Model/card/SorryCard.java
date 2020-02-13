package Model.card;

import Model.pawn.Pawn;

public class SorryCard extends Card {


    private boolean canBePlayed;

    /**
     * <b>Transformer</b> sets isActive true
     * @return
     */
    public boolean isActive(){
        return true;
    }


    /**
     *
     * @param pawn
     * @return
     */
    private boolean getPawn(Pawn pawn);

    @Override
    public String toString() {
        return "SorryCard";
    }

    @Override
    public void movePawn() {

    }
}
