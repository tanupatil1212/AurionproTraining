package com.aurionpro.model;

public class Players {
	private int id;
	private String name;
	private int matches;
	private int runs;
	private int iwckets;
	
	public Players(int id, String name, int matches, int runs, int iwckets) {
		super();
		this.id = id;
		this.name = name;
		this.matches = matches;
		this.runs = runs;
		this.iwckets = iwckets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getIwckets() {
		return iwckets;
	}

	public void setIwckets(int iwckets) {
		this.iwckets = iwckets;
	}

	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name + ", matches=" + matches + ", runs=" + runs + ", iwckets="
				+ iwckets + "]";
	}
	
	

}
