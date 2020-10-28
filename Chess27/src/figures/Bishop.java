package figures;

import chess.*;

/* 
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya (edb81)
 */

public class Bishop extends Piece{

	public Bishop(boolean b) {
		super.black = b;
	}

	public boolean validMove(String orig, String dest) {

		Piece[][] board = Chess.getBoard();
		int x1 = Character.getNumericValue(orig.charAt(0)) - 10;
		int y1 = 7 - Character.getNumericValue(orig.charAt(1) - 1);
		int x2 = Character.getNumericValue(dest.charAt(0)) - 10;
		int y2 = 7 - Character.getNumericValue(dest.charAt(1) - 1);
		int count = Math.abs(y2 - y1);

		if(x1==x2 || y1 == y2 || (Math.abs(y2-y1)!=Math.abs(x2-x1))) { //not diagonal move
			return false;
		}

		if(board[y2][x2]!=null) {
			if((board[y2][x2].black == false && board[y1][x1].black == false)|| (board[y2][x2].black == true && board[y1][x1].black == true)) {
				return false;
			}
		}

		for(int i = 1; i<count; i++) {
			if(x1>x2 && y1>y2){ //up and left c1 a3
				if(board[y1-i][x1-i]!=null) {
					return false;
				}
			}
			else if(x1<x2 && y1>y2){ //up and right c1 e3
				if(board[y1-i][x1+i]!=null) { 
					return false;
				}
			}
			else if(x1>x2 && y1<y2){ //down and left c8 a6
				if(board[y1+i][x1-i]!=null) {
					return false;
				}
			}
			else if(x1<x2 && y1<y2){ //down and right c8 e6
				if(board[y1+i][x1+i]!=null) {
					return false;
				}
			}
		}
		return true;
	}
}