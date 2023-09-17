package com.java.basic.concurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(3);
		 for (int j = 0; j < 5; j++) {  
	         //creating instance of the Task1 class and pass a value to its constructor   
	         Runnable task = new Task(j);  
	           
	         //executing task using execute() method of the executor  
	         executor.execute(task);  
	       }  
	     //closing executor  
		 executor.shutdown();  
	       
	     while (!executor.isTerminated()) {  
	     }  
	     System.out.println("Finished all threads");  
	}
  

}
class Task implements Runnable{
	int threadNo;
	public Task(int threadNo) {
		this.threadNo=threadNo;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		  System.out.println(Thread.currentThread().getName()+" start execution. Thread No = "+threadNo);  
          
	        //calling processThread() method for processing thread  
	        processThread();  
	          
	        //printing a statement to show the end of the thread  
	        System.out.println(Thread.currentThread().getName()+" stop execution.");  
		
	}
	private void processThread() {
		// TODO Auto-generated method stub
		  try {  
	            Thread.sleep(5000);  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
		
	}
	
	@Override  
    public String toString(){  
        return String.valueOf(this.threadNo);  
    }  
	
}