package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.aurionpro.model.Customer;
import com.aurionpro.model.LineItem;
import com.aurionpro.model.Order;
import com.aurionpro.model.Product;

public class OOADTest {
	public static void main(String[] args) {

		// Product product = new Product(1, "Product 1", 150.0, 5.0);
		//
		// LineItem lineItem = new LineItem(1, 4, product);
		// Order order = new Order(1, new Date(), Arrays.asList(lineItem));
		// Customer customer = new Customer(1, "Tanuja Patil", Arrays.asList(order));
		//
		//
		// System.out.println("Discounted Price: " +
		// product.calculateDiscountedPrice());
		// System.out.println("Line Item Cost: " + lineItem.calculateLineItemCost());
		// System.out.println("Order Price: " + order.calculateOrderPrice());

		Product product1 = new Product(1, "Chips", 150.0, 0.0);
		Product product2 = new Product(2, "Silk", 180, 10.0);
		LineItem lineItem1 = new LineItem(1, 1, product1);
		LineItem lineItem2 = new LineItem(2, 2, product2);
		
		Order order1 = new Order(1, new Date(), Arrays.asList(lineItem1,lineItem2));

		Customer customer1 = new Customer(1, "Tanuja Patil", Arrays.asList(order1));

		Product product3 = new Product(3, "Product 2", 200.0, 8.0);
		LineItem lineItem3 = new LineItem(3, 3, product3);
		Order order3 = new Order(3, new Date(), Arrays.asList(lineItem3));
		Customer customer2 = new Customer(2, "Rasika patil", Arrays.asList(order3));

		List<Customer> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);

		for (Customer customer : customers) {
			System.out.println("Customer: " + customer.getName());
			for (Order order : customer.getOrders()) {
				System.out.println("Order Date: " + order.getDate());
				for (LineItem item : order.getItems()) {
					System.out.println("  Line Item: " + item.getProduct().getName());
					System.out.println("  Product Price: " + item.getProduct().getPrice());
					System.out.println("  Line Item Cost: " + item.calculateLineItemCost());
				}
				System.out.println("Total Order Price: " + order.calculateOrderPrice());
				System.out.println();
			}
		}
	}

}
