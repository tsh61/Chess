package figures;

import chess.*;

public class King extends Piece{
	
	public King(boolean b) {
		super.black = b;
	}
	
	public boolean validMove(String orig, String dest) {
		return false;
	}
	
}
