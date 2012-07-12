package com.webserver;

import java.io.*;
import java.net.*;
import java.net.Socket;
import java.net.ServerSocket;


class Webserver implements Runnable {
	
	public ServerSocket socket;
	public int port;

	public Webserver(int port) throws Exception {
		socket = new ServerSocket(port);
			//			int i = 1 / 0;o
	}

	//	public void listen() throws Exception

	public String close() throws Exception {
		socket.close();
		return "closed";
	}

	public void run(){
		while(true){
				try{
					
					System.out.println("Waiting for connection");
					Socket client = socket.accept();
					System.out.println("Client accepted");
					PrintWriter out = new PrintWriter(client.getOutputStream(), true);
					out.println("Welcome to Tyler's server\n");
					
					System.out.println("Closing everything");
					out.close();
					client.close();
				}
				catch(Exception e) {
					System.out.println("error " + e);
					break;
				}
		}
	}



	public String sayHello(){
		return "Hello World";
	}

	public String sayHi(String person){
		return "Hi .." + person;
	}
}

