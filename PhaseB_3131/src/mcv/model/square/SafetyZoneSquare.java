package mcv.model.square;

import java.awt.Color;

public class SafetyZoneSquare extends Square{
	
	private Color color;
	
	
	/**
	 * Constructor if a safety zone square
	 * @param number
	 * @param hasPawn
	 * @param color
	 */
	public SafetyZoneSquare(int number, boolean hasPawn, Color color) {
		super(number, hasPawn, null);
		this.color = color;
	}
	
	/**
	 * <b>Accessor</b>Gets the color
	 * @return
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * <b>Transformer</b>Sets the color of a pawn
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
	/**
	 * <b>Observer</b>To string method to print the name of the square
	 */
	public String toString() {
		return "SafetyZone" + super.toString();
	}

}