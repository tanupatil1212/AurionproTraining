package com.aurionpro.test;

import com.aurionpro.model.Labour;
import com.aurionpro.model.Robot;
import com.aurionpro.model.IWorker;

public class IWorkerTest {

    public static void main(String[] args) {
        IWorker labour = new Labour();
        labour.startWork();
        labour.eat();
        labour.drink();
        labour.stopWork();

        IWorker robot = new Robot();
        robot.startWork();
        robot.stopWork();
    }
}
