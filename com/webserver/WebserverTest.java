package com.webserver;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.net.*;

public class WebserverTest {

	private static Thread thread;
	private static Webserver server;
	@BeforeClass 
	public static void beforeAll() throws Exception{
		FileServer fs = new FileServer("com/webserver/test_directory");
		server = new Webserver(9860, fs, true);
		//		thread = new Thread(server);
		//		thread.start();
	}

	@AfterClass
	public static void afterAll() throws Exception{
		server.close();
		thread.interrupt(); 
		
	}

	@Before
	public  void runBeforeEveryTest(){

	}
	
	@After
	public  void runAfterEveryTest(){

	}

	@Test
	public void testSayHello() throws Exception{
		//		assert(True);
	}

	@Test
	public void testSayHi() throws Exception{
		// //		Webserver server = new Webserver(900);
		// Socket clientSocket = new Socket("localhost", 9876);
		// BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		// String response = inFromServer.readLine();
		// assertEquals("Welcome to Tyler's server", response);

		// PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		// out.println("This is the client.  I want my $ back!");
	}

	@Test 
	public void testServerLoops() throws Exception{
		//testSayHi();
		//testSayHi();
	}

	// @Test 
	// public void testHelloReq() throws Exception{
	// 	Socket clientSocket = new Socket("localhost", 9876);
	// 	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	// 	out.println("GET /hello HTTP/1.1");

	// 	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	// 	String response = inFromServer.readLine();
	// 	assertEquals("Welcome to Tyler's server", response);
	// }

	@Test
	public void testDispatch() throws Exception {
		
	}

	@Test 
	public void testStart() throws Exception{ 
		//		assertNotNull(s);
		//		assert(True);
	}

	@Test 
	public void testConnect() throws Exception {
		//		assert(True);
		//
	}

	@Test
	public void testResponseHeader() throws Exception {

	}

	@Test 
	public void test_read_request() throws Exception{
		StringBuffer s = new StringBuffer();
		s.append("GET /hello HTTP/1.1\n");
		s.append("second line\n");
		s.append("third line\n");
		String test_request = s.toString();
		
		InputStream stream = new ByteArrayInputStream(test_request.getBytes());
		BufferedReader mock_client = new BufferedReader(new InputStreamReader(stream));

		String request = server.read_request(mock_client);
		assertEquals(s.toString(), request);
	}

	
}

// javac -classpath .:junit-4.11-SNAPSHOT-20120416-1530.jar ./com/webserver/WebserverTest.java
