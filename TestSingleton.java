package com.abc.test;


//Singleton Class
public class TestSingleton {
	private static TestSingleton singletonObject=null;
	
	//volatile so that same value of s should be visible to all threads.
	public volatile String s;

	private TestSingleton() {
		s ="Singleton test";
	}


	//method to get instance of the singleton class. It is synchronized for thread safety
	public static synchronized TestSingleton getInstance() {
		if(singletonObject==null) {
			singletonObject=new TestSingleton();			
		}
		return singletonObject;

	}

	public static void main(String args[]) {
		
		//Code to test single instance of class
		//Created three reference variable each pointing to single object.
		TestSingleton singletonObj1= TestSingleton.getInstance();
		TestSingleton singletonObj2 =TestSingleton.getInstance();
		TestSingleton singletonObj3= TestSingleton.getInstance();

		singletonObj1.s =singletonObj1.s.toUpperCase();
		System.out.println("singletonObj1.s="+singletonObj1.s);
		System.out.println("singletonObj2.s="+singletonObj2.s);
		System.out.println("singletonObj3.s="+singletonObj3.s);		

		singletonObj3.s =singletonObj3.s.toLowerCase();
		System.out.println("singletonObj1.s="+singletonObj1.s);
		System.out.println("singletonObj2.s="+singletonObj2.s);
		System.out.println("singletonObj3.s="+singletonObj3.s);		

		
		

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


final class TestThreads implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + TestSingleton.getInstance().s);
		}
	}

}
