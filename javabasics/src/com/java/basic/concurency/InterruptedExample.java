package com.java.basic.concurency;

public class InterruptedExample {
	public static void main(String[] args) throws InterruptedException{
		InterruptedThread thread=new InterruptedThread();
		thread.start();
		thread.interrupt();
		NonInterrruptedThread thread2=new NonInterrruptedThread();
		System.out.println("Thread 2 is interrupted : "+thread2.isInterrupted());
		thread2.start();
		thread2.interrupt();
		System.out.println("Thread 2 is interrupted : "+thread2.isInterrupted());
	}
}

class InterruptedThread extends Thread{
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				System.out.println("Child Thread Executing .. ");
				Thread.sleep(10000);
			}
			
		}catch(InterruptedException e) {
			System.out.println("Thread 1: Interrupted Exception Occurs");
			throw new RuntimeException("Thread 1: Interrupted");
		}
	}
}
class NonInterrruptedThread extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread printing"+i);
		}
	}
}