package figures;

import chess.*;

/* 
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya (edb81)
 */

public class King extends Piece{
	
	public King(boolean b) {
		super.black = b;
	}
	
	public boolean validMove(String orig, String dest) {
		return false;
	}
	
}
