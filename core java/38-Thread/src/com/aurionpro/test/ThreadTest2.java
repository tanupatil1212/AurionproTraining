package com.aurionpro.test;

public class ThreadTest2 {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new InnerClass(), "staticThread");
		t1.start();
		
		Runnable runObj = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "Annonymous class");
				
			}
			
			
		};
		Thread t2 = new Thread(runObj,"annoymous Thread");
		t2.start();
		
		Runnable runObj2=()->{
			System.out.println(Thread.currentThread().getName()+"Lambda function");
		};
		Thread t3 = new Thread(runObj2,"labdaThread");
		t3.start();
	}
	private static class InnerClass implements Runnable{
		public void run() {
			System.out.println(Thread.currentThread().getName()+"static inner class");
		}
	}

}
