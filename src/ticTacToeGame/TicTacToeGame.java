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
		 makeGameBoard(gameBoard);	
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Please, enter your placement: ");
		 System.out.println("A number from 1 to 9! ");
		 scan.nextInt();
	}
	public static void makeGameBoard(char [][] gameBoard) {
		for(char[] row: gameBoard ) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
