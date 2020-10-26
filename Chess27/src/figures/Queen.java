package figures;

import chess.*;

public class Queen extends Piece{
	
	public Queen(boolean b) {
		super.black = b;
	}
	
	public boolean validMove(String orig, String dest) {
		return false;
	}
	
}