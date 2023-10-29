package com.aurionpro.model;

public class Pigeon implements IBird, IFlyable {
    private String bodyColor;

    public Pigeon(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    @Override
    public String getBodyColor() {
        return bodyColor;
    }

    @Override
    public void fly() {
        System.out.println("Pigeon is flying.");
    }
}
