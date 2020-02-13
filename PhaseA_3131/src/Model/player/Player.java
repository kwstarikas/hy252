package Model.player;

import java.awt.*;

public class Player {

    private  String name;
    private Color color;
    private int choise ;
    private  boolean turn;


    /**
     * <b>Accesor<b/> gets the name of the player
     * @return
     */
    public String getName() {
        return name;
    }


    /**
     * <b>Accesor<b/> gets the turn
     * @return
     */
    public boolean isTurn() {
        return turn;
    }


    /**
     *<b>Accesor<b/>  gets the color of a player
     * @return
     */
    public Color getColor() {
        return color;
    }


    /**
     * <b>Accesor<b/> gets the choise of a player
     * @return
     */
    public int getChoise() {
        return choise;
    }


    /**
     * <b>Transformer</b>  sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     *  <b>Transformer</b> sets the turn
     * @param turn
     */
    public void setTurn(boolean turn) {
        this.turn = turn;
    }


    /**
     * <b>Transformer</b>  sets the color
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }


    /**
     * <b>Transformer</b>  sets the choise
     * @param choise
     */
    public void setChoise(int choise) {
        this.choise = choise;
    }


    /**
     * Constructor
     * @param name
     * @param color
     * @param turn
     * @param choise
     */
    public Player(String name , Color color, boolean turn, int choise) {}



}
