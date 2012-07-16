package com.webserver;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


class Dispatcher {
	private FileServer file_server;

	public Dispatcher(FileServer fs){
		file_server = fs;
	}

	public String dispatch(String message) throws Exception{
		if( match_get_request(message, "/hello"))
			return "Welcome to Tyler's server";
		else if(match_get_request(message, "/time")){
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Thread.sleep(1000);  //what are the implications of sleeping here?
			Date date = new Date();
			return dateFormat.format(date);
		}
		else if (match_get_request(message, "/form")){
			return "<html>put real form here</html>";
		}
		
		else 
			return "Error no match";
	}

	public Boolean match_get_request(String message, String path){
		return message.matches("GET " + path + " HTTP/1.[01]");
	}

}
