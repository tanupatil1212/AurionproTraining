package com.aurionpro.model;

public interface ILunchInterval {
    default void eat() {
        System.out.println("Worker is eating.");
    }

    default void rest() {
        System.out.println("Worker is resting.");
    }
}
