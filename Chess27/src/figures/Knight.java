package figures;

import chess.*;

/* 
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya (edb81)
 */

public class Knight extends Piece{
	
	public Knight(boolean b) {
		super.black = b;
	}
	
	public boolean validMove(String orig, String dest) {
		
		Piece[][] board = Chess.getBoard();
		int x1 = Character.getNumericValue(orig.charAt(0)) - 10;
		int y1 = Character.getNumericValue(orig.charAt(1) - 1);
		int x2 = Character.getNumericValue(dest.charAt(0)) - 10;
		int y2 = Character.getNumericValue(dest.charAt(1) - 1);
		
		if(board[y2][x2] == null) {
			if(x2 == x1-2 && y2 == y1-1) {
				return true;
			}
			else if(x2 == x1-1 && y2 == y1-2) {
				return true;
			}
		
			else if(x2 == x1+2 && y2 == y1+1) {
				return true;
			}
			else if(x2 == x1+1 && y2 == y1+2) {
				return true;
			}
		
			else if(x2 == x1+2 && y2 == y1-1) {
				return true;
			}
			else if(x2 == x1+1 && y2 == y1-2) {
				return true;
			}
		
			else if(x2 == x1-1 && y2 == y1+2) {
				return true;
			}
			else if(x2 == x1-2 && y2 == y1+1) {
				return true;
			}
			else {
				return false;
			}
		}
		
		else if (board[y2][x2] != null){
			if((super.black == false && board[y2][x2].black == false) || (super.black == true && board[y2][x2].black == true)) {
				if(x2 == x1-2 && y2 == y1-1) {
					return true;
				}
				else if(x2 == x1-1 && y2 == y1-2) {
					return true;
				}
			
				else if(x2 == x1+2 && y2 == y1+1) {
					return true;
				}
				else if(x2 == x1+1 && y2 == y1+2) {
					return true;
				}
			
				else if(x2 == x1+2 && y2 == y1-1) {
					return true;
				}
				else if(x2 == x1+1 && y2 == y1-2) {
					return true;
				}
			
				else if(x2 == x1-1 && y2 == y1+2) {
					return true;
				}
				else if(x2 == x1-2 && y2 == y1+1) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
}
