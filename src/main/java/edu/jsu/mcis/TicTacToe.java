package edu.jsu.mcis;

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
	
	public TicTacToe() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = EMPTY;
			}
		}
	}
	
	public int getMark(int row, int col) {
		return gameBoard[row][col];
	}
	
	public void setMarkX(int row, int col) {
		gameBoard[row][col] = X_MARK;
	}
	
	public void setMarkO(int row, int col) {
		gameBoard[row][col] = O_MARK;
	}
	
	public boolean hasThisPersonWon(int mark) {
		//Check all vertical possibilities
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (gameBoard[row][col] != mark) {
					col = 4;
				} else if (col == 2) {
					return true;
				}
			}
		}
		//Check all horizontal possibilities
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				if (gameBoard[row][col] != mark) {
					row = 4;
				} else if (row == 2) {
					return true;
				}
			}
		}
		//Check Diagonal possibilities
		if (gameBoard[0][0] == mark && gameBoard[1][1] == mark && gameBoard[2][2] == mark) {
			return true;
		}
		if (gameBoard[0][2] == mark && gameBoard[1][1] == mark && gameBoard[2][0] == mark) {
			return true;
		}
		
		return false;
	}
	
	public boolean isItATie() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (gameBoard[row][col] == EMPTY) {
					return false;
				}
			}
		}
		if (hasThisPersonWon(X_MARK)) {
			return false;
		}else if (hasThisPersonWon(O_MARK)) {
			return false;
		}else {
			return true;
		}
	}
}