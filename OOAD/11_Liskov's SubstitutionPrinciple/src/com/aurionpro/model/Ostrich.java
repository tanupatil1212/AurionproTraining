package com.aurionpro.model;

public class Ostrich implements IBird, INonFlyable {
    private String bodyColor;

    public Ostrich(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    @Override
    public String getBodyColor() {
        return bodyColor;
    }

    @Override
    public void walk() {
        System.out.println("Ostrich is walking.");
    }
}
