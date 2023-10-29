package com.aurionpro.model;

public interface IWorker {

    default void startWork() {
        System.out.println("Worker started working.");
    }

    default void stopWork() {
        System.out.println("Worker stopped working.");
    }

    default void eat() {
        System.out.println("Worker is eating.");
    }

    default void drink() {
        System.out.println("Worker is drinking.");
    }
}
