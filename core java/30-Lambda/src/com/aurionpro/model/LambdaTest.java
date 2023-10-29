package com.aurionpro.model;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest {

	public static void main(String[] args) {
		IGreetable obj = new WelcomGreeting();
		obj.printGreeting();

		IGreetable byeObj = new IGreetable() {

			@Override
			public void printGreeting() {
				System.out.println("Good bye");

			}

		};
		byeObj.printGreeting();
		IGreetable goodDayObj = () -> System.out.println("Good day!!");
		goodDayObj.printGreeting();
		
		IGreetable greetObj4=LambdaTest::new;
				greetObj4.printGreeting();
				
//		IGreetable greetObj6=new LambdaTest()::showMesssage;
//		greetObj6.printGreeting();
				
	    //consumer
		Consumer<String> consumer=(name)->{
			System.out.println(name);
		};
				consumer.accept("tanuja");
				
				
				Consumer<Integer> intObj=(x)->{
					System.out.println(x*x);
					
				};
				intObj.accept(10);		
	  
	   //Function
				
		Function<String,Integer> funcObj=(name)->{
			System.out.println("Hello there");
			return name.length();
		};
		System.out.println(funcObj.apply("Sneha"));
		
		Function<String,String> funcObj2=(name)->{
			return name.toLowerCase();
		};
		System.out.println(funcObj2.apply("TajHotel"));
	
		//Predicate
		
		Predicate<String> predicateObj=(string)->{
			return string.length()<=5;
		};
		System.out.println(predicateObj.test("Sonu"));
		System.out.println(predicateObj.test("Surya"));
		
		Predicate<Integer> predicateObj2=(num)->{
			return num % 2 ==0;
		};
		
		System.out.println(predicateObj2.test(100));
		
		//BiFunctional
		BiFunction<Integer ,Integer,Integer> biFunc=(num1,num2)->{
			return num1+num2;
		};
		System.out.println(biFunc.apply(20,30));
	
	}

}
