package com.webserver;

import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


class Dispatcher {
	private FileServer file_server;

	public Dispatcher(FileServer fs){
		file_server = fs;
	}

	public String dispatch(String message) throws Exception{
		if(message.split(" ")[0].equals("GET"))
			return handle_get_request(get_path(message));
		else if (message.split(" ")[0].equals("POST"))
			return "not handled yet";
		else
			return "error";
	}

	public String handle_get_request(String path) throws Exception{
		if( path.matches("/hello"))
			return "Welcome to Tyler's server";
		else if(path.matches("/time")){
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Thread.sleep(1000);  //what are the implications of sleeping here?
			Date date = new Date();
			return dateFormat.format(date);
		}
		else if (path.matches("/form")){
			return "<html>put real form here</html>";
		}
		else if (file_server.isFile(path)){
			return file_server.open(path);
		}
		else if (file_server.isDirectory(path)){
			return Arrays.toString(file_server.list(path));
		}
		
		else 
			return "Error no match -- GET";
	}

	public Boolean match_get_request(String message, String path){
		return message.matches("GET " + path + " HTTP/1.[01]");
	}

	public String get_path(String message){
		return message.split(" ")[1];
	}

}
