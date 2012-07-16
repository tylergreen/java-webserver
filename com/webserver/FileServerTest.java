package com.webserver;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;

public class FileServerTest {

	private static FileServer fs;

	@BeforeClass
	public static void beforeAll() {
		FileServer fs = new FileServer("com/webserver/test_directory");
	}

	@Test
	public void testOpenFile() throws Exception{
		assertEquals("just simple text", fs.open("/simple.txt"));
	}

	@Test 
	public void testRootListing(){
		String[] files = {"simple.txt", "delta-force.jpg", "webpage.html"};
		assertEquals(files, fs.list("/"));
	}
	
}
