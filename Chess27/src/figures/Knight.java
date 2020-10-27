package figures;

import chess.*;

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
		
		
		if(board[y2][x2] == null || !(board[y2][x2].getColor() == board[y1][x1].getColor())) {
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
		return false;
	}
	
}
