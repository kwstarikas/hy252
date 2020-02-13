package csd.uoc.gr.A13;


import javax.swing.JFileChooser;

import java.util.Scanner;
import java.io.*; 


import java.net.URL;
import javax.swing.JOptionPane;





public class MagicSquareCheckerFile {

	
	
	
	
	private static void printFile(File file,String filepath) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
	
	
	
	/*
	 * returns the length of the row
	 * calculate from the comma +1  
	 */
	private static int getLength(String filepath) throws IOException {
		int length=0;
		int parser;
		FileReader fr = new FileReader(filepath); 
		
		
		while ((parser = fr.read()) != -1) {
			 if ((char)parser == ',') {
				 length++;
			 }
			 
			// System.out.println(curLength);
			 if (!String.valueOf((char)parser).matches(".")) break;
		 }
		fr.close();
		
		return length+1;
	}
	
	private static int getHeight(String filepath) throws IOException {
		
		int height = 0;
		int parser;

		FileReader fr = new FileReader(filepath); 
		while ((parser=fr.read()) != -1) 
			if (!String.valueOf((char)parser).matches(".")) height++;
		fr.close();
		return height;
	}
	
	private static int isSquare(String filepath) throws IOException {
		
		int l = getLength(filepath);
		int parser,curLength = 1;
		
		 FileReader fr = 
			      new FileReader(filepath);
		 while ((parser = fr.read()) != -1) {
			 if ((char)parser == ',') {
				 curLength++;
			 }
			 
			// System.out.println(curLength);
			 if (!String.valueOf((char)parser).matches(".")) {
				 if ( l != curLength) {
					 System.out.println("its not square");
					 System.exit(0);
				 }
				 else {
					 l = curLength; 
					 curLength = 1;
				 }
				 
			 }
		 }
		fr.close();
		return getLength(filepath) ;
	}
	
	private static int[][] makeArray(File file, String filepath) throws IOException {

		int[][] arr ;
		int l = getLength(filepath);
		int i=0 ,j = 0;
		String num = "" ;
		int parser;
		arr = new int[l][l]; 
	
		FileReader fr = new FileReader(filepath);
		 while ((parser = fr.read()) != -1) {
			 num = num+(char)parser;
			 if ((char)parser == ',') {
				 num = num.replace(",","");
				 arr[i][j] = Integer.parseInt(num);
				 System.out.println("otan vriskw komma to num einai :"+num +
						 " me i , j " + i+ "  "+ j);  
				 num="";
				 j++;
			 }
			 if (!String.valueOf((char)parser).matches(".")) {
				 num = num.replace("\n","");
				arr[i][j] =  Integer.parseInt(num);
				System.out.println("otan vriskw keno to num einai :"+num+
						 " me i , j " + i+ "  "+ j);  
				i++;
				j=0;
				num = "";
			 }
		 }
		fr.close();
		
		printSquare(arr);
		checkIsMagic(arr);
		
		return arr;
	}
	
	
	
	/*
	 * print a 2 dimension array
	 * 
	 */
	static void printSquare(int[][] s) {
		
		
		for(int i=0; i<s.length; i++) {
			System.out.print("========");
		}
		System.out.println();
		for(int i=0; i<s.length; i++) {
			System.out.print("--------");
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
				System.out.print("--------");
			}
			System.out.print("\n");
			
		}
	}
	
	
	
	/*
	 * parameters : 2 dimension array of integers
	 * returns true if the "square" is magic or 
	 * false if it's not
	 */
	public static boolean checkIsMagic 	(int[][] s) {
		
		boolean is =  true;	
		int sumr = 0;
		
		sumr = sumOfRow(s, 0);
		
		for (int i=1; i<s.length; i++) {
			if (sumr != sumOfRow(s, i)) {
				printSquare(s);
				System.out.println("The sum of rows is not equal\nThe square isn't "
						+ "magic");
				System.exit(0);
			}
		}
		
		for (int i=1; i<s.length; i++) {
			if(sumr != sumOfColumn(s, i)) {
				printSquare(s);
				System.out.println("The sum of cols is not equal\nThe square isn't "
						+ "magic");
				System.exit(0);
			}
		}
		int diag1 = sumOfDiagonal1(s);
		if (diag1 != sumr) {
			printSquare(s);
			System.out.println("The sum of diag1 is not equal\nThe square isn't "
					+ "magic");
			System.exit(0);
		}
			
			
		int diag2 = sumOfDiagonal2(s);
		if (diag2 != sumr) {
			printSquare(s);
			System.out.println("The sum of diag2 is not equal\nThe square isn't "
					+ "magic");
			System.exit(0);
		}
		printSquare(s);
		System.out.println("The square is magic and the magic element is: "
				+ sumr);
		
		return is ;
	}
	
	
	
	/*
	 * returns the sum of row
	 * parameters : 2 dimension integer array
	 */
	private static int sumOfRow	(int[][] n, int k) {
		
		int sum = 0;
		for (int i=0; i<n.length; i++) {
			sum += n[k][i];
		}
		return sum;
	}
	
	
	/*
	 * returns the sum of collumn 
	 * parameters : 2 dimension integer array
	 */
	private static int  sumOfColumn(int[][] n, int k) {
		
		int sum = 0;
		for (int i=0; i<n.length; i++) {
			sum += n[i][k];
		}
		return sum;
	}
	
	
	
	/*
	 * returns the sum of the 1st diagonal 
	 * parameters : 2 dimension integer array
	 */
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
	
	
	/*
	 * returns the sum of the 2nd diagonal 
	 * parameters : 2 dimension integer array
	 */
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
	
	
	

	/*
	 * parameters: the given url
	 * returns the length of the index's url 
	 */
	private static int getLengthInput(InputStream inputStream) throws IOException {
		
		int length=0;
		int parser;
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(inputStream, "UTF-8"));
		
		while ((parser = in.read()) != -1) {
			 if ((char)parser == ',') {
				 length++;
			 }
			 
			// System.out.println(curLength);
			 if (!String.valueOf((char)parser).matches(".")) break;
		 }
	
		return length+1;
	}
	
	
	
	
	/*
	 * parameters URL input
	 * return the height of the given input
	 * 
	 */
	private static int getHeightInput(InputStream inputStream) throws IOException {
		int height = 0;
		int parser;
		BufferedReader in = new BufferedReader(
				new InputStreamReader(inputStream, "UTF-8"));
		while ((parser=in.read()) != -1) 
			if (!String.valueOf((char)parser).matches(".")) height++;
		System.out.println("to upsos einai ===="+height);
		return height;
	}
	
	
	
	
	/*
	 * checks if the file from URL is square 
	 * 
	 */
	private static int isSquareInput(InputStream inputStream) throws IOException {
		
		int l = getLengthInput(inputStream);
		int parser,curLength = 1;
		
	
		BufferedReader fr =
				new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		
		while ((parser = fr.read()) != -1) {
			 if ((char)parser == ',') {
				 curLength++;
			 }
			 
			// System.out.println(curLength);
			 if (!String.valueOf((char)parser).matches(".")) {
				 if ( l != curLength) {
					 System.out.println("its not square");
					 System.exit(0);
				 }
				 else {
					 l = curLength; 
					 curLength = 1;
				 }
				 
			 }
		 }
		
		return getLengthInput(inputStream) ;
	}
	
	/*
	 * 
	 * create the file MagicSquareSavedFile.txt
	 * from a given array 
	 */
	
	public static void createFile(int[][] s, File selectedPath,int length) throws IOException {
		
		
		File f = new File(selectedPath+"/MagicSquareSavedFile.txt");
		if (f.exists()) f.delete();
		
		File file = new File(selectedPath+"/MagicSquareSavedFile.txt");
		file.createNewFile();
		
		BufferedWriter writer = 
				new BufferedWriter(new FileWriter(selectedPath
						+"/MagicSquareSavedFile.txt", true));
			for (int i=0; i<length; i++) {
				for(int j=0; j<length; j++ ) {
					 System.out.println(s[i][j]);
					 writer.append(String.valueOf(s[i][j]));
					 if(j == (length-1)) continue;
					 else writer.append(','); 
				}
				writer.append('\n');
			}
			
			writer.append('\n');
			writer.append("Μαγικό τετράγωνο με μαγικό αριθμό ");
			writer.append((char) (length*length));
			writer.close();
	
	}
	
	/*
	 * 
	 * the given download method
	 */
	static int[][] download(String address) {
		try {
			
			int i=0,j=0;

			
			URL url = new URL(address);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(url.openStream(), "UTF-8"));
			isSquareInput(url.openStream());
			
			int l = getLengthInput(url.openStream());
			
			l = getHeightInput(url.openStream());
			isSquareInput(url.openStream());
			System.out.println("mpika download me l = "+l);
			int [][] arr = new int [l][l];
			String num = "";

			int parser;
			
			
			while ((parser = in.read()) != -1) {
				 num = num+(char)parser;
				 if ((char)parser == ',') {
					 num = num.replace(",","");
					 arr[i][j] = Integer.parseInt(num);
					 num="";
					 j++;
				 }
				 if (!String.valueOf((char)parser).matches(".")) {
					 num = num.replace("\n","");
					 arr[i][j] =  Integer.parseInt(num);
					 i++;
					 j=0;
					 num = "";
				 }
			}
			
			 printSquare(arr);
			 in.close();
			 
			 return arr;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
		
	
	
	/*
	 * main
	 */
	public static void main(String[] args) throws IOException {
		
		int [][] magicSquare;
		int l =0;
		boolean complete = true;
	
		
		System.out.println("enter 'w' to give a URL or 'f' "
				+ "to choose from your files");
		System.out.println("enter the char  \n");
		
		
		Scanner scan = new Scanner(System.in);
		char M = (char) System.in.read();
		
		
		while (complete) {
			if (M == 'w') {
				String toDownload = 
						JOptionPane.showInputDialog("Δώστετηνδιεύθυνση","");
				
				
				checkIsMagic(download(toDownload));
				
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("choosertitle");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);

			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
			      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
			      //createFile(magicSquare, chooser.getSelectedFile(),l);
			    } else {
			      System.out.println("No Selection ");
			    }
			    JFileChooser chooser1 = new JFileChooser();
			    chooser1.setCurrentDirectory(new java.io.File("."));
			    chooser1.setDialogTitle("choosertitle");
			    chooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser1.setAcceptAllFileFilterUsed(false);

			    if (chooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			      System.out.println("getCurrentDirectory(): " + chooser1.getCurrentDirectory());
			      System.out.println("getSelectedFile() : " + chooser1.getSelectedFile());
			      createFile(download(toDownload), chooser.getSelectedFile(),l);
			    } else {
			      System.out.println("No Selection ");
			    }
				complete = false;
			}
			else if (M == 'f') {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Select a file");
				int userSelection = fileChooser.showSaveDialog(null);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String filepath = file.getAbsolutePath();
					
					l = isSquare(filepath);
					
					magicSquare = new int[l][l];
					magicSquare = makeArray(file,filepath);
					
					JFileChooser chooser = new JFileChooser();
				    chooser.setCurrentDirectory(new java.io.File("."));
				    chooser.setDialogTitle("choosertitle");
				    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				    chooser.setAcceptAllFileFilterUsed(false);

				    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
				      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				      createFile(magicSquare, chooser.getSelectedFile(),l);
				    } else {
				      System.out.println("No Selection ");
				    }
				}
				complete = false;
			}
			else {
				System.out.println("unregognaized char /nEnter char again"
						+ "'w' for url 'f'for file ");
				M = (char) System.in.read();
			}
		}
		
		
		scan.close();
		System.out.println("end of program");    

	}
}
