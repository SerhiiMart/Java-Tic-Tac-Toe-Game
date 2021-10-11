package ticTacToeGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sun.source.tree.WhileLoopTree;

public class TicTacToeGame {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		char [][] gameBoard = {
				{' ','|',' ','|',' '},
				{'—','+','—','+','—'},
				{' ','|',' ','|',' '}, 
				{'—','+','—','+','—'}, 
				{' ','|',' ','|',' '}};	
		 
		 while(true) {
			 Scanner scan = new Scanner(System.in);
			 System.out.println("Please, enter your placement: ");
			 System.out.println("A number from 1 to 9! ");
			 int playerPoss = scan.nextInt();
			 while(playerPositions.contains(playerPoss) || cpuPositions.contains(playerPositions)) {
				 System.out.println("Position already taken. Try another one!");
				 playerPoss = scan.nextInt();
			 }
			 placePiece(gameBoard, playerPoss, "Player");
			 
			 Random rand = new Random();
			 int cpuPoss = rand.nextInt(9) + 1;
			 while(playerPositions.contains(cpuPoss) || cpuPositions.contains(cpuPoss)) {
				 cpuPoss = rand.nextInt(9) + 1;
			 }
			 placePiece(gameBoard, cpuPoss, "Cpu");
			 makeGameBoard(gameBoard);
			 String result = checkWinner();
			 System.out.println(result);
		 }
		
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
			playerPositions.add(poss);
		}else if (user.equals("Cpu")) {
			symbol = 'O';
			cpuPositions.add(poss);
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
	
	public static String checkWinner() {
		List topRow = Arrays.asList(1, 2, 3);
		List middleRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List leftColumn = Arrays.asList(1, 4, 7);
		List middleColumn = Arrays.asList(2, 5, 8);
		List rightColumn = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);
		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(middleRow);
		winningConditions.add(bottomRow);
		winningConditions.add(leftColumn);
		winningConditions.add(middleColumn);
		winningConditions.add(rightColumn);
		winningConditions.add(cross1);
		winningConditions.add(cross2);
		
		for(List l: winningConditions) {
			if (playerPositions.containsAll(l))	{
				return "Congratulations! You Won!";
			} else if (cpuPositions.containsAll(l)) {
				return "Game over. You Lost!";
			} else if(playerPositions.size() + cpuPositions.size() == 9) {
				return "CAT!";
			}
		}
		return "";
	}
}
