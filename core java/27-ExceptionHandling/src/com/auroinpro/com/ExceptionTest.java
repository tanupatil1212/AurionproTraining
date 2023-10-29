package com.auroinpro.com;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			int firstNumber=Integer.parseInt(args[0]);
			System.out.println("Statment 1");
			int secNumber=Integer.parseInt(args[1]);
			System.out.println("Statment 2");
			int div=firstNumber/secNumber;
			System.out.println("Division " + div);
			
		}
		catch(ArithmeticException e) {
			System.out.println("Number Can not be Divded by zero");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Access to invalid index position");
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid conversation to type Integer");
		}
		catch(RuntimeException e) {
			System.out.println("Invalid conversation to type Integer");
		}
		catch(Exception e) {
			System.out.println("Invalid conversation to type Integer");
		}
		
		finally {
			System.out.println("Inside finally");
		
			
		}
		
		System.out.println("Outside try catch ,end of code");
		
		
		
	}
	

}
