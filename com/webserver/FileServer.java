package com.webserver;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class FileServer {

	public String root;
	public String base;
	public FileServer(String path){
		root = path;
		base = System.getProperty("user.dir");
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

	public File get(String file_path) throws Exception{
		File file = new File(root + file_path);
		return file;
	}
}
