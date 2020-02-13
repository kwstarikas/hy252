package Model.card;

public abstract class Card {


    boolean isActive;


    /**
     * <b>Observer:</b>
     * <b>Postcondition:</b> sets card to active
     * @param active
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * <b>Observer<b/>
     *  <b>Postcondition:</b> checks if card is active
     * @return
     */
    public  abstract boolean isActive(){
        return isActive;
    }


    /**
     * <b>Transformer:</b>  Info about card
     * @return
     */
    public abstract String toString();


    /**
     * <b>Transformer:</b> moves a pawn
     */
    public abstract void movePawn(Pawn pawn);



}
