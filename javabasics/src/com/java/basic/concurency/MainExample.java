package com.java.basic.concurency;

 
public class MainExample{
	
	public static void main(String[] args) {
		/*2 ways of running the thread
		 *  1. Extending the thread class
		 *  2. Implementing the runnable interface
		 * */  
		/*
		 * Thread is running by extending the Thread Class
		 * 1. Creating the separate class 
		 * 2. Using the Anonymous class 
		 * */
		MultiThreadingExample multiThreadingExample=new MultiThreadingExample();
		multiThreadingExample.start();
		
		Thread thread=new Thread() {
			public void run() {
				System.out.println("Thread is running");
			}
		};
		thread.start();
		
		/*
		 * Creating the thread using Runnable Interface
		 * 1. Creating the Java class and implementing the runnable interface
		 * 2. Creating the anonymous class
		 * 3. Java Lambda expression
		 * */
		// Java Class implementing  the Thread
		RunnableExample runnableExample=new RunnableExample();
		Thread t=new Thread(runnableExample);
		t.start();
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Running Java Anonymous Runnable Class");
				
			}
		};
		Thread t1=new Thread(r);
		t1.start();
		Thread t2=new Thread(() -> { System.out.println("Lambda Runnable running"); });
		System.out.println(t2.getState());
		t2.start();
		System.out.println(t2.getState());
		Thread t4=new Thread(()->{System.out.println("Hello from Daemon");});
		t4.setDaemon(true);
		t4.start();
		
	}
}
class RunnableExample implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Runnable Thread is Running");
		
	}
	
}
class MultiThreadingExample extends Thread{
	public void run() {
		System.out.println("Running Thread id :"+ Thread.currentThread());
	}
}
