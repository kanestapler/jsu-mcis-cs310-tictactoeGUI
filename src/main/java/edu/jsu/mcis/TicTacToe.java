package edu.jsu.mcis;

import java.util.Scanner;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;


public class TicTacToe {
    
    public enum Mark {EMPTY, X_MARK, O_MARK, TIE};
	
	public final int ROWS = 0;
	public final int COLS = 0;
	
	private Mark[][] gameBoard = new Mark[3][3];
    
    private JButton[][] buttonTiles = new JButton[3][3];
	
	private Mark turn = Mark.X_MARK;
	
	public TicTacToe() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = Mark.EMPTY;
			}
		}
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonTiles[i][j] = new JButton("");
                buttonTiles[i][j].addActionListener(new ButtonListener(i, j));
                buttonTiles[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttonTiles[i][j].setName("Location" + i + j);
            }
        }
        
	}
	
	public static void main(String[] args) {
        
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3));
        frame.setSize(500,500);
        TicTacToe board = new TicTacToe(); 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                frame.add(board.buttonTiles[i][j]);
            }
        }
        frame.setVisible(true);	
	}
    
    private class ButtonListener implements ActionListener {
        private int row;
        private int col;
        
        public ButtonListener(int i, int j) {
            row = i;
            col = j;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            buttonClicked(row, col);
        }
    }
    
    private void buttonClicked(int row, int col) {
        setMark(row, col);
        setButtonLabel(row, col);
        if (isThereAWinner() == Mark.X_MARK) {
            int delay = 1000;
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "The winner is X", "Game Over", JOptionPane.PLAIN_MESSAGE);
                resetGame();
                }
            };
            Timer myTimer = new Timer(delay, taskPerformer);
            myTimer.setRepeats(false);
            myTimer.start();
        } else if (isThereAWinner() == Mark.O_MARK) {
            int delay = 1000;
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "The winner is O", "Game Over", JOptionPane.PLAIN_MESSAGE);
                resetGame();
                }
            };
            Timer myTimer = new Timer(delay, taskPerformer);
            myTimer.setRepeats(false);
            myTimer.start();
        } else if (isThereAWinner() == Mark.TIE) {
            int delay = 1000;
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "The winner is TIE", "Game Over", JOptionPane.PLAIN_MESSAGE);
                resetGame();
                }
            };
            Timer myTimer = new Timer(delay, taskPerformer);
            myTimer.setRepeats(false);
            myTimer.start();
        } else if (isThereAWinner() == Mark.EMPTY) {
            //No winner yet
        }
    }
    
    private void setButtonLabel(int row, int col) {
        buttonTiles[row][col].setLabel(getMarkInString(row, col));
    }
	
    
    public Mark getTurn() {
        return turn;
    }
    
    public void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                gameBoard[row][col] = Mark.EMPTY;
                setButtonLabel(row, col);
            }
        }
        turn = Mark.X_MARK;
    }
	
	public String getMarkInString(int row, int col) {
		if (getMark(row, col) == Mark.X_MARK) {
			return "X";
		} else if (getMark(row, col) == Mark.O_MARK) {
			return "O";
		} else if (getMark(row, col) == Mark.EMPTY) {
			return " ";
		} else {
			return "BROKEN";
		}
	}
	
	
	
	public Mark getMark(int row, int col) {
		return gameBoard[row][col];
	}
	
	public void setMark(int row, int col) {
		if (gameBoard[row][col] != Mark.EMPTY) {
            
		}else if (turn == Mark.X_MARK) {
			gameBoard[row][col] = Mark.X_MARK;
			turn = Mark.O_MARK;
		} else if (turn == Mark.O_MARK) {
			gameBoard[row][col] = Mark.O_MARK;
			turn = Mark.X_MARK;
		}
	}
	
	public void setMarkX(int row, int col) {
		gameBoard[row][col] = Mark.X_MARK;
	}
	
	public void setMarkO(int row, int col) {
		gameBoard[row][col] = Mark.O_MARK;
	}
	
	public Mark isThereAWinner() {
		for(int row = 0; row < 3; row++) {
			if (isRowAWinner(row)) {
				return gameBoard[row][0];
			}
		}
		
		for (int col = 0; col < 3; col++) {
			if (isColAWinner(col)) {
				return gameBoard[0][col];
			}
		}

		if (isDiagonalAWinner()) {
			return gameBoard[1][1];
		}
        
        if (isItATie()) {
            return Mark.TIE;
        }
        
        return Mark.EMPTY;

	}
	
	private boolean isRowAWinner(int row) {
		if(gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2] && gameBoard[row][0] != Mark.EMPTY) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isColAWinner(int col) {
		if(gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col] && gameBoard[0][col] != Mark.EMPTY) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isDiagonalAWinner() {
		if (gameBoard[0][0] == gameBoard[1][1] && 
		gameBoard[1][1] == gameBoard[2][2] && 
		gameBoard[2][2] != Mark.EMPTY) {
			return true;
		}else if (gameBoard[0][2] == gameBoard[1][1] &&
		gameBoard[1][1] == gameBoard[2][0] &&
		gameBoard[2][0] != Mark.EMPTY) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isItATie() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (gameBoard[row][col] == Mark.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
}