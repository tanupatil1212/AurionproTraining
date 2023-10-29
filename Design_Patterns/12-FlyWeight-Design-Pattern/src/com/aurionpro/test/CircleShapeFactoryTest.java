package com.aurionpro.test;

import com.aurionpro.model.CircleShapeFactory;
import com.aurionpro.model.IShape;

public class CircleShapeFactoryTest {

	public static void main(String[] args) {
		CircleShapeFactory factory = new CircleShapeFactory();

        String[] colors = {"blue", "green", "red", "blue", "yellow", "blue", "red"};

        for (String color : colors) {
            IShape circle = factory.getCircle(color);
            circle.draw();
        }
	}

}
