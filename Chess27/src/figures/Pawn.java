package figures;

import chess.*;
//import java.lang.*;

/* 
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya (edb81)
 */

public class Pawn extends Piece{

int turnNum;
public boolean twoSquare;

/*
 * Class for piece Pawn. Extends superclass Piece.
 */

public Pawn(boolean b) {

/*
 * Constructor for Pawn. Takes in black boolean as a parameter.
 * 
 * @param  b  boolean indicating black if true, white if false.
 */

super.black = b;
}

public boolean getColor() {

/*
 * Returns color of Pawn piece.
 * 
 * @return    <code>true</code> if piece is black, <code>false</code> if piece is white
 */

return super.black;
}

public boolean validMove(String orig, String dest) {

/*
 * Determines if the desired move conforms to chess rules. Also performs en passant.
 * 
 * @param  orig  string indicating origin coordinate (ex: a1)
 * @param  dest  string indicating destination coordinate
 * @return<code>true</code> if move is allowed;
 * <code>false</code> otherwise.
 */

Piece[][] board = Chess.getBoard();
int x1 = Character.getNumericValue(orig.charAt(0)) - 10;
int y1 = 7 - Character.getNumericValue(orig.charAt(1) - 1);
int x2 = Character.getNumericValue(dest.charAt(0)) - 10;
int y2 = 7 - Character.getNumericValue(dest.charAt(1) - 1);

if(super.black == false) {
if(x1 == x2) {
if(board[y2][x2] == null) {
if(y2 == y1-1) {
board[y1][x1].hasMoved = true;
board[y1][x1].twoSquare = false;
return true;
}
if((y2 == y1 - 2) && board[y1][x1].hasMoved == false && board[y1-1][x1] == null) {
board[y1][x1].hasMoved = true;
return true;
}
}
}
else if((Math.abs(x1 - x2) == 1) && (y2 == y1-1) && (board[y1-1][x2] != null) && (board[y1-1][x2].getColor() == true)) {
board[y1][x1].hasMoved = true;
board[y1][x1].twoSquare = false;
return true;
}
else if ((Math.abs(x1 - x2) == 1) && (y2 == y1-1) && board[y1-1][x2] == null){//en passant, works fine
if(x2 < x1 && board[y1][x1-1] != null) {//pawn to left
if((board[y1][x1-1] instanceof Pawn) && board[y1][x1-1].getColor() == true && Math.abs(board[y1][x1-1].turnNum - Chess.turnCount) == 1 && board[y1][x1-1].twoSquare == true) {
board[y1][x1-1] = null;
return true;
}
}
else if(x2 > x1 && board[y1][x1+1] != null) {//pawn to right
if((board[y1][x1+1] instanceof Pawn) && board[y1][x1+1].getColor() == true && Math.abs(board[y1][x1+1].turnNum - Chess.turnCount) == 1 && board[y1][x1+1].twoSquare == true) {
board[y1][x1+1] = null;
return true;
}
}
}
else {
return false;
}
}
else if(super.black == true) {
if(x1 == x2) {
if(board[y2][x2] == null) {
if(y2 == y1+1) {
board[y1][x1].hasMoved = true;
board[y1][x1].twoSquare = false;
return true;
}
if((y2 == y1 + 2) && board[y1][x1].hasMoved == false && board[y1+1][x1] == null) {
board[y1][x1].hasMoved = true;
return true;
}
}
}
else if((Math.abs(x1 - x2) == 1) && (y2 == y1+1) && board[y1+1][x2] != null && board[y1+1][x2].getColor() == false) {
board[y1][x1].hasMoved = true;
board[y1][x1].twoSquare = false;
return true;
}
else if ((Math.abs(x1 - x2) == 1) && (y2 == y1+1) && board[y1+1][x2] == null){//en passant, needs work
if(x2 < x1 && board[y1][x1-1] != null) {//pawn to left
if((board[y1][x1-1] instanceof Pawn) && board[y1][x1-1].getColor() == false/* && Math.abs(board[y1][x1-1].turnNum - Chess.turnCount) == 1 && board[y1][x1-1].twoSquare == true*/) {
board[y1][x1-1] = null;
return true;
}
}
else if(x2 > x1 && board[y1][x1+1] != null) {//pawn to right
if((board[y1][x1+1] instanceof Pawn) && board[y1][x1+1].getColor() == false/* && Math.abs(board[y1][x1+1].turnNum - Chess.turnCount) == 1 && board[y1][x1+1].twoSquare == true*/) {
board[y1][x1+1] = null;
return true;
}
}
}
else {
return false;
}
}

return false;
}

}


