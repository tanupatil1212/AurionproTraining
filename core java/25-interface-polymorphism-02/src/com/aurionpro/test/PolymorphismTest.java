package com.aurionpro.test;

import com.aurionpro.model.Car;

import com.aurionpro.model.IMovable;
import com.aurionpro.model.Vehicle;

import java.time.LocalDate;
import com.aurionpro.model.Bike;
import com.aurionpro.model.Bus;

public class PolymorphismTest {

	public static void main(String[] args) {
		IMovable[] imovables = { new Bike("Honda",LocalDate.of(2023, 2, 2)),
				new Bike("Suzuki",LocalDate.of(2023, 2, 3)),};
				
				for (IMovable x : imovables) {
					startMoving(x);
				}
				
		}
		public static void startMoving(IMovable y) {
			System.out.println(y);
			Vehicle obj =(Vehicle)y;
			obj.showTopSpeed();
		}
		
	
	}

