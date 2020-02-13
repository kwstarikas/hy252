package Model.card;

public class NumberCard extends Card {

    private int value;
    private int numCardPlayed;


    /**
     * <b>Transformer:</b>  sets the value of the card
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }


    /**
     * <b>Transformer:</b> sets numCardPlayed
     * @param numCardPlayed
     */
    public void setNumCardPlayed(int numCardPlayed) {
        this.numCardPlayed = numCardPlayed;
    }


    /**
     * <b>Accesor<b/> gets the value
     * @return
     */
    public int getValue() {
        return value;
    }


    /**
     *  <b>Accesor<b/> gets numCardPlayed
     * @return
     */
    public int getNumCardPlayed() {
        return numCardPlayed;
    }


    @Override
    /**
     * <b>Transformer:</b> moves a pawn
     */
    public String toString() {
        return "NumberCard";
    }



    @Override
    public void movePawn() {

    }
}



