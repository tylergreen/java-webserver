package com.webserver;

import java.io.*;
import java.net.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.logging.*;

class Webserver implements Runnable {
	
	private ServerSocket socket;
	private Dispatcher dispatcher;
	private int port;
	private static Logger log;

	public Webserver(int port, FileServer fs, boolean logging_on) throws Exception {
		socket = new ServerSocket(port);
		dispatcher = new Dispatcher(fs);
		ConsoleHandler handler = new ConsoleHandler();
		log = Logger.getLogger("webserver");
		if(!logging_on){
			log.setUseParentHandlers(false);
			System.out.println("logging off");
		}
		
		
	}

	public String close() throws Exception {
		socket.close();
		return "closed";	
}

	public String read_request(BufferedReader reader) throws Exception{
		StringBuffer string_buffer = new StringBuffer();
		String line;
		while(((line = reader.readLine()) != null) && (!line.equals(""))){
			log.info("read " + line);
			string_buffer.append(line + "\n");
		}
		reader.close();
		return string_buffer.toString();
	}
	
	// should be called listen -- alias
	public void run(){
		while(true){
				try{
					// initiate connection
					log.info("Waiting for connection!!");
					Socket client = socket.accept();
					log.info("Client accepted");

					BufferedReader inFromClient =
						new BufferedReader(new InputStreamReader(client.getInputStream()));
					String request = read_request(inFromClient);
					log.info("Request " + request);

					log.info("Dispatching request...");
					String response = dispatcher.dispatch(request);

					PrintWriter out = new PrintWriter(client.getOutputStream(), true);
					out.println(response);
					// send response to client

					//log.info("Client message " + message);

					// cleanup
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

	//	public String 

	public String sayHello(){
		return "Hello World";
	}

	public String sayHi(String person){
		return "Hi .." + person;
	}

	public static void main(String[] args) throws Exception{
		// improve arg passing 
		// FileServer fs = new FileServer(args[1]);
		// Webserver server = new Webserver(Integer.parseInt(args[0]), fs, true);
		// Thread thread = new Thread(server);
		// thread.start();
	}
}

