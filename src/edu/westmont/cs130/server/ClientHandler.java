package edu.westmont.cs130.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientHandler implements Runnable{

	private Socket socket;

	public ClientHandler(Socket s){
		this.socket = s;
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
		System.out.println("I was run! "+System.currentTimeMillis());
	}

}
