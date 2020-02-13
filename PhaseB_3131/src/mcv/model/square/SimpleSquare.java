package mcv.model.square;

import java.awt.Image;

public class SimpleSquare extends Square{

	
	private boolean hasPawn;
	
	/**
	 * Constructor of a simple square
	 * @param value
	 * @param hasPawn
	 */
	public SimpleSquare(int value, boolean hasPawn) {
		super(value,hasPawn,null);
	}
	
	/**
	 * <b>Accessor</b> gets if it has pawn
	 */
	public boolean isHasPawn() {
		return hasPawn;
	}

	/**
	 * <b>Transformer</b>Sets has pawn
	 */
	public void setHasPawn(boolean hasPawn) {
		this.hasPawn = hasPawn;
	}
	
	/**
	 * <b>Observer</b>To string method to print the name of the square
	 */
	public String toString() {
		return "Simple " + super.toString(); 
	}


}