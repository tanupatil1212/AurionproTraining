package com.auroinpro.model;

import com.auroinpro.model.Player;

public class ClassifyPlayers  {

	public static Player[] getALister(Player[] player) {

		  int count = 0;

		  for (Player p : player) {
		   if (p.getMatches() > 100 && (p.getRuns() > 5000 || p.getWickets() > 150)) {
		    count++;
		   }
		  }
		  Player[] aListers = new Player[count];
		  for (int i = 0, j = 0; i < player.length; i++) {
		   if ((player[i].getMatches() > 100) && (player[i].getRuns() > 5000 || player[i].getWickets() > 150)) {
		    aListers[j++] = player[i];
		   }
		  }
		  return aListers;
		 }
}
