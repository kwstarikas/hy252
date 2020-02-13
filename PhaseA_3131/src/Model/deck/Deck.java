package Model.deck;

import Model.card.Card;
import Model.pawn.Pawn;

public class Deck {

    /**
     *<b>Transformer</b> initialize the cards
     * @return
     */
    public Card initCards();


    /**
     *<b>Transformer</b>  initialize the deck
     * @return
     */
    public Deck initDeck();


    /**
     * <b>Transformer</b> initialize the pawns
     * @return
     */
    public Pawn initPawns(Pawn pawn);


    /**
     *<b>Observer<b/> checks if the cards are empty
     * @param cards
     * @return
     */
    public boolean isCardsEmpty(Card[] cards);


    /**
     *<b>Transformer</b> suffles the cards
     * @param cards
     * @return
     */
    public Card suffleCards(Card[] cards);


    /**
     *<b>Transformer</b> moves a pawn
     * @param pawn
     */
    public void movePawn(Pawn pawn);


    /**
     *<b>Observer<b/> checks if a player can fold
     * @param player
     * @return
     */
    public boolean canFold(Player player);


    /**
     *<b>Accesor<b/> gives a card to  a player
     * @return
     */
    public Card getCard();
}
