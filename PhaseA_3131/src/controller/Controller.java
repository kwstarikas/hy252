package controller;

import Model.deck.Deck;
import Model.player.Player;
import Model.pawn.Pawn;



public class Controller {


    private int fold ;
    private boolean notStarted;
    private Player p1, p2;
    private Deck deck;
    private Pawn pawn1, pawn2, pawn3, pawn4;

    /**
     * <b>Observer<b/> checks whitch player has to play
     *
     * @return
     */
    public int seeTrun() {
        return 0;
    }


    /**
     * <b>Transformer</b> sets the turn to a player
     *
     * @return
     */
    public int setTurn() {
        return 0;
    }


    /**
     * <b>Transformer</b> initialize the Deck deck
     *
     * @param deck
     * @return
     */
    public Deck initDeck(Deck deck) {
        return null;
    }


    /**
     * <b>Observer<b/> checks if a move is valid
     *
     * @param pawn
     * @return
     */
    public boolean checkMove(Pawn pawn) {
        return false;
    }


    /**
     * <b>Accesor<b/>  returns true if game is not stared
     *
     * @return
     */
    public boolean not_started() {
        return false;
    }


    /**
     * <b>Observer<b/> checks if the game is over
     *
     * @return
     */
    public boolean checkIfGameIsOver() {
        return false;
    }


    /**
     * <b>Transformer</b> initialize the table
     */
    public void init_table() {

    }

}
