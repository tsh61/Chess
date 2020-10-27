package figures;

import chess.*;

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
		int y1 = Character.getNumericValue(orig.charAt(1) - 1);
		int x2 = Character.getNumericValue(dest.charAt(0)) - 10;
		int y2 = Character.getNumericValue(dest.charAt(1) - 1);
		
		//boolean colorCheck = board[y2][x1].black == board[y1][x1].black;
		
		if(x1 == x2) {
			if(board[y2][x1] == null) {
				if(y1 < y2) {
					for(int i = y1 + 1; i <= y2; i++) {
						if(board[i][x1] != null) {
							return false;
						}
					}
					return true;
				}
				else if (y1 > y2) {
					for(int i = y1 - 1; i >= y2; i--) {
						if(board[i][x1] != null) {
							return false;
						}
					}
					return true;
				}
			}
			/*else if(board[y2][x1] != null && (board[y2][x1].getColor() != board[y1][x1].getColor())) {
				for(int i = y1 + 1; i < y2; i++) {
					if(board[i][x1] != null) {
						return false;
					}
				}
				return true;
			}*/
		}
		else if(y1 == y2) {
			if(board[y1][x2] == null) {
				for(int i = x1 + 1; i <= x2; i++) {
					if(board[y1][i] != null) {
						return false;
					}
				}
				return true;
			}
			/*else if(board[y1][x2] != null && (board[y1][x2].getColor() != board[y1][x1].getColor())) {
				for(int i = x1 + 1; i < x2; i++) {
					if(board[y1][i] != null) {
						return false;
					}
				}
				return true;
			}*/
		}
		return false;
	}
}
