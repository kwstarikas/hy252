package mcv.model.card;

import mcv.model.pawn.Pawn;

public class NumberCard extends Card{

	
	private int value , numCardPlayed;
	
	
	public NumberCard(int value) {
		this.value = value;
	}
	
	
	@Override
	public String toString() {
		return "NumberCard";
	}

	@Override
	public void movePawn(Pawn pawn) {
		// TODO Auto-generated method stub
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getNumCardPlayed() {
		return numCardPlayed;
	}

	public void setNumCardPlayed(int numCardPlayed) {
		this.numCardPlayed = numCardPlayed;
	}


}