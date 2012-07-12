package com.webserver;

import org.junit.*;
import static org.junit.Assert.*;

public class DispatcherTest {

	@Test
	public void testHelloDispatch(){
		String response = Dispatcher.dispatch("GET /hello HTTP/1.1");
		assertEquals("Welcome to Tyler's server", response);
	}

	@Test 
	public void testTime(){
		String response = Dispatcher.dispatch("GET /time HTTP/1.1");
		assertEquals("time", response);
	}

}
