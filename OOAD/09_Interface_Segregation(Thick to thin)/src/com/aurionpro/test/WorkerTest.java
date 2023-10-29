package com.aurionpro.test;

import com.aurionpro.model.Loader;
import com.aurionpro.model.Robot;
import com.aurionpro.model.IWorkable;
import com.aurionpro.model.IWorker;

public class WorkerTest {

    public static void main(String[] args) {
        IWorker loader = new Loader();
        loader.start();
        loader.eat();
        loader.rest();
        loader.stop();

        IWorkable robot = new Robot();
        robot.start();
        robot.stop();
    }
}
