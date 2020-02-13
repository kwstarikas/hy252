package Model.pawn;

import java.awt.*;

public class Pawn {


    private Color color;
    private int block;
    private boolean isActive;
    private boolean isLocked;
    private boolean isprotected;


    /**
     * Constructor
     * @param color
     * @param block
     * @param isActive
     * @param isLocked
     * @param isprotected
     */
    public Pawn(Color color, int block , boolean isActive , boolean isLocked, int isprotected) {}



    /**
     *  <b>Transformer</b> sets the color of a pawn
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }


    /**
     * <b>Transformer</b>  sets the block of a pawn
     * @param block
     */
    public void setBlock(int block) {
        this.block = block;
    }


    /**
     * <b>Transformer</b>  sets active field of a pawn
     * @param active
     */
    public void setActive(boolean active) {
        isActive = active;
    }


    /**
     * <b>Transformer</b>  sets locked field of a pawn
     * @param locked
     */
    public void setLocked(boolean locked) {
        isLocked = locked;
    }


    /**
     * <b>Accesor<b/> gets the color of a pawn
     * @return
     */
    public Color getColor() {
        return color;
    }


    /**
     *<b>Accesor<b/>  gets the block of a pawn
     * @return
     */
    public int getBlock() {
        return block;
    }


    /**
     *<b>Accesor<b/> gets is active
     * @return
     */
    public boolean isActive() {
        return isActive;
    }


    /**
     *<b>Accesor<b/> gets is locked
     * @return
     */
    public boolean isLocked() {

        return isLocked;
    }


    /**
     *<b>Accesor<b/> gets isprotected
     * @return
     */
    public boolean isIsprotected() {
        return isprotected;
    }


    /**
     * <b>Transformer</b> sets the isprotected field of a pawn
     * @param isprotected
     */
    public void setIsprotected(boolean isprotected) {
        this.isprotected = isprotected;
    }


}
