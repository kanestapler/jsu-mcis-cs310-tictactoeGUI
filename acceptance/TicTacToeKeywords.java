import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe board = new TicTacToe();
	
	public void startNewGame() {
		board = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		board.setMark(row, col);
	}
	
	public String getMark(int row, int col) {
		if (board.getMark(row, col) == board.X_MARK) {
			return "X";
		} else if (board.getMark(row, col) == board.O_MARK) {
			return "O";
		} else {
			return "EMPTY";
		}
	}
    

	
	public String getWinner() {
		if (board.whoWon() == board.X_MARK) {
			return "X";
		} else if (board.whoWon() == board.O_MARK) {
			return "O";
		} else if (board.isItATie()) {
			return "TIE";
		}else {
			return "EMPTY";
		}
	}
}