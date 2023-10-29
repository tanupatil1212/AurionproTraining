package com.aurionpro.model;

public class HotelReception {

	
		public void getIndianMenu() {
			IHotel indianHotel = new IndainHotel();
			
			IMenu indianMenu = indianHotel.getMenu();
			
			indianMenu.displayMenu();
		}
		
		public void getItalainMenu() {
			IHotel italianHotel = new ItalianHotel();
			
			IMenu italianMenu = italianHotel.getMenu();
			
			italianMenu.displayMenu();
		}
}
