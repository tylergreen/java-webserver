package com.webserver;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class FileServer {

	public String root;
	public FileServer(String path){
		root = path;
	}

	public String[] list(String path){
		File f = new File(root + path);
		return f.list();
	}

	public String open(String file_path) throws Exception{
		File file = new File(root + file_path);

		String contents = new Scanner(file).useDelimiter("\\Z").next();
		return contents;
	}
}
