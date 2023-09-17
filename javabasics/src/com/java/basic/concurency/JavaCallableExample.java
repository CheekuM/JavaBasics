package com.java.basic.concurency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class JavaCallableExample {
	public static void main(String[] args) throws Exception{
		FutureTask[] result=new FutureTask[10];
		JavaCallable javaCallable;
		for(int i=0;i<10;i++) {
			javaCallable=new JavaCallable();
			result[i]=new FutureTask<>(javaCallable);
			Thread th=new Thread(result[i]);
			th.start();
		}
		for(int i=0;i<10;i++) {
			Object o=result[i].get();
			System.out.println("Thread Id : "+o);
		}
	}
}
class JavaCallable implements Callable{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		String s=""+Thread.currentThread();
		return s;
	}

}
