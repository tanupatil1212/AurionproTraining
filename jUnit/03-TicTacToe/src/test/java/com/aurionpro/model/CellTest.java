package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	
	private Cell cell;

    @BeforeEach
    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(cell.isEmpty());
    }

    @Test
    public void testGetMark() {
        assertEquals(MarkType.EMPTY, cell.getMark());
    }

    @Test
    public void testSetMark() throws CellAlreadyMarkedException {
        cell.setMark(MarkType.X);
        assertEquals(MarkType.X, cell.getMark());
    }

    @Test
    public void testSetMarkAlreadyMarked() throws CellAlreadyMarkedException {
        cell.setMark(MarkType.X);
        assertThrows(CellAlreadyMarkedException.class, () -> cell.setMark(MarkType.O));
    }

    @Test
    public void testClear() throws CellAlreadyMarkedException {
        cell.setMark(MarkType.X);
        cell.clear();
        assertEquals(MarkType.EMPTY, cell.getMark());
    }

}
