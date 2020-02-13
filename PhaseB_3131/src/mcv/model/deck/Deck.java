package mcv.model.deck;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import mcv.model.card.Card;

import mcv.model.card.NumberCard;
import mcv.model.card.NumberElevenCard;
import mcv.model.card.NumberFourCard;
import mcv.model.card.NumberOneCard;
import mcv.model.card.NumberSevenCard;
import mcv.model.card.NumberTenCard;
import mcv.model.card.NumberTwoCard;
import mcv.model.card.SimpleNumberCard;
import mcv.model.card.SorryCard;
import mcv.model.pawn.Pawn;
import mcv.model.square.HomeSquare;
import mcv.model.square.SafetyZoneSquare;
import mcv.model.square.SimpleSquare;
import mcv.model.square.Square;
import mcv.model.square.StartSquare;

import mcv.model.player.*;


/**
 * 
 * @author rikaz
 *
 */
public class Deck {

	Card lastCardPlayed;
	ArrayList<SimpleSquare> simplesquare = new ArrayList<>();
	public Pawn pawn1,pawn2,pawn3,pawn4;

	private ArrayList<StartSquare> startsquare =  new ArrayList<>();
	private ArrayList<Square> homesquare = new ArrayList<>();
	private ArrayList<SafetyZoneSquare> safetysquares = new ArrayList<SafetyZoneSquare>();
	private ArrayList<Card> cards = new ArrayList<>();
	
	
	
	/**
	 * <b>Transformer</b>Initialize the squares , pawns.
	 */
	public void initSquares() {
		

		pawn1 = new Pawn(Color.red,-2,false,true,true);
		pawn2 = new Pawn(Color.red,-3,false,true,true);
		pawn1.setImage("src/resources/images/pawns/redPawn1.png");
		pawn2.setImage("src/resources/images/pawns/redPawn2.png");
		
		pawn3 = new Pawn(Color.yellow,0,false,true,true);
		pawn4 = new Pawn(Color.yellow,-1,false,true,true);
		pawn3.setImage("src/resources/images/pawns/yellowPawn1.png");
		pawn4.setImage("src/resources/images/pawns/yellowPawn2.png");
		
		for(int i=0; i<60; i++) {
			SimpleSquare s = new SimpleSquare(i,false);
			simplesquare.add(s);
		}
		
		
		
		//3h metavlith einai o player
		startsquare.add(new StartSquare( 0,true,pawn3));
		startsquare.add(new StartSquare(-1,true,pawn4));
		startsquare.add(new StartSquare(-2,true,pawn1));
		startsquare.add(new StartSquare(-3,true,pawn2));
		
		homesquare.add(new HomeSquare(-101,false,1));
		homesquare.add(new HomeSquare(-102,false,1));
		homesquare.add(new HomeSquare(-103,false,2));
		homesquare.add(new HomeSquare(-104,false,2));
		
		for(int i=0; i<10; i++) {
			if(i<5) safetysquares.add(new SafetyZoneSquare(i,false,Color.red));
			else safetysquares.add(new SafetyZoneSquare(i,false,Color.yellow));
		}
	}
	
	
	/**
	 * <b>Transformer</b> change the block of a pawn
	 * @param pawn
	 * @param oldSquare
	 * @param newSquare
	 * @param oldPos
	 * @param newPos
	 */
	public void changeBlock(Pawn pawn, Square oldSquare ,Square newSquare , int oldPos, int newPos) {
		System.out.println(" \n\n twra kanw thn alagh ");
		System.out.println(oldSquare.toString());
		oldSquare.setHasPawn(false);
		newSquare.setHasPawn(true);
		pawn.setBlock(newPos);
		newSquare.setWhitchPawm(pawn);
		oldSquare.setWhitchPawm(null);
	}
	
	
	/**
	 * return 0 if the block you are going has a pawn of yours
	 * return 1 if the block you are going has a pawn of the opponent
	 * return -1 if the block you are going has no pawn 
	 * @param pawn
	 * @param squarePos
	 * @return
	 */
	public int checkIfThreIsPawn(Pawn pawn , int squarePos) {
		
		if(getSimplesquare().get(squarePos).isHasPawn() == true) {
			Color color = pawn.getColor();
			if (getSimplesquare().get(squarePos).getWhitchPawm().getColor() == color) {
				System.out.println("the block tou want to move already has a pawn of yours");
				return 0;
			}
			else {
				System.out.println("the block tou want to move has a pawn of the opponent");
				return 1;
			}
		}
		return -1;
	}
	
	
	/**
	 * <b>Transformer</b>Moves a pawn by a card value 
	 * @param pawn
	 * @param card
	 * @return
	 */
	public boolean movePawn(Pawn pawn , Card card){
		
		
		if (card.getValue() == 2 || card.getValue() == 1 && pawn.getBlock() <= 0) {
			pawn.setLocked(false);
			//if(pawn.getColor() == Color.red) pawn.setBlock(4);
			//else if (pawn.getColor() == Color.yellow) pawn.setBlock(34);
		}
		int position = pawn.getBlock() ; 
		if(pawn.isLocked() == true) {
        	System.out.println("Pawn is locked ....\n you must draw card with number 1 or 2 \n");
        	
        	return false;
        }
		
       
        if(pawn.getColor() == Color.red) {
        	
        	if(position + card.getValue() > 62) {

        		if(position + card.getValue() > 68) {
        			System.out.println("Pawn out of bounds");
        			return false ;
        		}
        		else {
        			
        			int difference = card.getValue() - (62 - simplesquare.get(position).getNumber()) ;
        			int homePos = difference;
        			safetysquares.get(homePos).setHasPawn(true);
        			simplesquare.get(position).setHasPawn(false);
        			pawn.setBlock(safetysquares.get(homePos).getNumber());
        			System.out.println("Pawn moved succesfully");
        		}
        	}
        	else if (position <= 0 && pawn.isLocked() == false) {
        		if (startsquare.get(2).isHasPawn() == true) {
        			startsquare.get(2).getWhitchPawm().setBlock(2);
            		changeBlock(startsquare.get(2).getWhitchPawm(), startsquare.get(2),simplesquare.get(2 + card.getValue())
            				,3, 2 + card.getValue());
        		}
        		else if (startsquare.get(3).isHasPawn() == true) {
        			startsquare.get(3).getWhitchPawm().setBlock(2);
            		changeBlock(startsquare.get(3).getWhitchPawm(), startsquare.get(3),simplesquare.get(2 + card.getValue())
            				,3, 2 + card.getValue());
        		}
        		else {
        			System.out.println("No more pawns at start square");
        			return false ;
        		}
        		return true;
        	
        	}
        	else {

        		int finalPos;
        		int check = checkIfThreIsPawn(pawn, position+card.getValue());
        		
        		System.out.println("TO BLOCK EINAI " + pawn.getBlock() + "/n card value : " +card.getValue());

        		if (position + card.getValue() > 59)  finalPos = card.getValue() - (59 - simplesquare.get(position).getNumber()) ;
        		else finalPos = position + card.getValue();
        		System.out.println("final pos = " +finalPos);
        		if (check == -1 ) {
        			changeBlock(pawn, simplesquare.get(position), simplesquare.get(finalPos), position, finalPos);
            		System.out.println("Pawn moved succesfully");

        		}
        		else if (check == 0){
        			System.out.println("You already have a pawn there"); 
        		}
        		else if (check == 1 ) {
        			simplesquare.get(position + card.getValue()).getWhitchPawm().setBlock(0);
        			changeBlock(pawn, simplesquare.get(position), simplesquare.get(finalPos), position, finalPos);
            		System.out.println("Pawn moved succesfully");
        		}
        	}
        }
        else if (pawn.getColor() == Color.yellow) {
        	if(position < 33) {
        		if(position + card.getValue() > 32) {
        			if(position + card.getValue() > 38 ) {
        				System.out.println("Pawn out of bounds");
        				return false ; 
        			}
        			else {
        				int dif = card.getValue() -(32 - simplesquare.get(position).getNumber());
        				int homepos = dif ; 
        				safetysquares.get(homepos+4).setHasPawn(true);
        				simplesquare.get(position).setHasPawn(false);
        				pawn.setBlock(safetysquares.get(homepos+4).getNumber());
        				System.out.println("Pawn moved succesfully");
        			}
        		}
        		else if (position <= 0 && pawn.isLocked() == false) {
            		if (startsquare.get(0).isHasPawn() == true) {
            			startsquare.get(0).getWhitchPawm().setBlock(32);
                		changeBlock(startsquare.get(0).getWhitchPawm(), startsquare.get(0),simplesquare.get(33 + card.getValue())
                				,32, 3 + card.getValue());
            		}
            		else if (startsquare.get(1).isHasPawn() == true) {
            			startsquare.get(1).getWhitchPawm().setBlock(32);
                		changeBlock(startsquare.get(1).getWhitchPawm(), startsquare.get(1),simplesquare.get(32 + card.getValue())
                				,32, 32 + card.getValue());
            		}
            		else {
            			System.out.println("No more pawns at start square");
            			return false ;
            		}
            		return true;
        		}
        		else {
        			int check = checkIfThreIsPawn(pawn, position + card.getValue());
        			if (check == -1 ) {
        				changeBlock(pawn, simplesquare.get(position), simplesquare.get(position
        						+ card.getValue()), position, position + card.getValue());
                		System.out.println("Pawn moved succesfully");

        			}
        			else if (check == 0) {
            			System.out.println("You already have a pawn there"); 
            			return false;
        			}
        			else if (check == 1) {
        				simplesquare.get(position + card.getValue()).getWhitchPawm().setBlock(-2); 
        				changeBlock(pawn, simplesquare.get(position), simplesquare.get(position
        						+ card.getValue()), position, position + card.getValue());
        			}
        		}
        	}
        	else {
        		int finalPos;
        		int check = checkIfThreIsPawn(pawn, position+card.getValue());
        		if (position + card.getValue() > 59)  {
        			finalPos = card.getValue() - (59 - simplesquare.get(position).getNumber()) ;
        		}
        		else {
        			finalPos = position + card.getValue();
        		}
        		
        		if (check == -1 ) {
        			changeBlock(pawn, simplesquare.get(position), simplesquare.get(finalPos), position, finalPos);
            		System.out.println("Pawn moved succesfully");

        		}
        		else if (check == 0){
        			System.out.println("You already have a pawn there"); 
        			return false;
        		}
        		else if (check == 1 ) {
        			simplesquare.get(position + card.getValue()).getWhitchPawm().setBlock(0);
        			changeBlock(pawn, simplesquare.get(position), simplesquare.get(finalPos), position, finalPos);
            		System.out.println("Pawn moved succesfully");
        		}
        	}
        }
        return true;
    }
	
	
	
	/**
	 * <b>Transformer</b>Initialize the cards 
	 */
	public void initCard() {
		for(int i=1; i<14; i++ ) {
			
			if (i==6 || i==9)continue;
			
			else if(i==1){
				for(int j=0; j<4; j++) {
					Card c1 = new NumberOneCard();
					c1.setImage("src/resoursces/images/cards/card1.png");
					cards.add(c1);
				}
			}
			else if(i==2) {
				for(int j=0; j<4; j++) {
					Card c1 = new NumberTwoCard();
					c1.setImage("src/resoursces/images/cards/card2.png");
					cards.add(c1);
				}
			}
			else if (i==3) {
				for(int j=0; j<4; j++) {
					Card c1 = new SimpleNumberCard(3);
					c1.setImage("src/resoursces/images/cards/card3.png");
					cards.add(c1);
				}
			}
			else if (i==4) {
				for(int j=0; j<4; j++) {
					Card c1 = new NumberFourCard();
					c1.setImage("src/resoursces/images/cards/card4.png");
					cards.add(c1);
				}
			}
			else if (i==5) {
				for(int j=0; j<4; j++) {
					Card c1 = new SimpleNumberCard(5);
					c1.setImage("src/resoursces/images/cards/card5.png");
					cards.add(c1);
				}
			}
			else if (i==7) {
				for(int j=0; j<4; j++) {
					Card c1 = new NumberSevenCard();
					c1.setImage("src/resoursces/images/cards/card7.png");
					cards.add(c1);
				}
			}
			else if (i==8) {
				for(int j=0; j<4; j++) {
					Card c1 = new SimpleNumberCard(8);
					c1.setImage("src/resoursces/images/cards/card8.png");
					cards.add(c1);
				}
			}
			else if (i==10) {
				for(int j=0; j<4; j++) {
					Card c1 = new NumberTenCard();
					c1.setImage("src/resoursces/images/cards/card10.png");
					cards.add(c1);
				}
			}
			else if (i==11) {
				for(int j=0; j<4; j++) {
					Card c1 = new NumberElevenCard(11);
					c1.setImage("src/src/resoursces/images/cards/card11.png");
					cards.add(c1);
				}
			}
			else if (i==12) {
				for(int j=0; j<4; j++) {
					Card c1 = new SimpleNumberCard(12);
					c1.setImage("src/resoursces/images/cards/card11.png");
					cards.add(c1);
				}
			}
			else {
				for(int j=0; j<4; j++) {
					Card c1 = new SorryCard();
					c1.setImage("src/resoursces/images/cards/cardSorry.png");
					cards.add(c1);
				}
			}
		}
		
	
		Collections.shuffle(cards);
		
		for(int i =0; i<cards.size(); i++ ) {
			System.out.println("karta no:" + cards.get(i).getValue());
		}
	}
	
	
	
	/**
	 * <b>Accessor</b>Gets the card arraylist
	 * @return
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}

	/**
	 * <b>Transformer</b>Sets the card arraylist
	 * @param cards
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	
	/**
	 * <b>Accessor</b>Gets the card that played
	 * @return
	 */
	public Card getLastCardPlayed() {
        return lastCardPlayed;
    }
	
	/**
	 * <b>Accessor</b>Gets the simple square array list
	 * @return
	 */
	public ArrayList<SimpleSquare> getSimplesquare() {
		return simplesquare;
	}


	/**
	 * <b>Transformer</b>Sets the simple square array list
	 * @param simplesquare
	 */
	public void setSimplesquare(ArrayList<SimpleSquare> simplesquare) {
		this.simplesquare = simplesquare;
	}


	/**
	 * <b>Accessor</b>Gets the start square array list
	 * @return
	 */
	public ArrayList<StartSquare> getStartsquare() {
		return startsquare;
	}


	/**
	 * <b>Transformer</b>Sets the start square array list
	 * @param startsquare
	 */
	public void setStartsquare(ArrayList<StartSquare> startsquare) {
		this.startsquare = startsquare;
	}


	/**
	 * <b>Accessor</b>Gets the home square array list
	 * @return
	 */
	public ArrayList<Square> getHomesquare() {
		return homesquare;
	}


	/**
	 * <b>Transformer</b>Sets the home square array list
	 * @param homesquare
	 */
	public void setHomesquare(ArrayList<Square> homesquare) {
		this.homesquare = homesquare;
	}

	/**
	 * <b>Transformer</b>Sets the last card played
	 * @param lastCardPlayed
	 */
	public void setLastCardPlayed(Card lastCardPlayed) {
		this.lastCardPlayed = lastCardPlayed;
	}


	/**
	 * <b>Accessor</b>Gets the safety square array list
	 * @return
	 */
	public ArrayList<SafetyZoneSquare> getSafetySquares() {
		return safetysquares;
	}

	/**
	 * <b>Transformer</b>Sets the safety square array list
	 * @param safetySquares
	 */
	public void setSafetySquares(ArrayList<SafetyZoneSquare> safetySquares) {
		this.safetysquares = safetySquares;
	}

}