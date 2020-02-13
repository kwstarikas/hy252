package Model.square;

public class StartSquare extends Square {

    private int activePawns;


    /**
     * <b>Acessoor</b> gets active pawns
     * @return
     */
    public int getActivePawns() {
        return activePawns;
    }


    /**
     *  <b>Transformer</b>  sets active pawns
     * @param activePawns
     */
    public void setActivePawns(int activePawns) {
        this.activePawns = activePawns;
    }


    /**
     * Constructor
     */
    public StartSquare();
}
