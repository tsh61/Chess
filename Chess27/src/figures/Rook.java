package figures;

import chess.*;

/* 
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya (edb81)
 */

public class Rook extends Piece{

	public Rook(boolean b) {
		super.black = b;
	}

	public boolean getColor() {
		return super.black;
	}

	public boolean validMove(String orig, String dest) {
	
		Piece[][] board = Chess.getBoard();
		int x1 = Character.getNumericValue(orig.charAt(0)) - 10;
		int y1 = 7 - Character.getNumericValue(orig.charAt(1) - 1);
		int x2 = Character.getNumericValue(dest.charAt(0)) - 10;
		int y2 = 7 - Character.getNumericValue(dest.charAt(1) - 1);
		int count = 0;
		
		if(x1 == x2) { //vertical
			count = Math.abs(y2 - y1);
		}
		else if(y1 == y2) {
			count = Math.abs(x2 - x1);
		}
		else if(x1 != x2 && y1 != y2) {
			return false;
		}

		if(board[y2][x2]!=null) {
			if((board[y2][x2].black == false && board[y1][x1].black == false)|| (board[y2][x2].black == true && board[y1][x1].black == true)) {
				return false;
			}
		}

		for(int i = 1; i<count; i++){
			if(x1 == x2 && y1 > y2){ //up
				if(board[y1-i][x1]!=null){
					return false;
				}
			}
			else if(x1 == x2 && y1 < y2){ //down
				if(board[y1+i][x1]!=null){
					return false;
				}
			}
			else if(y1 == y2 && x1 < x2){ //right
				if(board[y1][x1+i]!=null){
					return false;
				}
			}
			else if(y1 == y2 && x1 > x2){ //left
				if(board[y1][x1-i]!=null){
					return false;
				}
			} 
		}
		board[y1][x1].hasMoved = true;
		return true;

	}
}