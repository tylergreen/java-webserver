package com.webserver;

import java.io.*;
import java.net.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.logging.*;

class Webserver implements Runnable {
	
	private ServerSocket socket;
	private int port;
	private static Logger log;

	public Webserver(int port, boolean logging_on) throws Exception {
		socket = new ServerSocket(port);

		ConsoleHandler handler = new ConsoleHandler();
		log = Logger.getLogger("webserver");
		if(!logging_on){
			log.setUseParentHandlers(false);
			System.out.println("logging off");
			//log.addHandler(handler);
		}
	}

	public String close() throws Exception {
		socket.close();
		return "closed";
	}

	public void run(){
		while(true){
				try{
					log.info("Waiting for connection");
					Socket client = socket.accept();
					log.info("Client accepted");
					PrintWriter out = new PrintWriter(client.getOutputStream(), true);
					out.println("Welcome to Tyler's server\n");

					BufferedReader inFromClient =
						new BufferedReader(new InputStreamReader(client.getInputStream()));

					String message = inFromClient.readLine();
					log.info("Client message " + message);
					
					log.info("Closing connection");
					out.close();
					client.close();
				}
				catch(Exception e) {
					log.severe("error " + e);
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

