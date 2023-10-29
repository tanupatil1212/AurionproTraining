package com.aurionpro.model;

public class PigGame {
	private int turn;
	private int roll_score;
	private int totalTurnScore;
	private int totalGameScore;
	
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getRoll_score() {
		return roll_score;
	}
	public void setRoll_score(int roll_score) {
		this.roll_score = roll_score;
	}
	public int getTotalTurnScore() {
		return totalTurnScore;
	}
	public void setTotalTurnScore(int totalTurnScore) {
		this.totalTurnScore = totalTurnScore;
	}
	@Override
	public String toString() {
		return "LetsPlayPig [turn=" + turn + ", roll_score=" + roll_score + ", totalTurnScore=" + totalTurnScore + "]";
	}
	public int getTotalGameScore() {
		return totalGameScore;
	}
	public void setTotalGameScore(int totalGameScore) {
		this.totalGameScore += totalGameScore;
	}
	

}
