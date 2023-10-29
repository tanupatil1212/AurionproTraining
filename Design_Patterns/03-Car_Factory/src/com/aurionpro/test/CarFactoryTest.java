package com.aurionpro.test;


import com.aurionpro.model.ICarFactory;
import com.aurionpro.model.ICars;
import com.aurionpro.model.MahindraFactory;
import com.aurionpro.model.MarutiFactory;
import com.aurionpro.model.TataFactory;

public class CarFactoryTest {

	public static void main(String[] args) {
		 ICarFactory marutiCar = MarutiFactory.getMahindraFactoryInstance();

		  ICars maruti = marutiCar.makeCar();

		  maruti.start();
		  maruti.stop();
		  
		  System.out.println("**********");

		  ICarFactory mahindraCar = MahindraFactory.getMahindraFactoryInstance();

		  ICars mahindra = mahindraCar.makeCar();
		  mahindra.start();
		  mahindra.stop();
		  
		  System.out.println("**********");
		  
		  ICarFactory tataCar = TataFactory.getTataFactoryInstance();
		  ICars tata = tataCar.makeCar();
		  
		  tata.start();
		  tata.stop();

		 }

}
