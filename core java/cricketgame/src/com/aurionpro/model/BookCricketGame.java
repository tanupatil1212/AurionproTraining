package com.aurionpro.model;

public class BookCricketGame {
	private String name;
	private int pageNumber;
	private int points;
	private int score;
	private int turns;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "BookCricketGame [name=" + name + ", pageNumber=" + pageNumber + ", points=" + points + ", score="
				+ score + ", turns=" + turns + "]";
	}
	public int getTurns() {
		return turns;
	}
	public void setTurns(int turns) {
		this.turns = turns;
	}
	
	
	

}
