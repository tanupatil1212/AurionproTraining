package com.aurionpro.model;

public interface IWorkable {

    default void start() {
        System.out.println("Worker started working.");
    }

    default void stop() {
        System.out.println("Worker stopped working.");
    }
}
