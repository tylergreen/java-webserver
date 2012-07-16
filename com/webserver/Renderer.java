package com.webserver;

import java.util.Scanner;
import java.io.File;

class Renderer {
	public static String form_page() throws Exception{
		FileServer fs = new FileServer("com/webserver/views");
		return fs.open("/form_view.partial");
	}
	
}
