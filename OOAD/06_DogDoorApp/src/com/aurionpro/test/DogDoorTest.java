package com.aurionpro.test;

import com.aurionpro.model.DogDoor;
import com.aurionpro.model.Remote;

public class DogDoorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DogDoor door = new DogDoor();
        Remote remote = new Remote(door);

        System.out.println("Fido barks to go outside...");
        remote.pressButton();

        System.out.println("\n Fido has gone outside...");
        remote.pressButton();
        
        System.out.println("\n Fido's all done...");
        remote.pressButton();
        
        System.out.println(" \n Fido's back inside...");
        remote.pressButton();

	}

}
