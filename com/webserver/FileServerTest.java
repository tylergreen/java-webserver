package com.webserver;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;

public class FileServerTest {

	private static FileServer fs;

	@BeforeClass
	public static void beforeAll() {
		fs = new FileServer("com/webserver/test_directory");
	}

	@Test
	public void testOpenFile() throws Exception{
		assertEquals("just simple text", fs.open("/simple.txt"));
	}

	@Test 
	public void testRootListing() {
		// maybe should sort
		String[] test_files = {"delta-force.jpg", "simple.txt", "webpage.html"};
		assertArrayEquals(test_files, fs.list("/")); 
	}

	
}
