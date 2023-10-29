package com.aurionpro.model;

public class Sparrow implements IBird, IFlyable {
    private String bodyColor;

    public Sparrow(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    @Override
    public String getBodyColor() {
        return bodyColor;
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying.");
    }
}
