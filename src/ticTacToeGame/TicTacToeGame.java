package ticTacToeGame;

import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		char [][] gameBoard = {
				{' ','|',' ','|',' '},
				{'—','+','—','+','—'},
				{' ','|',' ','|',' '}, 
				{'—','+','—','+','—'}, 
				{' ','|',' ','|',' '}};	
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Please, enter your placement: ");
		 System.out.println("A number from 1 to 9! ");
		 int poss = scan.nextInt();
		 System.out.println(poss);
		 placePiece(gameBoard, poss, "Player");
		 makeGameBoard(gameBoard);
	}
	public static void makeGameBoard(char [][] gameBoard) {
		for(char[] row: gameBoard ) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void placePiece(char [][] gameBoard, int poss, String user) {
		char symbol = ' ';
		if(user.equals("Player")) {
			symbol = 'X';
		}else if (user.equals("Cpu")) {
			symbol = 'O';
		}
		 switch(poss) {
		 case 1:
			 gameBoard[0][0] = symbol;
			 break;
		 case 2:
			 gameBoard[0][2] = symbol;
			 break;
		 case 3:
			 gameBoard[0][4] = symbol;
			 break;
		 case 4:
			 gameBoard[2][0] = symbol;
			 break;
		 case 5:
			 gameBoard[2][2] = symbol;
			 break;
		 case 6:
			 gameBoard[2][4] = symbol;
			 break;
		 case 7:
			 gameBoard[4][0] = symbol;
			 break;
		 case 8:
			 gameBoard[4][2] = symbol;
			 break;
		 case 9:
			 gameBoard[4][4] = symbol;
			 break;
		 default:
			 break;
		 }
	}
}
