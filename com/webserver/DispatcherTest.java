package com.webserver;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DispatcherTest {

	private static Dispatcher dispatcher;
	@BeforeClass
	public static void beforeAll(){
		 dispatcher = new Dispatcher(new FileServer("com/webserver/test_directory"));
	}

	@Test
	public void testHelloDispatch() throws Exception{
		String response = dispatcher.dispatch("GET /hello HTTP/1.1");
		assertEquals("Welcome to Tyler's server", response);
		response = dispatcher.dispatch("GET /hello HTTP/1.0");		
		assertEquals("Welcome to Tyler's server", response);
	}

	@Test 
	public void testTime() throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar =  Calendar.getInstance();
		calendar.add(Calendar.SECOND, 1);
		Date future = calendar.getTime();
		String response = dispatcher.dispatch("GET /time HTTP/1.1");
		Date responseTime = format.parse(response);
		assertEquals(format.format(future), format.format(responseTime));
	}
	

	@Test
	public void testForm() throws Exception{
		String response = dispatcher.dispatch("GET /form HTTP/1.1");
		assertEquals("<html>form here</html>", response);
	}

	@Test
	public void testFormPost() throws Exception{
		String response = dispatcher.dispatch("GET /form HTTP/1.1");
		assertEquals("<html>form response listing</html>", response);
	}

	// need to think about this one
	// need to make these links
	@Test
	public void testDirectoryList() throws Exception{
		assertEquals("[delta-force.jpg, simple.txt, webpage.html]", dispatcher.dispatch("GET / HTTP/1.1"));
	}

	@Test
	public void testTextFileServe() throws Exception{
		assertEquals("just simple text", dispatcher.dispatch("GET /simple.txt HTTP/1.1"));
	}

	@Test
	public void testImageFileServe() {

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
	public void testError401() throws Exception{
		assertEquals("401 page", dispatcher.dispatch("GARBARGE"));
	}

	@Test
	public void testError404() throws Exception{
		assertEquals("404 page", dispatcher.dispatch("GET /something-not-there HTTP/1.1"));
	}

	

}
