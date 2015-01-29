package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import edu.jsu.mcis.TicTacToe.Mark;

public class TicTacToeTest {
	@Test
	public void testInitialBoardIsCompletelyEmpty() {
		TicTacToe board = new TicTacToe();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				assertEquals(Mark.EMPTY, board.getMark(row, col));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe board = new TicTacToe();
		board.setMark(0, 2);
		assertEquals(Mark.X_MARK, board.getMark(0, 2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToe board = new TicTacToe();
		board.setMarkO(2, 0);
		assertEquals(Mark.O_MARK, board.getMark(2, 0));
	}
	
	@Test
	public void testMarkXInMiddleAndOInBottomRightCorner() {
		TicTacToe board = new TicTacToe();
		board.setMark(1, 1);
		board.setMark(2, 2);
		if (board.getMark(1, 1) == Mark.X_MARK) {
			if (board.getMark(2, 2) == Mark.O_MARK) {
				assertTrue(true);
			} else {
				assertEquals(0, 1);
			}
		} else {
			assertEquals(0, 2);
		}
	}
	
	@Test
	public void testIfGameIsWonByXOnTopRowAcross() {
		TicTacToe board = new TicTacToe();
		board.setMarkX(0, 0);
		board.setMarkX(0, 1);
		if (board.isThereAWinner() != Mark.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMarkX(0, 2);
		assertEquals(Mark.X_MARK, board.isThereAWinner());
	}
	
	@Test
	public void testIfGameIsWonByOOnMiddleColDown() {
		TicTacToe board = new TicTacToe();
		board.setMarkO(0, 1);
		board.setMarkO(1, 1);
		if (board.isThereAWinner() != Mark.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMarkO(2, 1);
		assertEquals(Mark.O_MARK, board.isThereAWinner());
	}
	
	@Test
	public void testIfGameIsWonByXDiagonalTopLeftToBottomRight() {
		TicTacToe board = new TicTacToe();
		board.setMarkX(0, 0);
		board.setMarkX(1, 1);
		if (board.isThereAWinner() != Mark.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMarkX(2, 2);
		assertEquals(Mark.X_MARK, board.isThereAWinner());
	}
    
    @Test
	public void testIfGameIsWonByODiagonalTopRightToBottomLeft() {
		TicTacToe board = new TicTacToe();
		board.setMarkO(0, 2);
		board.setMarkO(1, 1);
		if (board.isThereAWinner() != Mark.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMarkO(2, 0);
		assertEquals(Mark.O_MARK, board.isThereAWinner());
	}
    
    @Test
    public void testIfMarkingInSameSpotTwiceWorksAsItShould() {
        TicTacToe board = new TicTacToe();
        board.setMark(0,0);
        board.setMark(1,1);
        board.setMark(1,1);
        assertEquals(Mark.X_MARK, board.getTurn());
    }
	
	@Test
	public void testIfGameIsTiedAndAllSpacesAreBeingUsed() {
		TicTacToe board = new TicTacToe();
		board.setMark(0, 0);
		board.setMark(0, 2);
		board.setMark(0, 1);
		if (board.isThereAWinner() != Mark.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMark(1, 0);
		board.setMark(1, 2);
		board.setMark(1, 1);
		if (board.isThereAWinner() != Mark.EMPTY) {
			assertEquals(0, 2);
		}
		board.setMark(2, 0);
		board.setMark(2, 2);
		board.setMark(2, 1);
		assertEquals(Mark.TIE, board.isThereAWinner());
	}
	
	@Test
	public void testIfGameIsWonByXDiagonalTopLeftToBottomRightOnLastPossibleMove() {
		TicTacToe board = new TicTacToe();
		board.setMark(0, 0);
		board.setMark(0, 1);
		board.setMark(0, 2);
		if (board.isThereAWinner() != Mark.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMark(1, 0);
		board.setMark(1, 1);
		board.setMark(1, 2);
		if (board.isThereAWinner() != Mark.EMPTY) {
			assertEquals(0, 2);
		}
		board.setMark(2, 1);
		board.setMark(2, 0);
		board.setMark(2, 2);
		assertEquals(Mark.X_MARK, board.isThereAWinner());
	}
	
	@Test
	public void testGettingMarkInTopLeftAndReturningAsAString() {
		TicTacToe board = new TicTacToe();
		board.setMark(0, 0);
		assertEquals("X", board.getMarkInString(0, 0));
	}
    
    @Test
	public void testGettingMarkInBottomLeftAndReturningAsAString() {
		TicTacToe board = new TicTacToe();
		board.setMarkO(2, 0);
		assertEquals("O", board.getMarkInString(2, 0));
	}
    
    @Test
	public void testGettingMarkThatShouldBeEmptyInMiddleAndReturningAsAString() {
		TicTacToe board = new TicTacToe();
		board.setMark(0, 0);
        board.setMark(2, 2);
		assertEquals(" ", board.getMarkInString(1, 1));
	}
    
    @Test
    public void testXWinsInTopRowAndGameResetsToNewGame() {
        TicTacToe board = new TicTacToe();
        board.setMark(0,0);
        board.setMark(1,1);
        board.setMark(0,1);
        board.setMark(2,2);
        board.setMark(0,2);
        board.resetGame();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getMark(row, col) == Mark.EMPTY) {
                    
                } else {
                    assertEquals(0, 1);
                }
            }
        }
        if (board.getTurn() == Mark.X_MARK) {
            assertTrue(true);
        } else {
            assertEquals(0, 2);
        }
    }
    
    @Test
    public void textResetGameAfterATie() {
        TicTacToe board = new TicTacToe();
        board.setMark(0,0);
        board.setMark(0,1);
        board.setMark(0,2);
        board.setMark(1,1);
        board.setMark(1,0);
        board.setMark(1,2);
        board.setMark(2,1);
        board.setMark(2,0);
        board.setMark(2,2);
        board.resetGame();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getMark(row, col) == Mark.EMPTY) {
                    
                } else {
                    assertEquals(0, 1);
                }
            }
        }
        if (board.getTurn() == Mark.X_MARK) {
            assertTrue(true);
        } else {
            assertEquals(0, 2);
        }
    }
}