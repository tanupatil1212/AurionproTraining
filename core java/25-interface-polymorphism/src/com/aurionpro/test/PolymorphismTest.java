package com.aurionpro.test;

import com.aurionpro.model.Boy;
import com.aurionpro.model.IEmotionerable;
import com.aurionpro.model.IMannerable;
import com.aurionpro.model.Man;

public class PolymorphismTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Man man = new Man();
		Boy boy = new Boy();

		
		atTheParty(boy);

		// atTheMovies(man);//can not pass man object
		atTheMovies(boy);
		atTheMovies(man);

	}

	private static void atTheMovies(IEmotionerable obj) {
		System.out.println("At the movie hall");
		obj.cry();
		obj.Laugh();
	}

	private static void atTheParty(IMannerable obj) {
		System.out.println("At the party hall");
		obj.wish();
		obj.deport();
	}

}