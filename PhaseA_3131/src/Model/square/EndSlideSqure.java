package Model.square;

public class EndSlideSqure extends SlideSquare {

    private boolean checkSameColor,checkForwardMove;


    /**
     * <b>Accesor<b/> gets the checkSame color true if its the same false otherwise
     * @return
     */
    public boolean isCheckSameColor() {
        return checkSameColor;
    }


    /**
     * <b>Accesor<b/> gets the checkForward move , if the move is from forward then treu false otherwise
     * @return
     */
    public boolean isCheckForwardMove() {
        return checkForwardMove;
    }


    /**
     *  <b>Transformer</b> sets the checkSame color
     * @param checkSameColor
     */
    public void setCheckSameColor(boolean checkSameColor) {
        this.checkSameColor = checkSameColor;
    }



    /**
     *  <b>Transformer</b> sets the  checkForwardMove
     * @param checkForwardMove
     */
    public void setCheckForwardMove(boolean checkForwardMove) {
        this.checkForwardMove = checkForwardMove;
    }

}
