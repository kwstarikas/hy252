package mcv.model.square;

import mcv.model.pawn.Pawn;

public class SlideSquare extends Square{
	


    private int squares;


    /**
     * <b>Accesor<b/>  gets the squares
     * @return
     */
    public int getSquares() {
        return squares;
    }


    /**
     *  <b>Transformer</b> sets the numver of slide squares
     * @param squares
     */
    public void setSquares(int squares) {
        this.squares = squares;
    }


    /**
     * constructor for a Slide square
     */
    public SlideSquare(int number, boolean hasPawn, Pawn pawn, int squares) {
    	super(number, hasPawn, pawn);
    	this.squares = squares;
    	
    }

}
