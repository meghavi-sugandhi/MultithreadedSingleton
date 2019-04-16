package com.abc.test;
import org.junit.Test;

import junit.framework.Assert;

//Singleton Class
public class MultithreadedSingleton {

	private static MultithreadedSingleton singletonObject=null;

	//volatile so that same value of s should be visible to all threads.
	public volatile String s;

	private MultithreadedSingleton() {
		s ="Singleton test";
	}


	//method to get instance of the singleton class. It is synchronized for thread safety
	public static synchronized MultithreadedSingleton getInstance() {
		if(singletonObject==null) {
			singletonObject=new MultithreadedSingleton();			
		}
		return singletonObject;

	}


	public static void main(String args[]) {

		//Created multiple threads of Runnable class TestThreads 
		Thread t1 = new Thread(new TestThreads());
		Thread t2 = new Thread(new TestThreads()); 
		Thread t3 = new Thread(new TestThreads()); 
		Thread t4 = new Thread(new TestThreads());
		Thread t5 = new Thread(new TestThreads());

		System.out.println("Multiple threads using singleton instance concurrently");
		t1.setName("Thread A"); 
		t2.setName("Thread B"); 
		t3.setName("Thread C");
		t4.setName("Thread D"); 
		t5.setName("Thread E"); 
		t1.setName("Thread F");
		t1.start(); 
		t2.start(); 
		t3.start(); 
		t4.start(); 
		t5.start(); 
	}


}


class TestThreads implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + MultithreadedSingleton.getInstance().s);
		}
	}

}



