package csd.uoc.gr.A11;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.io.*;
import java.util.Scanner;
import java.awt.Frame;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;









public class DrawH {
	
	
	
	
	static void drawHgraphics (int L ) {
		Frame f = new Frame("zwgrafizontas to H") {
			public void paint (Graphics q) {
				Graphics2D g2 = (Graphics2D) q;
				g2.draw(new Line2D.Double(50,  500, 100, 100)); 
				QuadCurve2D a = new QuadCurve2D.Float();
				a.setCurve(500, 600, 100, 200, 200, 100);
				g2.draw(a);
				g2.draw(new Line2D.Double(300, 200 , 0, 200)); 
			}
		
		
		};
		f.setSize(400,400);
		f.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	public static void main (String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter the char  \n");
		char M = (char) System.in.read();
		
		System.out.println("enter the int  \n");
		int L = scan.nextInt();
		
		if (M != 'f' && M != 'c' && M != 'w' && M != 'g' ) {
			System.out.println("wrong char program exit ");
			System.exit(0);
		}
		
		if (L< 3 || L >20) {
			System.out.println("wrong int program exit ");
			System.exit(0);
		}
		if (M == 'c') {
			for (int i=0; i<L; i++) {
				if (i <L/2 || i>L/2) {
					System.out.println("*    *");
				}
				else if (i == L/2) {
					System.out.println("******");
				}
			}
		}
		else if (M == 'w') {
			String data = new String();
			for (int i=0; i<L; i++) {
				if (i <L/2 || i>L/2) {
					data += "*    *\n";
				}
				else if (i == L/2) {
					data += "******\n";
				}
			}
			UIManager.put("OptionPane.messageFont", new Font("Lucida Console", Font.BOLD, 14));
			JOptionPane.showMessageDialog(null, data, "Παράθυρο Εξόδου", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (M == 'f' ) {
			PrintWriter writer;
			try {
			writer = new PrintWriter("A.html", "UTF-8");
			writer.println("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"/>" + 
					"</head>" + 
					"<body><font size=" +L+">Α with font size = " + L + "</font></body>" +
					"</html>");
			
			writer.close();
			} catch (Exception e) {
			System.out.println("Πρόβλημα: "+e);
			}
		}
		else if (M == 'g') {
			drawHgraphics ( L );
			
		}
		
				
		while (true) {
			int intinputk = Integer.parseInt(JOptionPane.showInputDialog("Give me a number "));
			if (intinputk <  3 || intinputk > 20) {
				System.out.println("wrong int program exit ");
				System.exit(0);
			}
			String data1 = new String();
			for (int i=0; i<intinputk; i++) {
				if (i < intinputk/2 || i > intinputk/2) {
					data1 += "*    *\n";
				}
				else if (i == intinputk/2) {
					data1 += "******\n";
				}
			}
			UIManager.put("OptionPane.messageFont", new Font("Lucida Console", Font.BOLD, 14));
			JOptionPane.showMessageDialog(null, data1, "Παράθυρο Εξόδου", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
	}

	
		

}
