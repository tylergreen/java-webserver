package com.webserver;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


class Dispatcher {

	public static String dispatch(String message) throws Exception{
		if( message.matches("GET /hello HTTP/1.[01]") ) 
			return "Welcome to Tyler's server";
		else if(message.matches("GET /time HTTP/1.[01]") ){
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Thread.sleep(1000);  //what are the implications of sleeping here?
			Date date = new Date();
			return dateFormat.format(date);
		}
		else 
			return "Error no match";
	}


}
