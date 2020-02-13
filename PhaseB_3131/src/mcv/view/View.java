package mcv.view;

//import  mcv.controller.Controller;
//import mvc.view.JLayeredPaneExtension;
import mcv.model.card.Card;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.text.StyledEditorKit.BoldAction;


/**
 * 
 * 
 * @author rikaz
 *
 */
public class View extends JFrame implements ActionListener{

	
	
	private JLayeredPaneExtension basic_panel;
	private ClassLoader cldr;
    JTextArea infobox;
    private JButton fold;
    private JLabel[] simpleSquares = new JLabel[60];
    private JLabel[] safetyzoneSquares = new JLabel[10];
    private JLabel[] homeSquares = new JLabel[4];
    private JButton pickCard,playCard;
    private JTextArea recCard,curCard;
    private JLabel redStart;
    private JLabel sorry;
    private JButton pawn1, pawn2,pawn3,pawn4;
    private ArrayList<Card> cardsToPlay = new ArrayList<>();
    
    
    /**
	 * <b>Accessor</b> Gets the Fold button
	 * @param c
	 */
    public JButton getFold() {
		return fold;
	}

    /**
	 * <b>Transformer</b>Sets the fold button
	 * @param c
	 */
	public void setFold(JButton fold) {
		this.fold = fold;
	}

	 
    /**
	 * <b>Accessor</b> Gets the array of the cardsToPlay
	 * @param c
	 */
    public ArrayList<Card> getCardsToPlay() {
		return cardsToPlay;
	}

    /**
	 * <b>Transformer</b> Sets the array of cardsToPlay
	 * @param c
	 */
	public void setCardsToPlay(ArrayList<Card> cardsToPlay) {
		this.cardsToPlay = cardsToPlay;
	}


	/**
     * <b>Transformer</b>Updates the card of the curr card play
     * @param c
     * @param position
     */
	public void updateCard(Card c, int position) {
		String fullPath=c.getImage(); 
		Image image = new ImageIcon(fullPath).getImage();
       
        image = image.getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH);
        playCard.setIcon(new ImageIcon(image));
        basic_panel.repaint();
    }
    
	
	/**
	 * Constructor of Class View
	 */
	public View()  {
		cldr = this.getClass().getClassLoader();
		this.setResizable(false);
		this.setTitle("SORRY!");
		this.setBounds(15, 0, 1000, 700);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * <b>Transformer</b>Sets the last card
	 * @param c
	 */
	public void setLastCard(Card c) {
		String fullPath=c.getImage(); 
		Image image = new ImageIcon(fullPath).getImage();
       
        image = image.getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH);
	    playCard.setIcon(new ImageIcon(image));
	 }
	 
	
	/**
	 * <b>Transformer</b>Initialize all the components that exist in panel
	 * @throws IOException
	 */
	public void initComponents() throws IOException {
		
		String fullPath="src/resources/images/background.png"; 
		Image image = new ImageIcon(fullPath).getImage();
        basic_panel = new JLayeredPaneExtension(image);
		basic_panel.setOpaque(true);
		basic_panel.setVisible(true);
		this.add(basic_panel);
		
		//create info box
		infobox = new JTextArea(); 
		infobox.setBounds(700,450,250,150);
		infobox.setBackground(Color.WHITE);
		infobox.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        infobox.setOpaque(true);
        infobox.setEditable(false);
        basic_panel.add(infobox,0);
        
        //create fold button
        
        fold = new JButton("Fold");
        fold.setBounds(700, 370, 250, 60);
        fold.setBackground(Color.red);
        basic_panel.add(fold);
        fold.setVisible(true);
        
        sorry = new JLabel(); 
        fullPath="src/resources/images/sorryImage.png"; 
        image = new ImageIcon(fullPath).getImage();
        image = image.getScaledInstance(200, 90, java.awt.Image.SCALE_SMOOTH);

        sorry.setIcon(new ImageIcon(image));
        sorry.setVisible(true);
        sorry.setBounds(230, 300, 200, 80);
        basic_panel.add(sorry);
        
        
        
        
        int i=0;
    	
		while (i<60){
			
			
			simpleSquares[i] = new JLabel();
			simpleSquares[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			simpleSquares[i].setName(Integer.toString(i));
			
			if(i == 1 || i == 8) {
				fullPath = "src/resources/images/slides/redSlideStart.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if ((i > 1 && i < 4) || (i > 8  && i < 13)) {
				fullPath = "src/resources/images/slides/redSlideMedium.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if (i == 4 || i == 13) {
				fullPath = "src/resources/images/slides/redSlideEnd.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if (i == 16 || i == 24) {
				fullPath = "src/resources/images/slides/blueSlideStart.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if ((i > 16 && i < 19) || (i > 24 && i < 28)) {
				fullPath = "src/resources/images/slides/blueSlideMedium.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if (i == 19 || i == 28) {
				fullPath = "src/resources/images/slides/blueSlideEnd.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if (i == 31 || i == 39) {
				fullPath = "src/resources/images/slides/yellowSlideStart.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if (i == 32 || i == 33 || i == 40 || i == 41 || i == 42 ) {
				fullPath = "src/resources/images/slides/yellowSlideMedium.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if (i == 34 || i == 43) {
				fullPath = "src/resources/images/slides/yellowSlideEnd.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if (i == 46 || i == 54) {
				fullPath = "src/resources/images/slides/greenSlideStart.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if ((i > 46 && i < 49) || (i > 54 && i < 58)) {
				fullPath = "src/resources/images/slides/greenSlideMedium.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else if (i == 49 || i == 58) {
				fullPath = "src/resources/images/slides/greenSlideEnd.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

				simpleSquares[i].setIcon(new ImageIcon(image));
			}
			else {
				fullPath = "src/resources/images/simpleSquare.png";
		        image = new ImageIcon(fullPath).getImage();
	            image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

		        simpleSquares[i].setIcon(new ImageIcon(image));
			}
			
			if(i < 16) {
				simpleSquares[i].setBounds(i*40, 0, 40, 50);
				basic_panel.add(simpleSquares[i]);
			}
			else if (i < 31 && i > 15) {
				simpleSquares[i].setBounds(16*40-40, (i-15)*40, 40, 50);
				basic_panel.add(simpleSquares[i],1);
			}
			else if (i < 46 && i > 30) {
				simpleSquares[i].setBounds(600 - (i-30)*40, 600, 40, 50);
				basic_panel.add(simpleSquares[i]);
			}
			else if (i < 60 && i > 45) {
				simpleSquares[i].setBounds(0, 600 - (i-45)*40, 40, 50);

				basic_panel.add(simpleSquares[i]);
			}
			
			if (i == 2) {
				for(int j=0; j<5; j++ ) {
					safetyzoneSquares[j] = new JLabel();
					safetyzoneSquares[j].setBackground(Color.red);
					safetyzoneSquares[j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

					safetyzoneSquares[j].setOpaque(true);
					safetyzoneSquares[j].setBounds(i*40,40 + j*40,40, 40);
					basic_panel.add(safetyzoneSquares[j]);
				}
				homeSquares[0] = new JLabel("home1");
				homeSquares[0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

				homeSquares[0].setOpaque(true);
				homeSquares[0].setBounds(i*40-20,50 + 5*40, 60, 50);
				basic_panel.add(homeSquares[0]);
				
				homeSquares[1] = new JLabel("home2");
				homeSquares[1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

				homeSquares[1].setOpaque(true);
				homeSquares[1].setBounds(i*40+40,50 + 5*40,60, 50);
				basic_panel.add(homeSquares[1]);
				
				
			}
			else if (i == 32) {
				for(int j=5; j<10; j++ ) {
					safetyzoneSquares[j] = new JLabel();
					safetyzoneSquares[j].setBackground(Color.yellow);
					safetyzoneSquares[j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

					safetyzoneSquares[j].setOpaque(true);
					safetyzoneSquares[j].setBounds(520,190+ 40*j, 40, 40);

					basic_panel.add(safetyzoneSquares[j]);
				}
				homeSquares[2] = new JLabel("home1");
				homeSquares[2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

				homeSquares[2].setOpaque(true);
				homeSquares[2].setBounds(500 - 20, -60 + 10*40, 60, 50);
				basic_panel.add(homeSquares[2]);
				
				homeSquares[3] = new JLabel("home2");
				homeSquares[3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

				homeSquares[3].setOpaque(true);
				homeSquares[3].setBounds(540,10*40-60, 60, 50);
				basic_panel.add(homeSquares[3]);
			}
			
			i++;
		}
		
		redStart = new JLabel();
		redStart.setBounds(130, 50, 100, 80);
		redStart.setBackground(Color.white);
		redStart.setOpaque(true);
		redStart.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		redStart.setVisible(true);
		basic_panel.add(redStart);
		
		pickCard = new JButton();
		
		fullPath = "src/resources/images/cards/backCard.png";
        image = new ImageIcon(fullPath).getImage();
        image = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);

		pickCard = new JButton("pick card");
		pickCard.setIcon(new ImageIcon(image));
		pickCard.addActionListener(this);
		
		pickCard.setBounds(750,250,80,100);
		pickCard.setVisible(true);
		basic_panel.add(pickCard);
		

		playCard = new JButton();
		playCard.setName("CurrentCard");
		playCard.setBounds(850,250,80,100);
		playCard.setOpaque(true);
		playCard.setVisible(true);
		basic_panel.add(playCard);
		
		
		
		recCard = new JTextArea();
		recCard.setText("Receive Card");
		recCard.setVisible(true);
		recCard.setOpaque(false);
		recCard.setBounds(750, 350, 80, 20);
		basic_panel.add(recCard);
		

		curCard = new JTextArea();
		curCard.setText("Current Card");
		curCard.setVisible(true);
		curCard.setOpaque(false);
		curCard.setBounds(850, 350, 80, 20);
		basic_panel.add(curCard);
		
		
		
		fullPath = "src/resources/images/pawns/redPawn1.png";
        image = new ImageIcon(fullPath).getImage();
        image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

		pawn1 = new JButton();
		pawn1.setIcon(new ImageIcon(image));

		pawn1.setVisible(true);
		pawn1.setBounds(150, 80, 40, 40);
		basic_panel.add(pawn1);
		
		fullPath = "src/resources/images/pawns/redPawn2.png";
        image = new ImageIcon(fullPath).getImage();
        image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

		pawn2 = new JButton();
		pawn2.setIcon(new ImageIcon(image));

		pawn2.setVisible(true);
		pawn2.setBounds(190, 80, 40, 40);
		basic_panel.add(pawn2);
		basic_panel.repaint();
		
		
		fullPath = "src/resources/images/pawns/yellowPawn1.png";
        image = new ImageIcon(fullPath).getImage();
        image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

		pawn3 = new JButton();
		pawn3.setIcon(new ImageIcon(image));
		pawn3.setVisible(true);
		pawn3.setBounds(400, 550, 40, 40);
		basic_panel.add(pawn3);
		
		fullPath = "src/resources/images/pawns/yellowPawn2.png";
        image = new ImageIcon(fullPath).getImage();
        image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

		pawn4 = new JButton();
		pawn4.setIcon(new ImageIcon(image));

		pawn4.setVisible(true);
		pawn4.setBounds(440, 550, 40, 40);
		basic_panel.add(pawn4);
		basic_panel.repaint();
		
		
		
		
		
	}
	
	
	public void setDisable(Color color) {
		
		//make pawns disabled
		if (color == Color.red) {
			
		}
	}
	
	
	/**
	 * <b>Accessor</b>Gets the card that picked
	 * @return
	 */
    public JButton getPickCard() {
		return pickCard;
	}

    
    /**
     * <b>Transformer</b>Sets the card that is about to be played
     * @param pickCard
     */
	public void setPickCard(JButton pickCard) {
		this.pickCard = pickCard;
	}

	/**
	 * <b>Accessor</b>
	 * @return
	 */
	public JButton getPlayCard() {
		return playCard;
	}

	public void setPlayCard(JButton playCard) {
		this.playCard = playCard;
	}

	
	/**
	 * <b>Transformer</b>Updates the info box
	 * @param message
	 */
	public void updateInfobox(String message) {
        infobox.setText(message);
        basic_panel.repaint();
    }
    
    
	/**
	 * <b>Transformer</b>Simple method to show a message
	 * @param message
	 */
    public void showWinningMessage(String message) {
        JOptionPane.showMessageDialog(this, message);

    }
    
    
    /**
     * <b>Accessor</b>
     * @return
     */
    public JButton getPawn1() {
		return pawn1;
	}

    
    /**
     * <b>Transformer</b>Sets pawn3 button
     * @param pawn1
     */
	public void setPawn1(JButton pawn1) {
		this.pawn1 = pawn1;
	}

	
	/**
	 * <b>Accessor</b>Gets pawn2 button
	 * @return
	 */
	public JButton getPawn2() {
		return pawn2;
	}
	
	
	/**
	 * <b>Transformer</b>Sets pawn3 button
	 * @param pawn2
	 */
	public void setPawn2(JButton pawn2) {
		this.pawn2 = pawn2;
	}
	
	
	/**
	 * <b>Accessor</b>Gets pawn2 button
	 * @return
	 */
	public JButton getPawn3() {
		return pawn3;
	}

	
	/**
	 * <b>Transformer</b>Sets pawn3 button
	 * @param pawn3
	 */
	public void setPawn3(JButton pawn3) {
		this.pawn3 = pawn3;
	}
	
	
	/**
	 * <b>Accessor</b>Gets pawn2 button
	 * @return
	 */
	public JButton getPawn4() {
		return pawn4;
	}
	
	
	/**
	 * <b>Transformer</b>Sets pawn4 button
	 * @param pawn4
	 */
	public void setPawn4(JButton pawn4) {
		this.pawn4 = pawn4;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("ACTION");
		String fullPath = getCardsToPlay().get(0).getImage();
		System.out.println(fullPath);
		Image image = new ImageIcon(fullPath).getImage();
        image = image.getScaledInstance(100, 120, java.awt.Image.SCALE_SMOOTH);
        this.playCard.setIcon(new ImageIcon(image));
        
	}


}

