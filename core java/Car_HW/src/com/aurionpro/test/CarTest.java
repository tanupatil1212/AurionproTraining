package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Car;

public class CarTest {

	public static void main(String[] args) {
		int n=3;
		
		List<Car> cars = new ArrayList<>();
		
		cars.add(new Car("Toyoto",12, 25000));
		cars.add(new Car("Suzuki",11, 24000));
		cars.add(new Car("Tata",10, 23000));
		
		
		System.out.println("Details of " + n + " cars:");
		for (Car car:cars) {
			System.out.println("Car Company Name"+" "+car.getCompanyName());
			
			
			System.out.println("Car Mileage"+" "+car.getmiledge());
			
			
			System.out.println("Car Price"+" "+car.getPrice());
		}

	}
     

}
