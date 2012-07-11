package com.webserver;

class Webserver{

	public String sayHello(){
		return "Hello World";
	}

	public void printHello(){
		System.out.println(sayHello());
	}

	public String sayHi(String person){
		return "Hi " + person;
	}
}

// javac -classpath .:junit-4.11-SNAPSHOT-20120416-1530.jar ./com/webserver/Webserver.java 
