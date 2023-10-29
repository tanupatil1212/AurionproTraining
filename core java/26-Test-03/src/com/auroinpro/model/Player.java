package com.auroinpro.model;

public class Player {
	private int id;
	private String Name;
	private int matches;
	private int runs;
	private int wickets;
	
	

	public Player(int id, String name, int matches, int runs, int wickets) {
		super();
		this.id = id;
		Name = name;
		this.matches = matches;
		this.runs = runs;
		this.wickets = wickets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", Name=" + Name + ", matches=" + matches + ", runs=" + runs + ", wickets="
				+ wickets + "]";
	}
	

}
