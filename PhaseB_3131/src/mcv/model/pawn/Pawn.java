package mcv.model.pawn;

import java.awt.Color;

public class Pawn {

	
	private Color color;
	private int block;
	private boolean isActive, isLocked, isProtected;
	private String image;

	

	/**
	 * Constractor of a pawn
	 * @param color
	 * @param block
	 * @param isActive
	 * @param isLocked
	 * @param isProtected
	 */
	public Pawn(Color color, int block, boolean isActive, boolean isLocked, boolean isProtected) {
		this.color = color;
		this.block = block;
		this.isActive = isActive;
		this.isLocked = true;
		this.isProtected = isProtected;
		
	}

	/**
	 * <b>Accessor</b>Gets the image
	 * @return
	 */
	public String getImage() {
		return image;
	}

	
	/**
	 * <b>Transformer</b>Sets the image
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	
	/**
	 * <b>Accessor</b>Gets the color
	 * @return
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * <b>Transformer</b>Sets the color
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * <b>Accessor</b>Gets the block that the pawn is 
	 * @return
	 */
	public int getBlock() {
		return block;
	}
	
	/**
	 * <b>Transformer</b>Sets the block of pawn
	 * @param block
	 */
	public void setBlock(int block) {
		this.block = block;
	}
	
	/**
	 * <b>Accessor</b>Gets if pawn is active
	 * @return
	 */
	public boolean isActive() {
		return isActive;
	}
	
	/**
	 * <b>Transformer</b>Sets the active of a pawn
	 * @param isActive
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * <b>Accessor</b>Gets locked of a pawn
	 * @return
	 */
	public boolean isLocked() {
		return isLocked;
	}
	
	/**
	 * <b>Transformer</b>Sets the lock of a pawn
	 * @param isLocked
	 */
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	/**
	 * <b>Accessor</b>Gets protected of a pawn
	 * @return
	 */
	public boolean isProtected() {
		return isProtected;
	}
	
	/**
	 * <b>Transformer</b>Sets the protect of a pawn
	 * @param isProtected
	 */
	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}
	
	
	
	
	
}