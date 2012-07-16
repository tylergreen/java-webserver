package com.webserver;

import org.junit.*;
import static org.junit.Assert.*;

public class DispatcherTest {

	@Test
	public void testHelloDispatch(){
		String response = Dispatcher.dispatch("GET /hello HTTP/1.1");
		assertEquals("Welcome to Tyler's server", response);
		response = Dispatcher.dispatch("GET /hello HTTP/1.0");		
		assertEquals("Welcome to Tyler's server", response);
	}

	@Test 
	public void testTime(){
		String response = Dispatcher.dispatch("GET /time HTTP/1.1");
		assertEquals("time", response);
	}

	@Test
	public void testForm(){
		String response = Dispatcher.dispatch("GET /form HTTP/1.1");
		assertEquals("<html>form here</html>", response);
	}

	@Test
	public void testFormPost(){
		String response = Dispatcher.dispatch("GET /form HTTP/1.1");
		assertEquals("<html>form response listing</html>", response);
	}

	// need to think about this one
	@Test
	public void testDirectoryList(){
		assertEquals("list of files", Dispatcher.dispatch("GET / HTTP/1.1"));
		assertEquals("list of files", Dispatcher.dispatch("GET / HTTP/1.1"));
	}

	@Test
	public void testImageFileServe(){

	}
	
	@Test
	public void testHTMLFileServe(){

	}

	@Test 
	public void testPDFFileServe(){

	}

	@Test
	public void testOtherFileServe(){

	}

	@Test
	public void testError401(){
		assertEquals("401 page", Dispatcher.dispatch("GARBARGE"));
	}

	@Test
	public void testError404(){
		assertEquals("404 page", Dispatcher.dispatch("GET /something-not-there HTTP/1.1"));
	}
	

}
