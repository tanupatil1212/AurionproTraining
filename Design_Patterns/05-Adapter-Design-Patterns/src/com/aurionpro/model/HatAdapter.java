package com.aurionpro.model;

public class HatAdapter implements IItems {
	
	private Hat hat;

	public HatAdapter(Hat hat) {
		super();
		this.hat = hat;
	}

	 public String getItemName() {
		  return hat.getShortName()+" "+hat.getLongName();
		 }

		 @Override
		 public double getItemPrice() {
		  return hat.getBasicPrice()+(hat.getTax()*0.01*hat.getBasicPrice());
		 }

		 @Override
		public String toString() {
			return "\nHatAdapter hat=" + hat + "";
		}
		 
}
