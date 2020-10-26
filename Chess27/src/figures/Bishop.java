package figures;

import chess.*;

public class Bishop extends Piece{
	
	public Bishop(boolean b) {
		super.black = b;
	}
	
	public boolean validMove(String orig, String dest) {
		return false;
	}
	
}