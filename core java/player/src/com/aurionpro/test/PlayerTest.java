package com.aurionpro.test;



import com.aurionpro.model.Player;

public class PlayerTest {
	public static void main(String args[]) {

		Player [] player = {
				 new Player("Tanuja",34,"India",457,3,7),
				 new Player("Sneha",23,"USA",345,6,6),
				 new Player("Divya",24,"London",250,2,8),
				 new Player("Rasika",40,"France",500,3,4)
		};
		
		for (int i = 0; i < player.length; i++) { 
			   System.out.println(player[i]); 
			  }
		System.out.println("********************************************** " );
		

				//System.out.println("Players Details" + player);
		        Player highestruns = findHighestRuns(player);
				System.out.println("Players With Highest Runs : " + highestruns);
				
				System.out.println("********************************************** " );
				
				Player highestHundreads = findPlayersWithMostHUndreds(player);
				System.out.println("Players With hinhest hundreds : " +highestHundreads );
				System.out.println("********************************************** " );
				

				Player mostFifities = findPlayersWithMostFifities(player);
				System.out.println("\nPlayers With Highest Fifites : " +mostFifities);
				System.out.println("********************************************** " );
				
				
				Player youngestAge = sortYoungestPlayerbyAge(player);
				System.out.println("Players With Youngest age : " + youngestAge);
				
				 System.out.println("********************************************** " );
				 
				 Player oldestAge = sortOldestPlayerbyAge(player);
					System.out.println("Players With Oldest age : " + oldestAge);
					
		

		
		}
	//Highest Runs
		private static Player findHighestRuns(Player[] player) {
			Player maxRuns = player[0];

			for (int i = 0; i < player.length; i++) {
				if (player[i].getScored() > maxRuns.getScored()) {
					maxRuns = player[i];
				}
			}
			return maxRuns;
		}
		
		//Players With most HUndreds
		
				private static Player findPlayersWithMostHUndreds(Player[] player) {
					Player maxHundreads = player[0];

					for (int i = 0; i < player.length; i++) {
						if (player[i].getHundreds() > maxHundreads.getHundreds()) {
							maxHundreads = player[i];
						}
					}
					return maxHundreads;
				}
				
				//Players With most Fifties
				
				private static Player findPlayersWithMostFifities(Player[] player) {
					Player maxFifities = player[0];

					for (int i = 0; i < player.length; i++) {
						if (player[i].getFifties() > maxFifities.getFifties()) {
							maxFifities = player[i];
						}
					}
					return maxFifities;
				}
				
				//youngest age
				private static Player sortYoungestPlayerbyAge(Player[] player) {
					Player maxRuns = player[0];

					for (int i = 0; i < player.length; i++) {
						if (player[i].getAge() < maxRuns.getAge()) {
							maxRuns = player[i];
						}
					}
					return maxRuns;
				}
				
//oldest Age
				private static Player sortOldestPlayerbyAge(Player[] player) {
					Player maxRuns = player[0];

					for (int i = 0; i < player.length; i++) {
						if (player[i].getAge() > maxRuns.getAge()) {
							maxRuns = player[i];
						}
					}
					return maxRuns;
				}
				
				
}
