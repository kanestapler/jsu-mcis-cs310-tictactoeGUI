package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToe {
	public final int EMPTY = 0;
	public final int X_MARK = 1;
	public final int O_MARK = 2;
	
	public final int TOP_ROW = 0;
	public final int MIDDLE_ROW = 1;
	public final int BOTTOM_ROW = 2;
	
	public final int LEFT_COL = 0;
	public final int MIDDLE_COL = 1;
	public final int RIGHT_COL = 2;
	
	private int[][] gameBoard = new int[3][3];
	
	private int turn = X_MARK;
	
	public TicTacToe() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = EMPTY;
			}
		}
	}
	
	public static void main(String[] args) {
		
		TicTacToe board = new TicTacToe();
		
		Scanner input = new Scanner(System.in);
		
		int userInputRow;
		int userInputCol;
		
		System.out.println("Welcome to Ricky's Tic Tac Toe");
		
		
		while (board.whoWon() == board.EMPTY && !board.isItATie()) {
			userInputRow = -1;
			userInputCol = -1;
			while (userInputRow > 2 || userInputRow < 0) {
				userInputRow = board.getRowFromUser();
			}
			while (userInputCol > 2 || userInputCol < 0) {
				userInputCol = board.getColFromUser();
			}
			board.setMark(userInputRow, userInputCol);
			
			
		}
		
		board.printOutGameResult();
		
		
	}
	
	public void printOutGameResult() {
		if (whoWon() == X_MARK) {
			System.out.println("X Wins!");
		} else if (whoWon() == O_MARK) {
			System.out.println("O Wins!");
		} else if (isItATie()) {
			System.out.println("It's a tie!");
		} else {
			System.out.println("Print out Results Broken");
		}
		
		printGameBoard();
	}
	
	public void printGameBoard() {
		System.out.println();
		printTopRow();
		printDividingLine();
		printMiddleRow();
		printDividingLine();
		printBottomRow();
		System.out.println();
	}
	
	public void printTopRow() {
		System.out.println("   " + getMarkInString(TOP_ROW, LEFT_COL) +"|"+ getMarkInString(TOP_ROW, MIDDLE_COL) +"|" + getMarkInString(TOP_ROW, RIGHT_COL));
	}
	
	public void printMiddleRow() {
		System.out.println("   " + getMarkInString(MIDDLE_ROW, LEFT_COL) +"|"+ getMarkInString(MIDDLE_ROW, MIDDLE_COL) +"|" + getMarkInString(MIDDLE_ROW, RIGHT_COL));
	}
	
	public void printBottomRow() {
		System.out.println("   " + getMarkInString(BOTTOM_ROW, LEFT_COL) +"|"+ getMarkInString(BOTTOM_ROW, MIDDLE_COL) +"|" + getMarkInString(BOTTOM_ROW, RIGHT_COL));
	}
	
	public void printDividingLine() {
		System.out.println("   -----");
	}
	
	public String getMarkInString(int row, int col) {
		if (getMark(row, col) == X_MARK) {
			return "X";
		} else if (getMark(row, col) == O_MARK) {
			return "O";
		} else if (getMark(row, col) == EMPTY) {
			return " ";
		} else {
			return "BROKEN";
		}
	}
	
	public int getRowFromUser() {
		Scanner input = new Scanner(System.in);
		
		if (turn == X_MARK) {
			System.out.println("");
			System.out.println("X please enter a row (0-2)");
			return input.nextInt();
		} else if (turn == O_MARK) {
			System.out.println("");
			System.out.println("O please enter a row (0-2)");
			return input.nextInt();
		} else {
			System.out.println("You broke the turn function");
			return -1;
		}
	}
	
	public int getColFromUser() {
		Scanner input = new Scanner(System.in);
		
		if (turn == X_MARK) {
			System.out.println("");
			System.out.println("X please enter a col (0-2)");
			return input.nextInt();
		} else if (turn == O_MARK) {
			System.out.println("");
			System.out.println("O please enter a col (0-2)");
			return input.nextInt();
		} else {
			System.out.println("You broke the turn function");
			return -1;
		}
	}
	
	public int getMark(int row, int col) {
		return gameBoard[row][col];
	}
	
	public void setMark(int row, int col) {
		if (gameBoard[row][col] != EMPTY) {
			System.out.println("That space is not empty");
		}else if (turn == X_MARK) {
			gameBoard[row][col] = X_MARK;
			turn = O_MARK;
		} else if (turn == O_MARK) {
			gameBoard[row][col] = O_MARK;
			turn = X_MARK;
		}
		printGameBoard();
	}
	
	public void setMarkX(int row, int col) {
		gameBoard[row][col] = X_MARK;
	}
	
	public void setMarkO(int row, int col) {
		gameBoard[row][col] = O_MARK;
	}
	
	public int whoWon() {
		for(int row = 0; row < 3; row++) {
			if (isRowAWinner(row)) {
				return gameBoard[row][LEFT_COL];
			}
		}
		
		for (int col = 0; col < 3; col++) {
			if (isColAWinner(col)) {
				return gameBoard[TOP_ROW][col];
			}
		}

		if (isDiagonalAWinner()) {
			return gameBoard[MIDDLE_ROW][MIDDLE_COL];
		}

		
		return EMPTY;
	}
	
	private boolean isRowAWinner(int row) {
		if(gameBoard[row][LEFT_COL] == gameBoard[row][MIDDLE_COL] && gameBoard[row][MIDDLE_COL] == gameBoard[row][RIGHT_COL] && gameBoard[row][LEFT_COL] != EMPTY) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isColAWinner(int col) {
		if(gameBoard[TOP_ROW][col] == gameBoard[MIDDLE_ROW][col] && gameBoard[MIDDLE_ROW][col] == gameBoard[BOTTOM_ROW][col] && gameBoard[TOP_ROW][col] != EMPTY) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isDiagonalAWinner() {
		if (gameBoard[TOP_ROW][LEFT_COL] == gameBoard[MIDDLE_ROW][MIDDLE_COL] && 
		gameBoard[MIDDLE_ROW][MIDDLE_COL] == gameBoard[BOTTOM_ROW][RIGHT_COL] && 
		gameBoard[BOTTOM_ROW][RIGHT_COL] != EMPTY) {
			return true;
		}else if (gameBoard[TOP_ROW][RIGHT_COL] == gameBoard[MIDDLE_ROW][MIDDLE_COL] &&
		gameBoard[MIDDLE_ROW][MIDDLE_COL] == gameBoard[BOTTOM_ROW][LEFT_COL] &&
		gameBoard[BOTTOM_ROW][LEFT_COL] != EMPTY) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isItATie() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (gameBoard[row][col] == EMPTY) {
					return false;
				}
			}
		}
		if (whoWon() == X_MARK) {
			return false;
		} else if (whoWon() == O_MARK) {
			return false;
		} else {
			return true;
		}
		
	}
}