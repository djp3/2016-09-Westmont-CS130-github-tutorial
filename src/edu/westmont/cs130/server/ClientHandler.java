package edu.westmont.cs130.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientHandler implements Runnable{

	public ClientHandler(Socket s,List<ClientHandler> others) throws IOException {
	}
	
	/**
	 * Use this method to output a message to the client that is managed by this
	 *  object
	 * @param sender
	 * @param message
	 */
	public void sendMessage(String sender,String message){
	}

	@Override
	public void run() {
	}

}
