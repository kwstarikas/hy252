package mcv.model.square;

import mcv.model.pawn.Pawn;

public class StartSlideSquare extends SlideSquare {

   
	private boolean checkColor;


    /**
     *<b>Accesor<b/>  gets the color
     * @return
     */
    public boolean isCheckColor() {
        return checkColor;
    }


    /**
     *  <b>Transformer</b> sets the color
     * @param checkColor
     */
    public void setCheckColor(boolean checkColor) {
        this.checkColor = checkColor;
    }


    public StartSlideSquare(int number, Boolean hasPawn, Pawn pawn, int squares, boolean checkColor) {
    	super(number, hasPawn, pawn, squares);
    	this.checkColor = checkColor;
    }
}
