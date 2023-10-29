package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class ClassifyPlayers extends Players {
	public ClassifyPlayers(int id, String name, int matches, int runs, int iwckets) {
		super(id, name, matches, runs, iwckets);
		// TODO Auto-generated constructor stub
	}


	public static List<Players> getAListers(Players[] player) {
		List<Players> ALister = new ArrayList<>();
		for (int i=0; i < player.length; i++) {
			if (player[i].getMatches() > 100 && (player[i].getRuns() > 5000 || player[i].getIwckets() > 150)) {
				ALister.add(player[i]);
			}
		}
		return ALister;
	}

	public static List<Players> getBListers(Players[] player) {
		List<Players> BListers= new ArrayList<>();
		for (int i=0,j = 0; i < player.length; i++) {
			if ((player[i].getMatches() > 50 && player[i].getMatches()<100) && ((player[i].getRuns() > 3000 && player[i].getRuns() < 5000)
					|| (player[i].getIwckets() > 75 && player[i].getIwckets() < 150))) {
				BListers.add(player[i]);
			}
		}
		return BListers;
		
	}

	public static List<Players> getCListers(Players[] player) {
		List<Players> CListers =new ArrayList<Players>();
		for (int i=0,j = 0; i < player.length; i++) {
			if (player[i].getMatches() < 50 && (player[i].getRuns() < 3000 || player[i].getIwckets() < 75)) {
				CListers.add(player[i]);
			}
		}
		return CListers;
		
	}

}
