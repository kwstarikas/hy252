package mcv.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import mcv.model.card.Card;
import mcv.model.deck.Deck;
import mcv.model.pawn.Pawn;
import mcv.model.player.Player;
import mcv.model.square.SimpleSquare;
import mcv.model.square.Square;
import mcv.view.View;


/**
 * 
 * @author rikaz
 *
 */
public class Controller {

	Deck deck;
	Player p1,p2;
	
	private int turn;
	View view;
	
	
	/**
	 * <b>Transformer</b> sets a random turn 
	 * @return
	 */
	public int setThisTurn() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		return randomNum;
	}

	
	/**
	 * <b>Transformer</b> Initialize the players ,deck ,view ,sets listeners.
	 * @throws IOException
	 */
	public void initialize() throws IOException {
		
		p1 = new Player(0,Color.red,false,false,"Loukas",0,false);
		p2 = new Player(0,Color.yellow,false,false,"Manos",0,false);
		
		
		deck = new Deck();
		deck.initSquares();
		deck.initCard();
		
		turn = setThisTurn();
		
		view = new View();

		view.initComponents();
		view.setVisible(true);
		view.setCardsToPlay(deck.getCards());
		setListeners();
		view.updateInfobox("Game has started \nPlayer's Turn : " + getTurn() + "\n\nCards Left : " + deck.getCards().size());
		
		update();

	}
	
	
	
	
	/**
	 * <b>Observer</b> run all the arraylists of squares and checks whitch squares has pawns 
	 */
	public void update() {
		
		//To do set the upponents buttons to interactive
		view.setCardsToPlay(deck.getCards());
		System.out.println("UPDATE BEGINS ");
		
		for (int i =0 ; i<deck.getSimplesquare().size(); i++) {
			if (deck.getSimplesquare().get(i).isHasPawn() == true) {
				System.out.println("has pawn in block : " + deck.getSimplesquare().get(i).getNumber()
						+ " color : " + deck.getSimplesquare().get(i).getWhitchPawm().getColor());
			}
		}
		
		for (int i =1 ; i<deck.getHomesquare().size(); i++) {
			if (deck.getHomesquare().get(i).isHasPawn() == true) {
				System.out.println("has pawn in block : " + deck.getHomesquare().get(i).getNumber() 
						+ "color : " + deck.getHomesquare().get(i).getWhitchPawm().getColor());
			}
		}
		for (int i =1 ; i<deck.getSafetySquares().size(); i++) {
			if (deck.getSafetySquares().get(i).isHasPawn() == true) {
				System.out.println("has pawn in home squares block : " + deck.getSafetySquares().get(i).getNumber() 
						+ "color : " + deck.getSafetySquares().get(i).getWhitchPawm().getColor());
			}
		}
		
		for(int i=0; i<deck.getStartsquare().size(); i++) {
			if(deck.getStartsquare().get(i).isHasPawn() == true) {
				System.out.println("has pawn in start square block : " + deck.getStartsquare().get(i).getNumber());
			}
		}
		
		view.updateInfobox("Info box \nPlayer's Turn : " + getTurn() + "\n\nCards Left : " + deck.getCards().size());
		System.out.println("reach end" + turn + "/nnum of simple squares : " + deck.getSimplesquare().size());
	}
	
	
	/**
	 * <b>Transformer</b>Removes the first card from the closed cards and replace it
	*/
	public void removeAndReplaceCard() {
        if (deck.getCards().isEmpty()) {
        	deck.initCard();
            view.updateInfobox("All cards suffled again");
		} 
        else {
		    
		    deck.getCards().add(0, deck.getCards().remove(0));
		    Card c = deck.getCards().get(0);
		    deck.getCards().remove(0);

		    view.updateCard(c, 0);
		    if (deck.getCards().isEmpty()) {
		        deck.initCard();
		    	view.updateInfobox("All cards suffled again");
		    } 
		    else {
		        view.updateInfobox("Card Replaced: Available Cards:" + deck.getCards().size());
		    }
		}
	}
	
	
	/**
	 * <b>Transformer</b> Sets the listeners
	 */
	public void setListeners() {
        view.getPlayCard().addMouseListener(new CurrCardListener());
        view.getPickCard().addMouseListener(new CardListener());
        view.getFold().addMouseListener(new foldListener());
       
       	view.getPawn1().addMouseListener(new Pawn1Listener());
       	view.getPawn2().addMouseListener(new Pawn1Listener());
       	view.getPawn3().addMouseListener(new Pawn1Listener());
       	view.getPawn4().addMouseListener(new Pawn1Listener());
    }


	/**
	 * Implements the listeners for pawns
	 * 
	 *
	 */
	private class Pawn1Listener implements MouseListener {
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton but = ((JButton) e.getSource()); 
			System.out.println("PATITHIKE to pawn ");
			if(getTurn() == 1) setTurn(0);
			else setTurn(1);
			deck.movePawn(deck.pawn1, deck.getCards().get(0));
			
			
			update();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
	
	
	/**
	 * 
	 *Implements the listeners for Current card
	 *
	 */
	private class CurrCardListener implements MouseListener {
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton but = ((JButton) e.getSource()); 
			System.out.println("PATITHIKE h Cur card ");
			if(getTurn() == 1) setTurn(0);
			else setTurn(1);
			System.out.println("PAWN NA KOUNISW PAWN ME VALUE " + deck.getCards().get(0).getValue());
			deck.movePawn(deck.pawn1, deck.getCards().get(0));
			
			
			update();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	/**
	 * Implements the listeners for fold button
	 * 
	 *
	 */
	private class foldListener implements MouseListener {
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton but = ((JButton) e.getSource()); 
			System.out.println("PATITHIKE TO FOLD ");
			if(getTurn() == 1) setTurn(0);
			else setTurn(1);
			update();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * Implements the Listeners for the card thats about to play
	 * 
	 *
	 */
    private class CardListener implements MouseListener {
       
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton but = ((JButton) e.getSource()); 
            
            view.setCardsToPlay(deck.getCards());
            System.out.println("Patithike h kleisth karta");
            
            
            
            if (checkIfGameFinished() == true) {
            	System.out.println("TELEISE TO GAME");
                return;
            }
           
            if (SwingUtilities.isRightMouseButton(e) && but.getName().contentEquals("CurrentCard")) {
            	
                removeAndReplaceCard();
            }
            System.out.println("kai mpika se remove");
            removeAndReplaceCard();

            update();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
	
    
    /**
     * <b>Observer</b> Checks if cards are finished
     * @return
     */
	public boolean checkIfCardsFinished() {
		if(deck.getCards().isEmpty()) return true;
		return false;
	}
	

    /**
     * <b>Observer</b> Checks if game finished
     * @return
     */
    public boolean checkIfGameFinished() {
        if (p1.isHasFinished()) return true;
        else if (p2.isHasFinished()) return true;
        else return false;
    }
	
    
	/**
	 * <b>Accessor</b>Gets the turn
	 * @return
	 */
	public int getTurn() {
		return turn;
	}
	
	
	/**
	 * <b>Transformer</b>Sets the turn
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

}