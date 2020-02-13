package mcv.model.square;

import mcv.model.pawn.Pawn;

public class InternalSlideSquare extends SlideSquare{


    private boolean CheckColor;


    /**
     * <b>Accesor<b/> gets the color of
     * @return
     */
    public boolean isCheckColor() {
        return CheckColor;
    }


    /**
     *  <b>Transformer</b> sets the color
     * @param checkColor
     */
    public void setCheckColor(boolean checkColor) {
        CheckColor = checkColor;
    }

    /**
     * Constructor
     */
    public InternalSlideSquare(int num, boolean has , Pawn pawn, int squares, boolean CheckColor) {
    	super(num,has,pawn,squares);
    	this.CheckColor = CheckColor;
    }

}