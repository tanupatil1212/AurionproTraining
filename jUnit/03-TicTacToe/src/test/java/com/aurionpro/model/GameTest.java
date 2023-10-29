package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

	// @Test
	// void test() {
	// fail("Not yet implemented");
	// }

	private Player player1;
	private Player player2;
	private Game game;

	@BeforeEach
	public void setUp() {
		
		player1 = new Player("Player 1", MarkType.X);
		player2 = new Player("Player 2", MarkType.O);
		game = new Game(player1, player2);
	}

	@Test
	public void testInitialCurrentPlayer() {

		assertEquals(player1, game.getCurrentPlayer());
	}

	@Test
	public void testSwitchPlayer() {

		game.makeMove(0, 0);
		assertEquals(player2, game.getCurrentPlayer());
		game.makeMove(0, 1);
		assertEquals(player1, game.getCurrentPlayer());
	}

	@Test
	public void testMakeValidMove() {

		assertTrue(game.makeMove(0, 0));
	}

	@Test
	public void testMakeInvalidMove() {
		assertTrue(game.makeMove(0, 0));
		assertFalse(game.makeMove(0, 0));
		assertTrue(game.makeMove(0, 1));
	}

}
