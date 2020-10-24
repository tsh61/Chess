package pieces;

/*
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya(edb81)
 */

public abstract class piece {
	
	boolean black;
	boolean hasMoved = false;
	
	public abstract boolean canMove(String move);

}
