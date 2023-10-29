package com.aurionpro.test;

import com.aurionpro.model.Rectangle;

public class RectangleTest {

    private int curr; 

    public static void main(String[] args) {
        RectangleTest test = new RectangleTest(); 
        test.runTest();
    }

    void runTest() {
        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println(isRectangle(rectangle)); 
    }

    boolean isRectangle(Rectangle obj) {
        System.out.println(obj.getHeight()); 
        int prev = obj.getWidth(); 
        // Changing height
        obj.setHeight(100);
        curr = obj.getWidth(); 
        return prev == curr;
    }
}
