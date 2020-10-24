package chess;

import java.util.HashMap;
import java.util.Scanner;
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
//	   wR wB wN wQ wK wB wN wR 1
//      a  b  c  d  e  f  g  h
 
public class Chess {
	
	public static HashMap<String, String> board = new HashMap<String, String>(64); //81?
	
	public static void main(String[] args) {
		
			chessBoard();
			printBoard();
					
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter initial position and desired posotion: ");
		String [] splitted = sc.nextLine().split("\\s+");
		
		 if(splitted.length>3)	{
			 System.out.println("Invalid input.");
			 // ask for another input? Recursion?
		 }
	
		 
		String i_pos = splitted[0]; //a1 initial position
		String d_pos = splitted[1];	//a5 desired position
	//	String draw  = splitted[2]; // What if the third element is "draw"?
		int k = d_pos.charAt(1) - i_pos.charAt(1);			
	//	System.out.println("Initial position: " + i_pos +" "+ "Desired position: " + d_pos); // + " Draw? "+ draw);
		char i_let  = i_pos.charAt(0); //a
		char i_num  = i_pos.charAt(1); //1
		 	
	/* Small test for a pawn move. Pawn can move only forward => only i_num is incremented */			
		for(int i=0;i<k;i++) {			
			i_num++;				
			String pos = Character.toString(i_let) + Character.toString(i_num);
			
			if(isOccupied(pos)==true && isSameCol(i_pos,d_pos)==true) { //case when cell is occupied and of the same color
				System.out.println("Illegal move, try again");	
				//ask for another input? Recursion?
			}else if(isOccupied(pos)==false){ //empty
				// just move it
			}else{
				//case when it's occupied with opponent's piece => should replace it!
			}
		} 
				
		sc.close();		
	}
	
	private static boolean isSameCol(String i_pos, String d_pos) {	//check first chars of pieces at initial and desired positions 'w' vs 'b'
		if(i_pos.charAt(0)==d_pos.charAt(0)) {
			return true;
		}else {
			return false;
		}
	}
	
	private static boolean isOccupied(String pos) {	//check if the desired position occupied, don't think we need it tho
		if(board.get(pos)=="") {
			return true;
		}else {
			return false;
		}
	}
	public static void chessBoard() {
	
		board.put("a1","wR"); board.put("a2","wp");
		board.put("b1","wN"); board.put("b2","wp");
		board.put("c1","wB"); board.put("c2","wp");
		board.put("d1","wQ"); board.put("d2","wp");
		board.put("e1","wK"); board.put("e2","wp");
		board.put("f1","wB"); board.put("f2","wp");
		board.put("g1","wN"); board.put("g2","wp");
		board.put("h1","wR"); board.put("h2","wp");
		 
		board.put("a8","bR"); board.put("a7","bp");
		board.put("b8","bN"); board.put("b7","bp");
		board.put("c8","bB"); board.put("c7","bp");
		board.put("d8","bQ"); board.put("d7","bp");
		board.put("e8","bK"); board.put("e7","bp");
		board.put("f8","bB"); board.put("f7","bp");
		board.put("g8","bN"); board.put("g7","bp");
		board.put("h8","bR"); board.put("h7","bp");
		
		board.put("a3",""); board.put("b3","");	board.put("c3","");	board.put("d3","");	board.put("e3","");	board.put("f3",""); board.put("g3","");	board.put("h3","");		
		board.put("a4",""); board.put("b4","");	board.put("c4","");	board.put("d4","");	board.put("e4","");	board.put("f4","");	board.put("g4","");	board.put("h4","");	
		board.put("a5","");	board.put("b5","");	board.put("c5","");	board.put("d5","");	board.put("e5","");	board.put("f5","");	board.put("g5","");	board.put("h5","");	
		board.put("a6","");	board.put("b6","");	board.put("c6","");	board.put("d6","");	board.put("e6","");	board.put("f6","");	board.put("g6","");	board.put("h6","");	
	}
	
	public static void printBoard() {
		
		//for (String i : board.keySet()) {
		 // System.out.println(i);
	//	  System.out.println("cell: " + i + " figure: " + board.get(i));			 
	//}
	
	System.out.print(board.get("a8")+ " ");
	System.out.print(board.get("b8")+ " ");
	System.out.print(board.get("c8")+ " ");
	System.out.print(board.get("d8")+ " ");
	System.out.print(board.get("e8")+ " ");
	System.out.print(board.get("f8")+ " ");
	System.out.print(board.get("g8")+ " ");
	System.out.print(board.get("h8")+ " " + "\n");
	System.out.print(board.get("a7")+ " ");
	System.out.print(board.get("b7")+ " ");
	System.out.print(board.get("c7")+ " ");
	System.out.print(board.get("d7")+ " ");
	System.out.print(board.get("e7")+ " ");
	System.out.print(board.get("f7")+ " ");
	System.out.print(board.get("g7")+ " ");
	System.out.print(board.get("h7")+ " ");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.print(board.get("a2")+ " ");
	System.out.print(board.get("b2")+ " ");
	System.out.print(board.get("c2")+ " ");
	System.out.print(board.get("d2")+ " ");
	System.out.print(board.get("e2")+ " ");
	System.out.print(board.get("f2")+ " ");
	System.out.print(board.get("g2")+ " ");
	System.out.print(board.get("h2")+ " " + "\n");	
	System.out.print(board.get("a1")+ " ");	
	System.out.print(board.get("b1")+ " ");
	System.out.print(board.get("c1")+ " ");
	System.out.print(board.get("d1")+ " ");
	System.out.print(board.get("e1")+ " ");
	System.out.print(board.get("f1")+ " ");
	System.out.print(board.get("g1")+ " ");
	System.out.print(board.get("h1")+ " " + "\n"); 
				
	}	
}
