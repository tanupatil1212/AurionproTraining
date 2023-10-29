package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
	
	private List<IItems> cartItems;

	 public ShoppingCart() {
	  this.cartItems = new ArrayList<>();
	 }
	 
	 public void addItemToCart(IItems item) {
	  cartItems.add(item);
	 }
	 
	 public List<IItems> getCartItems() {
	  return cartItems;
	 }
	 
	 public double getCartPrice() {
	  double cartPrice=0;
	  for(IItems x : cartItems) {
	   cartPrice+=x.getItemPrice();
	  }
	  return cartPrice;
	 }





}
