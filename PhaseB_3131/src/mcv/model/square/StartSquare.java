
package mcv.model.square;


import java.awt.Image;

import mcv.model.pawn.*;
public class StartSquare extends Square {
	
    int player;
    int value;
    
    
    /**
     * Constructor of a start square
     * @param value
     * @param hasPawn
     * @param pawn
     */
    public StartSquare(int value, boolean hasPawn,Pawn pawn){
        super(value,hasPawn,pawn);
        
    }
    
    /**
     * <b>Accessor</b>Gets the player of the square
     */
    public int getPlayer() {
		return player;
	}

    /**
     * <b>Transformer</b>Sets the player of the square
     */
	public void setPlayer(int player) {
		this.player = player;
	}

	/**
	 * <b>Accessor</b>Gets the value of the square
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <b>Transformer</b>Sets the value of the square
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * <b>Observer</b>To string method to print the name of the square
	 */
	public String toString() {
		return "Start" + super.toString();
	}
    
    


}