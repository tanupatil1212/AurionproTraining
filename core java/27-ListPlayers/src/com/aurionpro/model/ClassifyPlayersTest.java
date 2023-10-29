package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class ClassifyPlayersTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Players[] player = {
				new ClassifyPlayers(1, "Ved", 200, 6000, 200),
				new ClassifyPlayers(2, "dang", 49, 2500, 65),
				new ClassifyPlayers(3, "asis", 90, 6000, 200),
				new ClassifyPlayers(4, "ban", 10, 6000, 200),
				new ClassifyPlayers(5, "tan", 20, 6000, 200),
				new ClassifyPlayers(6, "can", 300, 6000, 200),
				new ClassifyPlayers(7, "van", 300, 6000, 76),
				new ClassifyPlayers(8, "fan", 60, 6000, 76),

				
		};
		List<Players> Aresults= new ArrayList<Players>();
		Aresults = 	ClassifyPlayers.getAListers(player);
		for (int i = 0; i < Aresults.size(); i++) {
			System.out.println(Aresults.get(i));
		}
		System.out.println("====================");
		List<Players> Bresults= new ArrayList<Players>();
		Bresults = 	ClassifyPlayers.getBListers(player);
		for (int i = 0; i < Bresults.size(); i++) {
			System.out.println(Bresults.get(i));
		}
		System.out.println("====================");
		List<Players> Cresults= new ArrayList<Players>();
		Cresults = 	ClassifyPlayers.getCListers(player);
		for (int i = 0; i < Cresults.size(); i++) {
			System.out.println(Cresults.get(i));
		}
	}

}
