package csd.uoc.gr.A14;


import java.util.Random;

import java.util.Scanner;

import java.util.stream.IntStream;



public class Sudoku {

    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;
    private static final int BOARD_START_INDEX = 0;

    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private static int[][] board = {
    		{ 8, 0, 0, 0, 0, 0, 0, 0, 0 },
    		  { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
    		  { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
    		  { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
    		  { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
    		  { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
    		  { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
    		  { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
    		  { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
    };

  

    private void printBoard() {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] board) {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                if (board[row][column] == NO_VALUE) {
                    for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && solve(board)) {
                            
                        	return true;
                        }
                        board[row][column] = NO_VALUE;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int column) {
        return rowConstraint(board, row) &&
          columnConstraint(board, column) &&
          subsectionConstraint(board, row, column);
    }

    private static boolean subsectionConstraint(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

        int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }

    private static boolean columnConstraint(int[][] board, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
          .allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    private static boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
          .allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    private static boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column) {
        if (board[row][column] != NO_VALUE) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }
    
    
    
    private static boolean hasOneToNine(int[][] brd) {
    	boolean has = false ; 
    	
    	for(int i=0; i<brd.length; i++) {
    		for (int j=0; j<brd.length; j++) {
    			if((brd[i][j] >=1 && brd[i][j] <= 9)|| brd[i][j] == 0L) {
    				has = true;
    			}
    			else return false ;
    		}
    	}
    	
    	
    	
    	return has;
    }
    
    private static boolean hasDouble(int[][] brd) {
    	
    	boolean is = true;
    	int i = 0,j = 0;
    	int l=3,h=3,flag1=0,flag2=0,k=0,m=0,n=0;
    	
    	int[][] arr = new int [3][3];
    	
    	
    	
    	/*
    	 * trexw to 9x9 kathe tetragono xexorista 
    	 * */
    	while(  k < 9 ) {
    		//for 9 squares
    		for(i=flag1; i<l; i++) {
    			for(j=flag2;j<h; j++) {
    				// put each square to a help array 3x3 and check if it has equals  
    				arr[m][n] = brd[i][j];
    				is = hasDuplicatesInRows(arr);
    				n++;
    			}
    			n=0;
    			m++;
    		}
    		m=0;
    		
    		k++;
    		if(k%3 == 0  ) {
    			i=0;
    			flag1 = 0;
    			
    			l=3;
    			flag2 +=3;
    			j=flag2;
    			h+=3;
    		}
    		else {
    			i=flag1;
    			flag1 +=3;
    			
    			j=0;
    			l+=3;
    		}
    	}
    	
    	return is ;
    }
    
    
    /*
     * 
     * copied from 
     * https://stackoverflow.com/questions/21922354/check-duplicate-in-rows-and-columns-2d-array
     * :)
     */
    
    private static boolean hasDuplicatesInRows(int[][] inArray)
    {
        for (int row = 0; row < inArray.length; row++)
        {
            for (int col = 0; col < inArray[row].length; col++)
            {
                int num = inArray[row][col];
                for (int otherCol = col + 1; otherCol < inArray.length; otherCol++)
                {
                    if (num == inArray[row][otherCol])
                    {
                    	if(num == 0) continue;
                    	else return false; // have duplicate 
                        
                    }
                }
            }
        }

        return true; // dont have
    }
    
    static boolean isSolvableBoard(int[][] brd) {
    	boolean is = true;
    	
    	is = isValidBoard(brd);
    	
    	return is;
    }
    
    private static boolean isValidBoard(int[][] brd) {
    	boolean is = true;
    	
    	is = hasOneToNine(brd);
    	is = hasDouble(brd);
    	
    	return is ; 
    	
    	
    }
    
    static int[][] generate(int X){
    	int [][] arr = new int [9][9];
    	
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<9; j++) {
    			Random randomGenerator = new Random();
    			int randomInt = 
    					randomGenerator.nextInt(9-1+1) + 1;
				//System.out.println("to random einai "+ randomInt);
    			arr[i][j] = randomInt;
    		}
    	}
    	
    	for(int i=0; i<X; i++) {
    		
    		Random rand = new Random();

    		// Obtain a number between [0 - 8].
    		int posOne = rand.nextInt(9);
    		int posTwo = rand.nextInt(9);
    		// if already 0 get number again
    		if(arr[posOne][posTwo] == 0) {
    			while(arr[posOne][posTwo] == 0) {
    				 posOne = rand.nextInt(9);
    	    		 posTwo = rand.nextInt(9);
    			}
    		}
            arr[posOne][posTwo] = 0;
    	}
    	
    	
    	
    	return arr;
    }
    
    static void print(int[][] brd) {
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<9; j++) {
    			System.out.print(brd[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    
    
    static void createNBoard(int N, int X) {
    	
    	int curr_board = 1;
    	int valid_boards_created=0;
    	int invalid_boards_created = 0;
    	int unsolavble_boards_created=0;
    	int [][] arr = new int [9][9];
    	
    	for(int i=0; i<N; i++) {
    		System.out.println("------------------------");
    		System.out.println("------------------------");
    		arr = generate(X);
    		if(isValidBoard(arr) == false ) invalid_boards_created++;
    		else valid_boards_created++;
    		if( isSolvableBoard(arr) == false) unsolavble_boards_created++;
    		System.out.println("N = "+N);
    		System.out.println("X = "+X);
    		System.out.println("------------------------");
    		System.out.println("board #"+curr_board);
    		print(arr);
    		System.out.println("Solution of the Board #"+curr_board);
    		curr_board++;
    		solve(arr);
    		print(arr);
    	}
    	System.out.println("Empty cells per board	 :"+X);
    	System.out.println("Valid boards created 	 :"+valid_boards_created);
    	System.out.println("Invalid boards created   :"+ invalid_boards_created);
    	System.out.println("Unsolvable boards created:" + unsolavble_boards_created);
    }
    
    public static void main(String[] args) {
        Sudoku solver = new Sudoku();
        boolean is =  isSolvableBoard(board);
        int X,N;
        if (is == false ) 
        	System.exit(0);
        
        System.out.println("pazle is solvable!");
        Scanner myInput = new Scanner( System.in );
        
        System.out.print( "Enter X : " );
        X = myInput.nextInt();
        System.out.print( "Enter N : " );
        N = myInput.nextInt();
        long start = System.currentTimeMillis();
        
        createNBoard(N,X);
        
        long end = System.currentTimeMillis();
        float sec = (end -start) / 1000F; 
        System.out.println("Elapsed time in seconds  : "+sec);
        myInput.close();
    }
    
    
}