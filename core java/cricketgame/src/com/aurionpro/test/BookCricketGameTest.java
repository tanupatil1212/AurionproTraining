package com.aurionpro.test;
import java.util.Scanner;

import com.aurionpro.model.BookCricketGame;


public class BookCricketGameTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookCricketGame player1= new BookCricketGame();
		BookCricketGame player2= new BookCricketGame();
		Scanner userin = new Scanner(System.in);
//		System.out.println(getRandomNumber());
		System.out.println("Player 1 enter your name: ");
		player1.setName(userin.next());
		System.out.println("Player 2 enter your name: ");
//		player1.setPageNumber(1);
		player2.setName(userin.next());
		startGamePlayer1(player1);
		System.out.println("You score "+player1.getScore()+" in "+player1.getTurns()+" turns.");
		startGamePlayer2(player2,player1);
		
		if(player1.getScore()>player2.getScore()) {
			System.out.println("\n"+player1.getName()+" won");
		}
		else if(player1.getScore()==player2.getScore()) {
			if(player1.getTurns()<player2.getTurns()) {
				System.out.println("\n"+player1.getName()+" won");
			}
			else {
				System.out.println("\n"+player2.getName()+" won");
			}
		}
		else {
			System.out.println("\n"+player2.getName()+" won");
		}
	}
	
	private static void startGamePlayer1(BookCricketGame player) {
		int turn=1;
		int score=0;
		int point;
		Scanner userin = new Scanner(System.in);
		System.out.println("Player: "+player.getName());
		System.out.print("Enter 1 to open death note: ");
		int start=userin.nextInt();
		if (start==1) {
			player.setPageNumber(getRandomNumber());
			while(player.getPageNumber()%7!=0 && start==1) {
				System.out.print("page number is "+player.getPageNumber());
				turn++;
				point=player.getPageNumber()%7;
				score+=player.getPageNumber()%7;
				player.setPoints(point);
				player.setScore(score);
				player.setTurns(turn);
				System.out.print("	Point: "+player.getPoints());
				System.out.println("	Score: "+player.getScore());
				player.setPageNumber(getRandomNumber());
				System.out.print("Enter 1 to open death note: ");
				start=userin.nextInt();
			}	
			System.out.print("page number is "+player.getPageNumber());
			System.out.print("	Point: 0");
			System.out.println("	Score: "+player.getScore());
			//System.out.println("You score "+player.getScore()+" in "+player.getTurns()+" turns.");

		}
		
	}
	
	private static void startGamePlayer2(BookCricketGame player,BookCricketGame player1) {
		int turn=player1.getTurns();
		if (turn==0) {
			turn=1;
		}
		int score=0;
		int point;
		boolean win = false;
		Scanner userin = new Scanner(System.in);
		System.out.println("Player: "+player.getName());
		System.out.print("Enter 1 to open death note: ");
		int start=userin.nextInt();
		if (start==1) {
			player.setPageNumber(getRandomNumber());
			while(player.getPageNumber()%7!=0 && start==1 && turn>0 && win==false) {
				System.out.print("page number is "+player.getPageNumber());
				point=player.getPageNumber()%7;
				score+=player.getPageNumber()%7;
				player.setPoints(point);
				player.setScore(score);
				player.setTurns(turn);
				System.out.print("	Point: "+player.getPoints());
				System.out.print("	Score: "+player.getScore());
				System.out.println("	Turns Left: "+(turn-1));
				player.setPageNumber(getRandomNumber());
				if(player.getScore()>player1.getScore()) {
					win=true;
				}
				if (turn-1>0 && win==false) {
				System.out.print("Enter 1 to open death note: ");
				start=userin.nextInt();
				}
				turn--;
				

			}
			if(player.getPageNumber()%7==0) {
				System.out.print("page number is "+player.getPageNumber());
				System.out.print("	Point: 0");
				System.out.print("	Score: "+player.getScore());
				System.out.println("	Turns Left: "+turn);
			}
			System.out.println("You score "+player.getScore()+" with "+turn+" turns left.");

		}
		
	}
	
	public static int getRandomNumber() {
	    return (int) ((Math.random() * (300 - 1)) + 1);
	}

}
