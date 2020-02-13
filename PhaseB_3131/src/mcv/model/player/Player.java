package mcv.model.player;

import java.awt.Color;
import java.util.ArrayList;
import mcv.model.pawn.Pawn;



public class Player {

	

    private int position=-1;
    private boolean hasStarted = false, hasFinished = false;
    private String name;
    private Color color;
    private int choice;
    private boolean turn;
    
    
    
    /**
     * Constructor of a player
     * @param position
     * @param color
     * @param hasStarted
     * @param hasFinished
     * @param name
     * @param choise
     * @param turn
     */
    public Player(int position, Color color, boolean hasStarted, boolean hasFinished, String name, int choise, boolean turn){
    	this.position = position;
    	this.color = color;
    	this.hasStarted = hasStarted;
    	this.hasFinished = hasFinished;
    	this.name = name;
    	this.choice = choice;
    	this.turn = turn;
    }

    
	
    /**
     * <b>Accessor</b>Gets the name
     * @return
     */
    public String getName() {
		return name;
	}

    /**
     * <b>Transformer</b>Sets the name
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <b>Accessor</b>Gets the choise of a player
	 * @return
	 */
	public int getChoice() {
		return choice;
	}

	/**
	 * <b>Transformer</b>Sets the choise of a player
	 * @param choice
	 */
	public void setChoice(int choice) {
		this.choice = choice;
	}

	/**
	 * <b>Transformer</b>Gets the turn
	 * @return
	 */
	public boolean isTurn() {
		return turn;
	}
	
	/**
	 * <b>Transformer</b>Sets the turn
	 * @param turn
	 */
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	/**
	 * <b>Accessor</b>Gets position
	 * @return
	 */
	public int getPosition() {
        return position;
    }

	/**
	 * <b>Accessor</b>Gets started 
	 * @return
	 */
    public boolean isHasStarted() {
        return hasStarted;
    }

    /**
     * <b>Transformer</b>Sets the start
     * @param hasStarted
     */
    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    /**
     * <b>Accessor Observer</b>Gets if a player has finished
     * @return
     */
    public boolean isHasFinished() {
        return hasFinished;
    }

    /**
     * <b>Transformer</b>Sets if a player has finished or not
     * @param hasFinished
     */
    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

	

    
	
	
	
}