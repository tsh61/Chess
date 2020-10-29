package chess;

import figures.*;
import java.util.Scanner;
import java.util.*;
/* 
 * @author Travis Harrell (tsh61)
 * @author Elizaveta Belaya (edb81)
 */

//     bR bN bB bQ bK bB bN bR 8	
//	   bp bp bp bp bp bp bp bp 7
//	      ##    ##    ##    ## 6
//     ##    ##    ##    ##    5
//	      ##    ##    ##    ## 4
//	   ##    ##    ##    ##    3 
//	   wp wp wp wp wp wp wp wp 2
//	   wR wN wB wQ wK wB wN wR 1
//      a  b  c  d  e  f  g  h
 //hello there
public class Chess {
	
	/*
	 * Handles the entire chess game. Contains main method which prints the board, records moves, displays a victory, etc.
	 */
	
	//public static HashMap<String, String> board = new HashMap<String, String>(64); //81?
	
	public static Piece[][] board = new Piece[8][8];
	
	public static Piece[][] getBoard(){
		
		/*
		 * Main method. Executes chess game.
		 * 
		 * @param  args  normal main method arguments
		 */
		
		return Chess.board;
	}
	
	public static int turnCount = 0;
	
	public static String wKingPos;
	public static String bKingPos;
	
	public static void main(String[] args) {
		
		//Piece p = new Pawn(false);
		
		initializeBoard();
		
		printBoard();
				
		start();
		
		
		
	}
	
	public static void start() {
		
		/*
		 * Plays the chess game, essentially. Frequently called within itself to start a new turn.
		 */
		
		boolean end = false;
		boolean turnColor = false;
		
		if(turnCount == 0) {
			wKingPos = "e1";
			bKingPos = "e8";
		}
		
		
		while(!end) {

			//System.out.println(turnCount);

			Scanner sc = new Scanner(System.in);


			switch(turnCount%2) {
			case(0):
			System.out.print("White's move: ");
			turnColor = false;
			break;
			case(1):
			System.out.print("Black's move: ");
			turnColor = true;
			break;
			}

			String[] splitted = sc.nextLine().split("\\s+");

			System.out.println();

			/*if(splitted.length == 0) {
			System.out.println("Illegal move, try again");
			System.out.println();
			start();
			}*/

			if(splitted.length == 0 || splitted.length > 4) {
			System.out.println("Illegal move, try again");
			System.out.println();
			start();
			}

			else if (splitted.length == 1) {
			if(splitted[0].equals("resign")) {
			if(turnCount%2 == 0) {
			System.out.println("Black wins");
			end = true;
			break;
			}
			else if(turnCount%2 == 1){
			System.out.println("White wins");
			end = true;
			break;
			}
			}
			else {
			System.out.println("Illegal move, try again");
			System.out.println();
			start();
			}
			}

			else if(splitted.length == 4) {
			if(splitted[3].equals("draw?")) {
			String d = sc.nextLine();
			if(d == "draw") {
			end = true;
			}
			break;
			}
			else {
			System.out.println("Illegal move, try again");
			System.out.println();
			start();
			}
			}

			else if(splitted.length >= 2) {
			
			int x1 = Character.getNumericValue(splitted[0].charAt(0)) - 10;
			int y1 = 7 - Character.getNumericValue(splitted[0].charAt(1) - 1);
			int x2 = Character.getNumericValue(splitted[1].charAt(0)) - 10;
			int y2 = 7 - Character.getNumericValue(splitted[1].charAt(1) - 1);
		
			Piece initial = board[y1][x1];			
						
			if(initial == null || initial.getColor() != turnColor) {
				System.out.println("Illegal move, try again");
				start();
			}
		
			boolean initialColor = initial.getColor();
					

			if(initial instanceof Pawn) {
				initial = new Pawn(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
					
					board[y2][x2] = initial;
					board[y1][x1] = null;
					
					printBoard();
					
					if(turnCount%2==0){//white   
						
						if(check(bKingPos)==true) {//do not need dest of pawn
							System.out.println("Check");
							System.out.println("\n");
						}
					}else if(turnCount%2!=0) {//black   

						if(check(wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Check");
							System.out.println("\n");
						}
					}
					
			/*		if(turnCount%2==0){//white   
						
						if(checkMate(splitted[1],bKingPos)==true) {//do not need dest of pawn
							System.out.println("Checkmate" + "\n" + "White wins");
						}
					}else if(turnCount%2!=0) {//black   

						if(checkMate(splitted[1],wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Checkmate" + "\n" + "Black wins");
						}
					}*/
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
				
			}
			
			else if(initial instanceof Knight) {
				initial = new Knight(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
					
					
					board[y2][x2] = initial;
					board[y1][x1] = null;
					
					printBoard();
					
					if(turnCount%2==0){//white   
						
						if(check(bKingPos)==true) {//do not need dest of pawn
							System.out.println("Check");
							System.out.println("\n");
						}
					}else if(turnCount%2!=0) {//black   

						if(check(wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Check");
							System.out.println("\n");
						}
					}
					/*if(turnCount%2==0){//white   
						
						if(checkMate(splitted[1],bKingPos)==true) {//do not need dest of pawn
							System.out.println("Checkmate" + "\n" + "White wins");
						}
					}else if(turnCount%2!=0) {//black   

						if(checkMate(splitted[1],wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Checkmate" + "\n" + "Black wins");
						}
					}*/
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			else if(initial instanceof Rook) {
				initial = new Rook(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
										
					board[y2][x2] = initial;
					board[y1][x1] = null;
					
					printBoard();
					if(turnCount%2==0){//white   
						
						if(check(bKingPos)==true) {//do not need dest of pawn
							System.out.println("Check");
							System.out.println("\n");
						}
					}else if(turnCount%2!=0) {//black   

						if(check(wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Check");
							System.out.println("\n");
						}
					}	
				/*	if(turnCount%2==0){//white   
						
						if(checkMate(splitted[1],bKingPos)==true) {//do not need dest of pawn
							System.out.println("Checkmate" + "\n" + "White wins");
						}
					}else if(turnCount%2!=0) {//black   

						if(checkMate(splitted[1],wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Checkmate" + "\n" + "Black wins");
						}
					}*/
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			else if(initial instanceof Bishop) {
				initial = new Bishop(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");				
					
					board[y2][x2] = initial;
					board[y1][x1] = null;
					

					
					printBoard();
					
					if(turnCount%2==0){//white   
						
						if(check(bKingPos)==true) {//do not need dest of pawn
							System.out.println("Check");
							System.out.println("\n");
						}
					}else if(turnCount%2!=0) {//black   

						if(check(wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Check");
							System.out.println("\n");
						}
					}	
					
				/*	if(turnCount%2==0){//white   
						
						if(checkMate(splitted[1],bKingPos)==true) {//do not need dest of pawn
							System.out.println("Checkmate" + "\n" + "White wins");
						}
					}else if(turnCount%2!=0) {//black   

						if(checkMate(splitted[1],wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Checkmate" + "\n" + "Black wins");
						}
					}*/
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			else if(initial instanceof Queen) {
				initial = new Queen(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true){
					//System.out.println("true");
					
										
					board[y2][x2] = initial;
					board[y1][x1] = null;
	
					printBoard();
					
					if(turnCount%2==0){//white   
						
						if(check(bKingPos)==true) {//do not need dest of pawn
							System.out.println("Check");
							System.out.println("\n");
						}
					}else if(turnCount%2!=0) {//black   

						if(check( wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Check");
							System.out.println("\n");
						}
					}
					
				/*	if(turnCount%2==0){//white   
						
						if(checkMate(splitted[1],bKingPos)==true) {//do not need dest of pawn
							System.out.println("Checkmate" + "\n" + "White wins");
						}
					}else if(turnCount%2!=0) {//black   

						if(checkMate(splitted[1],wKingPos)==true) {//do not need dest of pawn //e6 a3
							System.out.println("Checkmate" + "\n" + "Black wins");
						}
					}*/
					
					turnCount++;
					start();
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			else if(initial instanceof King) {
				initial = new King(initialColor);
				if(initial.validMove(splitted[0], splitted[1]) == true && underAttack(splitted[0], splitted[1])==false ){
					//System.out.println("true");
				
					/*if(turnCount%2==0){//white king position changes
						wKingPos = splitted[1];
						if(check( bKingPos)) {
							System.out.println(splitted[0] + bKingPos + "CHECKKKKKKKK");
						}
					}else if(turnCount%2!=0) {//black king position changes
						bKingPos = splitted[1];
						if(check( wKingPos)) {
							System.out.println(splitted[0] + bKingPos + "CHECKKKKKKKK");
						}
					}	*/
						board[y2][x2] = initial;
						board[y1][x1] = null;
												
						printBoard();
						//System.out.println("White King Position: "+ wKingPos);
						//System.out.println("Black King Position: "+ bKingPos);
						if(turnCount%2==0){//white king position changes
							wKingPos = splitted[1];
							if(check(bKingPos)==true){
								System.out.println("Check");
								System.out.println("\n");
							}
						}else if(turnCount%2!=0) {//black king position changes
							bKingPos = splitted[1];
							if(check(wKingPos)==true){
								System.out.println("Check");
								System.out.println("\n");
							}
						}	
						turnCount++;
						start();
						
				}
				else {
					System.out.println("Illegal move, try again");
					start();
				}
			}
			
			
			
			sc.close();
			}
		sc.close();
		}
	}
	
/*	public static boolean checkMate(String hz, String orig) {
		int x1 = Character.getNumericValue(orig.charAt(0)) - 10;
		int y1 = 7 - Character.getNumericValue(orig.charAt(1) - 1);
		
		int x2 = Character.getNumericValue(hz.charAt(0)) - 10;
		int y2 = 7 - Character.getNumericValue(hz.charAt(1) - 1);
		char a;
		char b;
		int count = 0;
		int q = 0;
		List <String> kingDest = new ArrayList <String> ();
		
		
		//board[y1-1][x1]		
		 a = convert(x1, 'j');
		 b = convert(y1-1, 'i');	 
		 if((a=='a'||a=='b'||a=='c'||a=='d'||a=='e'||a=='f'||a=='g'||a=='h')  &&  (b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8')) {
		 String dest1 = "" + a + b;	 
		 kingDest.add(dest1);
		 }	else {
			 q++;
		 }
		 
		//board[y1+1][x1]
		 b = convert(y1+1, 'i');
		 
		 if((a=='a'||a=='b'||a=='c'||a=='d'||a=='e'||a=='f'||a=='g'||a=='h')  &&  (b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8')) {
		 String dest2 = "" + a + b;		
		 kingDest.add(dest2);
		 }else {
			 q++;
		 }
		 
		//board[y1][x1+1]
		 a = convert(x1+1, 'j');
		 b = convert(y1, 'i');
		 
		 if((a=='a'||a=='b'||a=='c'||a=='d'||a=='e'||a=='f'||a=='g'||a=='h')  &&  (b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8')) {
		 String dest3 = "" + a + b;	
		 kingDest.add(dest3);
		 }else {
			 q++;
		 }
		//board[y1][x1+1]
		 a = convert(x1-1, 'j');
		 
		 if((a=='a'||a=='b'||a=='c'||a=='d'||a=='e'||a=='f'||a=='g'||a=='h')  &&  (b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8')) {
		 String dest4 = "" + a + b;	
		 kingDest.add(dest4);
		 }else {
			 q++;
		 }
		 
		 
		//board[y1-1][x1-1]
		 a = convert(x1-1, 'j');
		 b = convert(y1-1, 'i');
		 if((a=='a'||a=='b'||a=='c'||a=='d'||a=='e'||a=='f'||a=='g'||a=='h')  &&  (b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8')) {
		 String dest5 = "" + a + b;
		 kingDest.add(dest5);
		 }else {
			 q++;
		 }
		//board[y1-1][x1+1]
		 a = convert(x1+1, 'j');	
		 if((a=='a'||a=='b'||a=='c'||a=='d'||a=='e'||a=='f'||a=='g'||a=='h')  &&  (b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8')) {
		 String dest6 = "" + a + b;
		 kingDest.add(dest6);
		 }else {
			 q++;
		 }
		//board[y1+1][x1-1]
		 a = convert(x1-1, 'j');
		 b = convert(y1+1, 'i');
		 if((a=='a'||a=='b'||a=='c'||a=='d'||a=='e'||a=='f'||a=='g'||a=='h')  &&  (b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8')) {
		 String dest7 = "" + a + b;
		 kingDest.add(dest7);
		 }else {
			 q++;
		 }
		//board[y1+1][x1+1]
		 a = convert(x1+1, 'j');	
		 if((a=='a'||a=='b'||a=='c'||a=='d'||a=='e'||a=='f'||a=='g'||a=='h')  &&  (b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8')) {
		 String dest8 = "" + a + b;
		 kingDest.add(dest8);
		 }else {q++;}
		
		 
		 
		 for (int i = 0; i < kingDest.size(); i++) {
			 System.out.println(kingDest.get(i));
		 }	 
			 
		 for (int i = 0; i < kingDest.size(); i++) {
	    
			 if(check(hz,kingDest.get(i)) == true) {
				 count ++;
			 }else if(check(hz,kingDest.get(i)) == false) {
				 	q++;			 
			 }
	       }
		 
		 
		 if (count == kingDest.size()) {
			 return true;
		 }
		 
		 return false;		 
	}*/
	
	public static boolean check(String dest) { //a3		
		
		/*
		 * Sees if king is in jeopardy of being captured.
		 * 
		 * @param  dest  destination of king 
		 * @return     <code>true</code> if king in check, <code>false</code> otherwise
		 */
		
		int x2 = Character.getNumericValue(dest.charAt(0)) - 10;
		int y2 = 7 - Character.getNumericValue(dest.charAt(1) - 1);
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){			
				Piece currPiece = board[i][j]; 			 				
				
				if(board[i][j]!=null){
				//	System.out.println("check1");
				//System.out.println(dest);
					if( (currPiece.black==true && board[y2][x2].black==false) || (currPiece.black==false && board[y2][x2].black==true) ){					
					//	System.out.println("check2");
						char a = convert(j, 'j');
						char b = convert(i, 'i');
						String currPos = "" + a + b;//f8
						if(currPiece.validMove(currPos, dest) == true){
						//	System.out.println("check3");
							return true;
						}
					}

					}
								
			}
		}
		
			
			
			
		return false;
	}
	
	public static boolean underAttack(String orig, String dest) {
		
		/*
		 * Checks if king can move to a spot without being under the range of attack of another piece.
		 * 
		 * @param  orig  origin of king piece
		 * @param  dest  destination of king piece
		 * 
		 * @return       <code>true</code> if king would be under attack if moved to destination, <code>false</code> otherwise
		 */
		
		int x1 = Character.getNumericValue(orig.charAt(0)) - 10;
		int y1 = 7 - Character.getNumericValue(orig.charAt(1) - 1);
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){			
				Piece currPiece = board[i][j]; 			 
				if(board[i][j]!=null){
					if( (currPiece.black==true && board[y1][x1].black==false) || (currPiece.black==false && board[y1][x1].black==true) ){
						char a = convert(j, 'j');
						char b = convert(i, 'i');
						String currPos = "" + a + b;											
						if(currPiece.validMove(currPos, dest) == true){
							return true;
						}											
					} 				
				}
			}
		}			
		return false;
	}
		
	public static char convert(int v, char c) {
		
		/*
		 * Converts array coordinate to string coordinate.
		 * 
		 * @param  v  vertical coordinate
		 * @param  c  horizontal coordinate
		 * 
		 * @return    char of input to construct string
		 */
		
		char a= 'x';
		
		if(c == 'i') {
				
			if(v==0) {
				a = '8';
				
			}else if(v==1){
				a = '7';

			}else if(v==2){
				a = '6';
				
			}else if(v==3){
				a = '5';	
				
			}else if(v==4){
				a = '4';
				
			}else if(v==5){
				a = '3';
				
			}else if(v==6){
				a = '2';
				
			}else if(v==7){
				a = '1';
				
			}
			
		}else if(c == 'j') {	
			
			if(v==0) {
				a = 'a';
				
			}else if(v==1){
				a = 'b';
				
			}else if(v==2){
				a = 'c';
				
			}else if(v==3){
				a = 'd';	
			
			}else if(v==4){
				a = 'e';
				
			}else if(v==5){
				a = 'f';
				
			}else if(v==6){
				a = 'g';
				
			}else if(v==7){
				a = 'h';
				
			}	
			}			
		
		return a;
	}
	
 	public static void initializeBoard() {
 		
 		/*
 		 * Sets up untouched chess board for new game. Method called once in main method before game begins.
 		 */
 		
		board[0][0] = new Rook(true);	board[7][0] = new Rook(false);
		board[0][1] = new Knight(true); board[7][1] = new Knight(false);
		board[0][2] = new Bishop(true); board[7][2] = new Bishop(false);
		board[0][3] = new Queen(true); board[7][3] = new Queen(false);
		board[0][4] = new King(true); board[7][4] = new King(false);
		board[0][5] = new Bishop(true); board[7][5] = new Bishop(false);
		board[0][6] = new Knight(true); board[7][6] = new Knight(false);
		board[0][7] = new Rook(true); board[7][7] = new Rook(false);
		
		board[1][0] = new Pawn(true); board[6][0] = new Pawn(false);
		board[1][1] = new Pawn(true); board[6][1] = new Pawn(false);
		board[1][2] = new Pawn(true); board[6][2] = new Pawn(false);
		board[1][3] = new Pawn(true); board[6][3] = new Pawn(false);
		board[1][4] = new Pawn(true); board[6][4] = new Pawn(false);
		board[1][5] = new Pawn(true); board[6][5] = new Pawn(false);
		board[1][6] = new Pawn(true); board[6][6] = new Pawn(false);
		board[1][7] = new Pawn(true); board[6][7] = new Pawn(false);
	}
	
	public static void printBoard() {
		
		/*
		 * Prints most recent board, as it currently stands. Reflects moves made upon it.
		 */
		
		int count = 8;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Piece currPiece = board[i][j];
				if(currPiece instanceof Piece) {
					if(currPiece instanceof Pawn) {
						if(currPiece.black == false) {
							System.out.print("wp ");
						}
						else {
							System.out.print("bp ");
						}
					}
					else if(currPiece instanceof Rook) {
						if(currPiece.black == false) {
							System.out.print("wR ");
						}
						else {
							System.out.print("bR ");
						}
					}
					else if(currPiece instanceof Knight) {
						if(currPiece.black == false) {
							System.out.print("wN ");
						}
						else {
							System.out.print("bN ");
						}
					}
					else if(currPiece instanceof Bishop) {
						if(currPiece.black == false) {
							System.out.print("wB ");
						}
						else {
							System.out.print("bB ");
						}
					}
					else if(currPiece instanceof Queen) {
						if(currPiece.black == false) {
							System.out.print("wQ ");
						}
						else {
							System.out.print("bQ ");
						}
					}
					else if(currPiece instanceof King) {
						if(currPiece.black == false) {
							System.out.print("wK ");
						}
						else {
							System.out.print("bK ");
						}
					}
				}
				else {
					if (j%2 == 0 && i%2 ==1) {
						System.out.print("## ");
					}
					else if (j%2 == 1 && i%2 == 0){
						System.out.print("## ");
					}
					else {
						System.out.print("   ");
					}
				}
			}
			System.out.println(count);
			count--;
		}
		System.out.println(" a  b  c  d  e  f  g  h");
	}
}
