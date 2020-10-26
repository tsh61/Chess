package figures;

import chess.*;
import java.lang.*;

public class Pawn extends Piece{
	
	boolean b;
	
	public Pawn(boolean b) {
		super.black = b;
	}
	
	public boolean getColor() {
		return super.black;
	}
	
	public boolean validMove(String orig, String dest) {
		
		//orig = a2, dest = a4
		Piece[][] board = Chess.getBoard();
		int x1 = Character.getNumericValue(orig.charAt(0)) - 10;
		int y1 = 7 - Character.getNumericValue(orig.charAt(1) - 1);
		int x2 = Character.getNumericValue(dest.charAt(0)) - 10;
		int y2 = 7 - Character.getNumericValue(dest.charAt(1) - 1);
		
		if(super.black == false) {
			if(x1 == x2) {
				if(board[y2][x2] == null) {
					if(y2 == y1-1) {
						hasMoved = true;
						return true;
					}
					if((y2 == y1 - 2) && hasMoved == false && board[y1-1][x1] == null) {
						hasMoved = true;
						return true;
					}
				}
			}
			else if((Math.abs(x1 - x2) == 1) && (y2 == y1-1) && board[y1-1][x1] != null && board[y1-1][x1].black == true) {
				hasMoved = true;
				return true;
			}
			else {
				return false;
			}
		}
		else if(super.black == true) {
			if(x1 == x2) {
				if(board[y2][x2] == null) {
					if(y2 == y1+1) {
						hasMoved = true;
						return true;
					}
					if((y2 == y1 + 2) && hasMoved == false && board[y1+1][x1] == null) {
						hasMoved = true;
						return true;
					}
				}
			}
			else if((Math.abs(x1 - x2) == 1) && (y2 == y1+1) && board[y1+1][x1] != null && board[y1+1][x1].black == false) {
				hasMoved = true;
				return true;
			}
			else {
				return false;
			}
		}
		
		return false;
	}
	
}
