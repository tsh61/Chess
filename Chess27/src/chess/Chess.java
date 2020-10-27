package chess;

import figures.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
/* 
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya (edb81)
 */

//     bR bN bB bQ bK bB bN bR 8	
//	   bp bp bp bp bp bp bp bp 7
//	      ##    ##    ##    ## 6
//     ##    ##    ##    ##    5
//	      ##    ##    ##    ## 4
//	   ##    ##    ##    ##    3 
//	   wp wp wp wp wp wp wp wp 2
//	   wR wN wB wQ wK wB wN wR 1
//      a  b  c  d  e  f  g  h
 
public class Chess {
	
	//public static HashMap<String, String> board = new HashMap<String, String>(64); //81?
	
	public static Piece[][] board = new Piece[8][8];
	
	public static Piece[][] getBoard(){
		return Chess.board;
	}
	
	public static int turnCount = 0;
	
	//test
	public static void main(String[] args) {
		
		//Piece p = new Pawn(false);
		
		initializeBoard();
		
		printBoard();
		
		start();
		
	}
	
	public static void start() {
		
		boolean end = false;
		boolean turnColor = false;
		
		while(!end) {
		
		//System.out.println(turnCount);
		
		Scanner sc = new Scanner(System.in);
		
		
		switch(turnCount%2) {
			case(0):
				System.out.println("White's move:");
				turnColor = false;
				break;
			case(1):
				System.out.println("Black's move:");
				turnColor = true;
				break;
		}

		String[] splitted = sc.nextLine().split("\\s+");
		
		if(splitted.length == 0) {
			System.out.println("Illegal move, try again");
			start();
		}
		
		else if(splitted.length == 0 || splitted[0].length() < 2 || splitted.length > 4) {
			System.out.println("Illegal move, try again");
			start();	
		}
		
		else if(splitted[0].equals("resign")) {
			
			if(turnCount%2 == 0) {
				System.out.println("Black wins");
				end = true;
			}
			else {
				System.out.println("White wins");
				end = true;
			}
		}
		
		else {
			int x1 = Character.getNumericValue(splitted[0].charAt(0)) - 10;
			int y1 = 7 - Character.getNumericValue(splitted[0].charAt(1) - 1);
			int x2 = Character.getNumericValue(splitted[1].charAt(0)) - 10;
			int y2 = 7 - Character.getNumericValue(splitted[1].charAt(1) - 1);
		
			Piece initial = board[y1][x1];
			//Piece destination = board[y2][x2];
			
			
			
			if(initial == null || initial.getColor() != turnColor) {
				System.out.println("Illegal move, try again");
				start();
			}
		
			boolean initialColor = initial.getColor();
		
			//Pawn test = new Pawn(true);
		
			//boolean output = test.getColor();
		
			//System.out.println(output);
		
		
			if(initial instanceof Pawn) {
				initial = new Pawn(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
					board[y2][x2] = initial;
					board[y1][x1] = null;
					printBoard();
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
				
			}
			
			else if(initial instanceof Knight) {
				initial = new Knight(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
					board[y2][x2] = initial;
					board[y1][x1] = null;
					printBoard();
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			else if(initial instanceof Rook) {
				initial = new Rook(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
					board[y2][x2] = initial;
					board[y1][x1] = null;
					printBoard();
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			else if(initial instanceof Bishop) {
				initial = new Bishop(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
					board[y2][x2] = initial;
					board[y1][x1] = null;
					printBoard();
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			else if(initial instanceof Queen) {
				initial = new Queen(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
					board[y2][x2] = initial;
					board[y1][x1] = null;
					printBoard();
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			else if(initial instanceof King) {
				initial = new King(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
					board[y2][x2] = initial;
					board[y1][x1] = null;
					printBoard();
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			sc.close();
			}
		sc.close();
		}
	}
	
	public static void initializeBoard() {
		board[0][0] = new Rook(true);	board[7][0] = new Rook(false);
		board[0][1] = new Knight(true); board[7][1] = new Knight(false);
		board[0][2] = new Bishop(true); board[7][2] = new Bishop(false);
		board[0][3] = new Queen(true); board[7][3] = new Queen(false);
		board[0][4] = new King(true); board[7][4] = new King(false);
		board[0][5] = new Bishop(true); board[7][5] = new Bishop(false);
		board[0][6] = new Knight(true); board[7][6] = new Knight(false);
		board[0][7] = new Rook(true); board[7][7] = new Rook(false);
		
		board[1][0] = new Pawn(true); board[6][0] = new Pawn(false);
		board[1][1] = new Pawn(true); board[6][1] = new Pawn(false);
		board[1][2] = new Pawn(true); board[6][2] = new Pawn(false);
		board[1][3] = new Pawn(true); board[6][3] = new Pawn(false);
		board[1][4] = new Pawn(true); board[6][4] = new Pawn(false);
		board[1][5] = new Pawn(true); board[6][5] = new Pawn(false);
		board[1][6] = new Pawn(true); board[6][6] = new Pawn(false);
		board[1][7] = new Pawn(true); board[6][7] = new Pawn(false);
	}
	
	public static void printBoard() {
		
		int count = 8;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Piece currPiece = board[i][j];
				if(currPiece instanceof Piece) {
					if(currPiece instanceof Pawn) {
						if(currPiece.black == false) {
							System.out.print("wp ");
						}
						else {
							System.out.print("bp ");
						}
					}
					else if(currPiece instanceof Rook) {
						if(currPiece.black == false) {
							System.out.print("wR ");
						}
						else {
							System.out.print("bR ");
						}
					}
					else if(currPiece instanceof Knight) {
						if(currPiece.black == false) {
							System.out.print("wN ");
						}
						else {
							System.out.print("bN ");
						}
					}
					else if(currPiece instanceof Bishop) {
						if(currPiece.black == false) {
							System.out.print("wB ");
						}
						else {
							System.out.print("bB ");
						}
					}
					else if(currPiece instanceof Queen) {
						if(currPiece.black == false) {
							System.out.print("wQ ");
						}
						else {
							System.out.print("bQ ");
						}
					}
					else if(currPiece instanceof King) {
						if(currPiece.black == false) {
							System.out.print("wK ");
						}
						else {
							System.out.print("bK ");
						}
					}
				}
				else {
					if (j%2 == 0 && i%2 ==1) {
						System.out.print("## ");
					}
					else if (j%2 == 1 && i%2 == 0){
						System.out.print("## ");
					}
					else {
						System.out.print("   ");
					}
				}
			}
			System.out.println(count);
			count--;
		}
		System.out.println(" a  b  c  d  e  f  g  h");
	}
}
