package com.aurionpro.test;
import com.aurionpro.model.*;

public class DistanceTest {
	public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  

		 
		Distance d1 = new Distance(10,6);
		Distance d2= new Distance(6,7);
		Distance d3 =  d1.addDistance(d2);
		System.out.println(d3);
		
		
		
	}

}
