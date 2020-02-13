package csd.uoc.gr.A12;
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





	
	
	
	
	
	
	
	
class MagicSquareCheker{
	
	
	public static boolean checkIsMagic 	(int[][] s) {
		boolean is =  true;
			
		int sumr = 0, sumc = 0,  cols = s.length;
		
		sumr = sumOfRow(s, 0);
		
		for (int i=1; i<s.length; i++) {
			if (sumr != sumOfRow(s, i)) {
				printSquare(s);
				System.out.println("The sum of rows is not equal\nThe square isn't"
						+ "magic");
				System.exit(0);
			}
		}
		
		for (int i=1; i<s.length; i++) {
			if(sumr != sumOfColumn(s, i)) {
				printSquare(s);
				System.out.println("The sum of cols is not equal\nThe square isn't"
						+ "magic");
				System.exit(0);
			}
		}
		int diag1 = sumOfDiagonal1(s);
		if (diag1 != sumr) {
			printSquare(s);
			System.out.println("The sum of diag1 is not equal\nThe square isn't"
					+ "magic");
			System.exit(0);
		}
			
			
		int diag2 = sumOfDiagonal1(s);
		if (diag2 != sumr) {
			printSquare(s);
			System.out.println("The sum of diag2 is not equal\nThe square isn't"
					+ "magic");
			System.exit(0);
		}
		printSquare(s);
		System.out.println("The square is magic and the magic element is:"
				+ sumr);
		return is ;
	}
	
	private static int sumOfRow	(int[][] n, int k) {
		int sum = 0;
		for (int i=0; i<n.length; i++) {
			sum += n[k][i];
		}
		return sum;
	}
	
	private static int  sumOfColumn(int[][] n, int k) {
		int sum = 0;
		for (int i=0; i<n.length; i++) {
			sum += n[i][k];
		}
		return sum;
	}
	
	private static int  sumOfDiagonal1(int[][] s) {
		int sum = 0;
		for (int i=0; i<s.length; i++) {
			for (int j=0; j<s.length; j++) {
				if (i == j)
					sum += s[i][j];
			}
		}
		return sum;
	}
	
	private static int  sumOfDiagonal2(int[][] s) {
		int sum = 0;
		for (int i=0; i<s.length; i++) {
			for (int j=0; j<s.length; j++) {
				if ((i+j) == (s.length-1))
					sum += s[i][j];
			}
		}
		return sum;
	}
	
	
	/*
	 * searching the matrix for doubles
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
            return false;
 
        int m = matrix.length;
        int n = matrix[0].length;
        int flag =0;
        int start = 0;
        int end = m*n-1;
 
        while(start<=end){
            int mid=(start+end)/2;
            int midX=mid/n;
            int midY=mid%n;
 
            if(matrix[midX][midY]==target) {
            	if (flag == 0) flag++;
            	else return true; 
            }
            
            if(matrix[midX][midY]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
 
        return false;
    }
	
	
	static void printSquare(int[][] s) {
		for(int i=0; i<s.length; i++) {
			System.out.print("-----------");
		}
		System.out.print("\n");
		for(int i=0; i<s.length; i++) {
			for(int j=0; j<s.length; j++) {
				if (j==0)System.out.print("|     ");
				else System.out.print("     ");
				System.out.print(s[i][j] );
				
				System.out.print("|");
			}
			
			System.out.println("\n");
			for(int k=0; k<s.length; k++) {
				System.out.print("-----------");
			}
			System.out.print("\n");
			
		}
	}

	public static void main(String[] args){
				
		int[][] magicSquare ;
		boolean hasDublicate=false ;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the 'MAGIC' number\n");
		int n = scan.nextInt();
		
		while (n > 10 || n < 2) {
			System.out.println("wrong number enter number again");
			n = scan.nextInt();
		}
		magicSquare = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				magicSquare[i][j] = -1;
			}
		}
		boolean hasdouble = false ;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				magicSquare[i][j] = scan.nextInt();
				hasdouble = searchMatrix(magicSquare, magicSquare[i][j]);
			}
		}
		
		
		if (hasdouble == true) {
			printSquare(magicSquare);
			System.out.println("The numbers you gave contain duplicates\n"
					+ "The square isn't magic!");
		}
		else checkIsMagic(magicSquare);
		
	}
	
	
}











































