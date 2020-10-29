package figures;

import chess.*;
//import java.util.*;

/* 
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya (edb81)
 */

public class King extends Piece{
	
	/*
	 * Class for piece King. Extends superclass Piece.
	 */
	
	public King(boolean b) {
		super.black = b;
	}
	
	public boolean validMove(String orig, String dest) {
		
		/*
		 * Determines if the desired move conforms to chess rules. Also performs castling.
		 * 
		 * @param  orig  string indicating origin coordinate (ex: a1)
		 * @param  dest  string indicating destination coordinate
		 * @return     <code>true</code> if move is allowed, <code>false</code> otherwise.
		 */
		
		Piece[][] board = Chess.getBoard();
		int x1 = Character.getNumericValue(orig.charAt(0)) - 10;
		int y1 = 7 - Character.getNumericValue(orig.charAt(1) - 1);
		int x2 = Character.getNumericValue(dest.charAt(0)) - 10;
		int y2 = 7 - Character.getNumericValue(dest.charAt(1) - 1);
		int count = 0;
		
		if(board[y2][x2]!=null){
			if((board[y2][x2].black == false && board[y1][x1].black == false)|| (board[y2][x2].black == true && board[y1][x1].black == true)) {
				//System.out.println("same color");
			//	System.out.println("YYYYYY");
			//	System.out.println("XXXX");
				return false;
			}
		}
		//castling case
		
		
		//check if moved 
		
		
		if(x1 == x2) { //vertical 
			if(y1-1 == y2) { //one cell up			
				board[y1][x1].hasMoved = true;	
				return true;
			}else if(y1+1 == y2) {//one cell down				
				board[y1][x1].hasMoved = true;							
				return true;
			}else{
				return false; //tries to move up or down more than one cell
			}		
		}else if(y1 == y2) {// horizontal
			if(x1+1 == x2) { //one cell right
				board[y1][x1].hasMoved = true;	
				return true;
			}else if(x1-1 == x2) {//one cell left
				board[y1][x1].hasMoved = true;	
				return true;
				
			}else if(x1+2==x2) {//castling to the right  SHORT
				System.out.println("X");
					if(board[y1][x1].black == false) { //WHITE
						System.out.println("XX");
						if (board[y1][x1].hasMoved == false && board[7][7].hasMoved == false && Chess.underAttack("e1","f1")==false )  {
							board[7][5]= board[7][7];
							board[7][7] = null;							
							return true;
						}
			
					}else if(board[y1][x1].black == true) {	//BLACK
						if (board[y1][x1].hasMoved == false && board[0][7].hasMoved == false && Chess.underAttack("e8","f8")==false) {
							board[0][5]= board[0][7];
							board[0][7] = null;	
							return true;
						}
					}
			}else if (x1-2==x2) {// to the left LONG
				
					if(board[y1][x1].black == false) {//WHITE
						if (board[y1][x1].hasMoved == false && board[7][0].hasMoved == false && Chess.underAttack("e1","d1")==false )  {
							board[7][3]= board[7][0];
							board[7][0] = null;	
							return true;							
						}
						
					}else if(board[y1][x1].black == true) {	//BLACK
						if (board[y1][x1].hasMoved == false && board[0][0].hasMoved == false && Chess.underAttack("e8","d8")==false) {
							board[0][3]= board[0][0];
							board[0][0] = null;	
							return true;
						}					
					}				
			}else {
				return false;
			}
			
		}else if(Math.abs(y2-y1)==Math.abs(x2-x1)) {// diagonal
			if(x1>x2 && y1>y2){ //up and left
				if(x1-1==x2 && y1-1==y2) { //one cell up and left
					board[y1][x1].hasMoved = true;	
					return true;
				}
			}else if(x1<x2 && y1>y2){ // up and right
				if(x1+1==x2 && y1-1==y2){ //one cell up and left
					board[y1][x1].hasMoved = true;	
					return true;
				}
			}else if(x1>x2 && y1<y2){ // down and left
				if(x1-1==x2 && y1+1==y2){ // one cell down and left
					board[y1][x1].hasMoved = true;	
					return true;
				}
			}else if(x1<x2 && y1<y2){ // down and right
				if(x1+1==x2 && y1+1==y2){ // one cell down and right
					board[y1][x1].hasMoved = true;	
					return true;
				}
			}			
		}else {
			return false;
		}
				
		return false;
	}
	
}
