
package Model.square;
public class HomeSquare extends Square {


    private int howManyPawns;


    /**
     * <b>Accesor<b/> gets the pawn of the square
     * @return
     */
    public int getHowManyPawns() {
        return howManyPawns;
    }


    /**
     *  <b>Transformer</b> sets the number of the pawns
     * @param howManyPawns
     */
    public void setHowManyPawns(int howManyPawns) {
        this.howManyPawns = howManyPawns;
    }


    /**
     *  <b>Transformer</b> locks a pawn
     * @param pawn
     * @return
     */
    public boolean setLock(Pawn pawn);


    /**
     * checks how many squares left for the pawn
     * @param pawn
     * @return
     */
    public boolean checkSquareLeft(Pawn pawn);
}
