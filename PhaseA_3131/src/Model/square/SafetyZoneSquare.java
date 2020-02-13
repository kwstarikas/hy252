package Model.square;

import java.awt.*;

public class SafetyZoneSquare extends Square {

    private Color color;


    /**
     *<b>Accesor<b/>  gets the color
     * @return
     */
    public Color getColor() {
        return color;
    }


    /**
    * <b>Transformer</b> sets the color
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }


    /**
     *  <b>Transformer</b> sets pawn to be protected
     * @param pawn
     * @return
     */
    public boolean setProtect(Pawn pawn);


    /**
     * return true if the pawn goes in with forward move, false otherwise
     * @return
     */
    public boolean checkFrontMove();


    /**
     * Constructor
     */
    public SafetyZoneSquare();
}
