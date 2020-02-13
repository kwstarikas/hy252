package mcv.model.card;

import mcv.model.pawn.Pawn;

public abstract class Card {
	
	private boolean isActive;
	private int value;
	private String image;
	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public abstract String toString();

	public void movePawn(Pawn pawn) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}