package figures;

/* 
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya (edb81)
 */

public abstract class Piece {
	
	public boolean black;
	public boolean hasMoved = false;
	
	public abstract boolean validMove(String origin, String destination);
	
	public boolean getColor() {
		return black;
	}

}
