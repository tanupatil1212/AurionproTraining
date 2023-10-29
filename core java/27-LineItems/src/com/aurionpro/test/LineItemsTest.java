package com.aurionpro.test;

import java.util.ArrayList;

import com.aurionpro.model.LineItems;

public class LineItemsTest {

	public static void main(String[] args) {
		ArrayList<LineItems> lineItem = new ArrayList<>();

        // Adding some sample products to the list
		lineItem.add(new LineItems(1, "Product A", 5, 100));
		lineItem.add(new LineItems(2, "Product B", 3, 5));
		lineItem.add(new LineItems(3, "Product C", 2, 70));

        // Calculate and display the total price
        double totalPrice = 0;
        for (LineItems product : lineItem) {
            totalPrice += product.getTotalCost1();
        }

        System.out.println("Products:");
        for (LineItems product : lineItem) {
            System.out.println(product);
        }
        System.out.println("Total Price: " + totalPrice);

	}

}
