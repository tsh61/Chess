package figures;

import chess.*;

public class Rook extends Piece{
	
	public Rook(boolean b) {
		super.black = b;
	}
	
	public boolean validMove(String orig, String dest) {
		return false;
	}
	
}
