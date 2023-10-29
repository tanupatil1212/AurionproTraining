package com.aurionpro.model;

public class Board {

	private Cell[][] cells;

    public Board() {
        cells = new Cell[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public void clear() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col].clear();
            }
        }
    }

    public MarkType[][] getCurrentState() {
        MarkType[][] currentState = new MarkType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                currentState[row][col] = cells[row][col].getMark();
            }
        }
        return currentState;
    }

}
