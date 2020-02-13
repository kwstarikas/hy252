package mcv.model.square;

import java.awt.Image;

import mcv.model.pawn.*;
import mcv.model.pawn.*;
public class Square {
	
	private int number,player;
	private boolean hasPawn;
	private Pawn whitchPawm;
	private Image image;
	
	
	/**
	 * Constructor of a square
	 * @param number
	 * @param hasPawn
	 * @param pawn
	 */
	public Square(int number, boolean hasPawn, Pawn pawn) {
		this.number = number;
		this.hasPawn = hasPawn;
		this.whitchPawm = pawn;
		
	}
	
	/**
	 * <b>Accessor</b>Gets the image
	 * @return
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * <b>Transformer</b>Sets the image
	 * @param image
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * <b>Accessor</b>
	 * @return
	 */
	public Pawn getWhitchPawm() {
		return whitchPawm;
	}

	public void setWhitchPawm(Pawn whitchPawm) {
		this.whitchPawm = whitchPawm;
	}

	/**
	 * <b>Accessor</b>Gets the number of the square
	 * @return
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * <b>Transformer</b>Sets the number of the square
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * <b>Accessor</b>Return the player of the square
	 * @return
	 */
	public int getPlayer() {
		return player;
	}
	
	/**
	 * <b>Transformer</b>Sets the player of the square
	 * @param player
	 */
	public void setPlayer(int player) {
		this.player = player;
	}
	
	/**
	 * <b>Accessor</b>Return if square has pawn
	 * @return
	 */
	public boolean isHasPawn() {
		return hasPawn;
	}
	
	/**
	 * <b>Transformer</b>Sets the has pawn
	 * @param hasPawn
	 */
	public void setHasPawn(boolean hasPawn) {
		this.hasPawn = hasPawn;
	}
	
	/**
	 * <b>Observer</b>To string method to print the name of the square
	 */
	public String toString() {
		return "Square";
	}
	
	
}