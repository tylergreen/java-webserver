package com.webserver;

class Dispatcher {

	public static String dispatch(String message){
		if( message.matches("GET /hello HTTP/1.[01]") ) 
			return "Welcome to Tyler's server";
		else 
			return "Error no match";
	}


}
