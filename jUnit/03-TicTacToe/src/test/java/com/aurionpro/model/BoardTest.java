package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	private Board board;

	@BeforeEach
	void setUp() {
		board = new Board();
	}

	@Test
	void testGetCell() {
		Cell cell = board.getCell(1, 1);
		assertNotNull(cell);
	}

	@Test
	void testClear() throws CellAlreadyMarkedException {

	    board.getCell(0, 0).setMark(MarkType.X);
//	    System.out.println(board.getCell(0, 0).getMark());
	    board.getCell(1, 1).setMark(MarkType.O);
//	    System.out.println(board.getCell(1, 1).getMark());
	    board.getCell(2, 2).setMark(MarkType.X);
//	    System.out.println(board.getCell(2, 2).getMark());

	    board.clear();

	    for (int row = 0; row < 3; row++) {
	        for (int col = 0; col < 3; col++) {
//	        	 System.out.println(board.getCell(row, col).getMark());
	        	assertTrue(board.getCell(row, col).isEmpty());

	        }
	    }
	}


	@Test
	void testGetCurrentState() throws CellAlreadyMarkedException {

		board.getCell(0, 0).setMark(MarkType.X);
		board.getCell(1, 1).setMark(MarkType.O);

		MarkType[][] currentState = board.getCurrentState();

		assertEquals(MarkType.X, currentState[0][0]);
		assertEquals(MarkType.O, currentState[1][1]);
	}

}
