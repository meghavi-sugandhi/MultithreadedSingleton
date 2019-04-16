package com.abc.test;

import org.junit.Test;

import junit.framework.Assert;

public class SingletonTest {
	
	@Test
	public void testGetInstance() {
		MultithreadedSingleton singletonObj1= MultithreadedSingleton.getInstance();
		MultithreadedSingleton singletonObj2 =MultithreadedSingleton.getInstance();
		MultithreadedSingleton singletonObj3= MultithreadedSingleton.getInstance();

		singletonObj1.s =singletonObj1.s.toUpperCase();
		Assert.assertEquals(singletonObj1.s, singletonObj2.s);
		Assert.assertEquals(singletonObj2.s,singletonObj3.s);
		
		singletonObj3.s =singletonObj3.s.toLowerCase();
		Assert.assertEquals(singletonObj1.s, singletonObj2.s);
		Assert.assertEquals(singletonObj2.s,singletonObj3.s);
	}

}
