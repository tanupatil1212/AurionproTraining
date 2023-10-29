package com.auroinpro.test;

import com.auroinpro.model.ClassifyPlayers;
import com.auroinpro.model.Player;


public class ClassifyPlayersTest {
	public static void main(String[] args) {
		  Player[] player = {new Player(1, "Ram", 1000, 10000, 10),
		    new Player(2, "Sita", 120, 122, 34),
		    new Player(3, "Laxman", 130, 139, 12),};
		  
		  Player[] alist = ClassifyPlayers.getALister(player);
		  for (int i = 0; i < alist.length; i++) {
		   System.out.println(alist[i]);
		  }
		//  ClassifyPlayer.getBLister(player);
		//  ClassifyPlayer.getCLister(player);
		 }
	
	
				
				
	}


