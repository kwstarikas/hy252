package mcv.model.square;

public class HomeSquare extends Square{
	
	private int value,player;
	private boolean hasPawn;
	private int howManyPawns;
	
	
	/**
	 * Constructor of a HomeSquare
	 * @param value
	 * @param hasPawn
	 * @param howManyPawns
	 */
	public HomeSquare(int value, boolean hasPawn,int howManyPawns) {
		super(value,hasPawn,null);
		this.howManyPawns = howManyPawns;
	}

	
	/**
	 * <b>Accessor</b>Gets how many pawns the square has
	 * @return
	 */
	public int getHowManyPawns() {
		return howManyPawns;
	}

	/**
	 * <b>Transformer</b>sets how many pawns a square has 
	 * @param howManyPawns
	 */
	public void setHowManyPawns(int howManyPawns) {
		this.howManyPawns = howManyPawns;
	}

	/**
	 * <b>Observer</b>To string method to print the name of the square
	 */
	public String toString() {
		return "Home" + super.toString();
	}
}