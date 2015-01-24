package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	@Test
	public void testInitialBoardIsCompletelyEmpty() {
		TicTacToe board = new TicTacToe();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				assertEquals(board.EMPTY, board.getMark(row, col));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe board = new TicTacToe();
		board.setMark(board.TOP_ROW, board.RIGHT_COL);
		assertEquals(board.X_MARK, board.getMark(board.TOP_ROW, board.RIGHT_COL));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToe board = new TicTacToe();
		board.setMarkO(board.BOTTOM_ROW, board.LEFT_COL);
		assertEquals(board.O_MARK, board.getMark(board.BOTTOM_ROW, board.LEFT_COL));
	}
	
	@Test
	public void testMarkXInMiddleAndOInBottomRightCorner() {
		TicTacToe board = new TicTacToe();
		board.setMark(board.MIDDLE_ROW, board.MIDDLE_COL);
		board.setMark(board.BOTTOM_ROW, board.RIGHT_COL);
		if (board.getMark(board.MIDDLE_ROW, board.MIDDLE_COL) == board.X_MARK) {
			if (board.getMark(board.BOTTOM_ROW, board.RIGHT_COL) == board.O_MARK) {
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
		board.setMarkX(board.TOP_ROW, board.LEFT_COL);
		board.setMarkX(board.TOP_ROW, board.MIDDLE_COL);
		if (board.whoWon() != board.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMarkX(board.TOP_ROW, board.RIGHT_COL);
		assertEquals(board.X_MARK, board.whoWon());
	}
	
	@Test
	public void testIfGameIsWonByOOnMiddleColDown() {
		TicTacToe board = new TicTacToe();
		board.setMarkO(board.TOP_ROW, board.MIDDLE_COL);
		board.setMarkO(board.MIDDLE_ROW, board.MIDDLE_COL);
		if (board.whoWon() != board.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMarkO(board.BOTTOM_ROW, board.MIDDLE_COL);
		assertEquals(board.O_MARK, board.whoWon());
	}
	
	@Test
	public void testIfGameIsWonByXDiagonalTopLeftToBottomRight() {
		TicTacToe board = new TicTacToe();
		board.setMarkX(board.TOP_ROW, board.LEFT_COL);
		board.setMarkX(board.MIDDLE_ROW, board.MIDDLE_COL);
		if (board.whoWon() != board.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMarkX(board.BOTTOM_ROW, board.RIGHT_COL);
		assertEquals(board.X_MARK, board.whoWon());
	}
	
	@Test
	public void testIfGameIsTiedAndAllSpacesAreBeingUsed() {
		TicTacToe board = new TicTacToe();
		board.setMark(board.TOP_ROW, board.LEFT_COL);
		board.setMark(board.TOP_ROW, board.RIGHT_COL);
		board.setMark(board.TOP_ROW, board.MIDDLE_COL);
		if (board.whoWon() != board.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMark(board.MIDDLE_ROW, board.LEFT_COL);
		board.setMark(board.MIDDLE_ROW, board.RIGHT_COL);
		board.setMark(board.MIDDLE_ROW, board.MIDDLE_COL);
		if (board.whoWon() != board.EMPTY) {
			assertEquals(0, 2);
		}
		board.setMark(board.BOTTOM_ROW, board.LEFT_COL);
		board.setMark(board.BOTTOM_ROW, board.RIGHT_COL);
		board.setMark(board.BOTTOM_ROW, board.MIDDLE_COL);
		assertTrue(board.isItATie());
	}
	
	@Test
	public void testIfGameIsWonByXDiagonalTopLeftToBottomRightOnLastPossibleMove() {
		TicTacToe board = new TicTacToe();
		board.setMark(board.TOP_ROW, board.LEFT_COL);
		board.setMark(board.TOP_ROW, board.MIDDLE_COL);
		board.setMark(board.TOP_ROW, board.RIGHT_COL);
		if (board.whoWon() != board.EMPTY) {
			assertEquals(0, 1);
		}
		board.setMark(board.MIDDLE_ROW, board.LEFT_COL);
		board.setMark(board.MIDDLE_ROW, board.MIDDLE_COL);
		board.setMark(board.MIDDLE_ROW, board.RIGHT_COL);
		if (board.whoWon() != board.EMPTY) {
			assertEquals(0, 2);
		}
		board.setMark(board.BOTTOM_ROW, board.MIDDLE_COL);
		board.setMark(board.BOTTOM_ROW, board.LEFT_COL);
		board.setMark(board.BOTTOM_ROW, board.RIGHT_COL);
		assertEquals(board.X_MARK, board.whoWon());
	}
	
	@Test
	public void testGettingMarkInTopLeftAndReturningAsAString() {
		TicTacToe board = new TicTacToe();
		board.setMark(board.TOP_ROW, board.LEFT_COL);
		assertEquals("X", board.getMarkInString(board.TOP_ROW, board.LEFT_COL));
	}
}