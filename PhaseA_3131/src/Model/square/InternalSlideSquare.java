package Model.square;

public class InternalSlideSquare extends SlideSquare {


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
    public InternalSlideSquare();

}
