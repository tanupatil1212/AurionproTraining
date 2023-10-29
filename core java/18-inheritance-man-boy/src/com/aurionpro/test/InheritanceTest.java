package com.aurionpro.test;

import com.aurionpro.model.Boy;
import com.aurionpro.model.Infant;
import com.aurionpro.model.Kid;
import com.aurionpro.model.Man;



public class InheritanceTest {
	public static void main(String[] args) {
		  case1();
		  System.out.println("****************************");
		  case2();
		  System.out.println("***************************");
		  case3();
		  System.out.println("***************************");
		  case4();
		  System.out.println("***************************");
		  case5();
		  System.out.println("***************************");
		  case6();
		 }
		 //reference and object of parent type
		 private static void case1() {
		  Man man;
		  man=new Man();
		  man.read();
		  man.play();
		 }
		 
		 //reference and object of child type
		  private static void case2() {
		   Boy boy;
		   boy=new Boy();
		   boy.eat();
		   boy.read();
		  }
		  
		  //reference of parent type and object of child type
		  private static void case3() {
		   Man man;   //man reference expects object of MAn or any of
		   man=new Infant();
		   man.read();
		   man.play();
		   //man.sleep();
		  }
		  
		  private static void case4() {
		   PlayAtPark(new Man());
		   PlayAtPark(new Boy());
		   PlayAtPark(new Kid());
		   PlayAtPark(new Infant());
		  }
		  
		  private static void PlayAtPark(Man man) {
		   System.out.println("At the park"); 
		   man.play();
		  }
		  
		  private static void case5() {
		   Object obj;
		   
		   obj=20;
		   System.out.println(obj.getClass().getSimpleName());
		   
		   obj="Java Programming";
		   System.out.println(obj.getClass().getSimpleName());
		   
		   obj=20>40;
		   System.out.println(obj.getClass().getSimpleName());
		  }
		  
		  private static void case6(){
		   typeCastObject(new Infant());//here infant is a object
		  }
		  private static void typeCastObject(Man man) {  //here man is reference
		   if(man instanceof Infant) {
		    Infant infant=(Infant)man;   //type casting
		    infant.sleep();
		   }
		   
		  }
}
