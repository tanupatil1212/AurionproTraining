package com.aurionpro.test;

import com.aurionpro.model.IBird;
import com.aurionpro.model.IFlyable;
import com.aurionpro.model.INonFlyable;
import com.aurionpro.model.Ostrich;
import com.aurionpro.model.Pigeon;
import com.aurionpro.model.Sparrow;

public class BirdTest {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow("Brown");
        Pigeon pigeon = new Pigeon("Gray");
        Ostrich ostrich = new Ostrich("Black");

        displayBirdInfo(sparrow);
        displayBirdInfo(pigeon);
        displayBirdInfo(ostrich);
    }

    public static void displayBirdInfo(IBird bird) {
        System.out.println("Body color: " + bird.getBodyColor());

        if (bird instanceof IFlyable) {
            ((IFlyable) bird).fly();
        } else if (bird instanceof INonFlyable) {
            ((INonFlyable) bird).walk();
        }
    }
}
