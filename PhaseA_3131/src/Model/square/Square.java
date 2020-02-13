package Model.square;

public class Square {


    private int number;
    private boolean hasPawn;
    private int squareValue;


    /**
     * <b>Accesor<b/> gets the number of the square
     * @return
     */
    public int getNumber() {
        return number;
    }


    /**
     * Observer checks if the square has pawn
     * @return true if there is a pawn , false otherwise
     */
    public boolean isHasPawn() {
        return hasPawn;
    }

    /**
     *<b>Accesor<b/>  gets the squre value
     * @return
     */
    public int getSquareValue() {
        return squareValue;
    }


    /**
     *  <b>Transformer</b> sets the number of the square;
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *  <b>Transformer</b> sets a square to has a pawn
     * @param hasPawn
     */
    public void setHasPawn(boolean hasPawn) {
        this.hasPawn = hasPawn;
    }

    /**
     * <b>Transformer</b>  sets the square value
     * @param squareValue
     */
    public void setSquareValue(int squareValue) {
        this.squareValue = squareValue;
    }


    /**
     * Constructor
     * @param number
     * @param hasPawn
     * @param squareValue
     */
    public Square(int number, boolean hasPawn, int squareValue){}


}
