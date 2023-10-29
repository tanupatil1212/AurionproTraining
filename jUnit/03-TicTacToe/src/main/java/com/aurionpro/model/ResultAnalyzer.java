package com.aurionpro.model;

public class ResultAnalyzer {
	
	 private Board board;
	    private ResultType result;

	    public ResultAnalyzer(Board board) {
	        this.board = board;
	        this.result = ResultType.PROGRESS;
	    }

	    public void analyzeResult() {
	        if (checkWin(MarkType.X) || checkWin(MarkType.O)) {
	            result = ResultType.WIN;
	        } else if (checkDraw()) {
	            result = ResultType.DRAW;
	        } else {
	            result = ResultType.PROGRESS;
	        }
	    }

	    public ResultType getResult() {
	        return result;
	    }

	    private boolean checkWin(MarkType player) {
	        
	        for (int i = 0; i < 3; i++) {
	           
	            if (board.getCell(i, 0).getMark() == player
	                && board.getCell(i, 1).getMark() == player
	                && board.getCell(i, 2).getMark() == player) {
	                return true;
	            }

	            
	            if (board.getCell(0, i).getMark() == player
	                && board.getCell(1, i).getMark() == player
	                && board.getCell(2, i).getMark() == player) {
	                return true;
	            }
	        }

	      
	        if (board.getCell(0, 0).getMark() == player
	            && board.getCell(1, 1).getMark() == player
	            && board.getCell(2, 2).getMark() == player) {
	            return true;
	        }

	        if (board.getCell(0, 2).getMark() == player
	            && board.getCell(1, 1).getMark() == player
	            && board.getCell(2, 0).getMark() == player) {
	            return true;
	        }

	        return false;
	    }

	    private boolean checkDraw() {
	       
	        for (int row = 0; row < 3; row++) {
	            for (int col = 0; col < 3; col++) {
	                if (board.getCell(row, col).isEmpty()) {
	                    return false; 
	                }
	            }
	        }
	        return true; 
	    }

}
