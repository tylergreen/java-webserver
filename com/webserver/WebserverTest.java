package com.webserver;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class WebserverTest{

	@Test
	public void testSayHello(){
		Webserver world = new Webserver();
		assertEquals("Hello World", world.sayHello());
	}

	@Test
	public void testSayHi(){
		Webserver world = new Webserver();
		assertEquals("Hi Tyler...", world.sayHi("Tyler"));
	}
	
}

// javac -classpath .:junit-4.11-SNAPSHOT-20120416-1530.jar ./com/webserver/WebserverTest.java
