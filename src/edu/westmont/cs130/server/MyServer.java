package edu.westmont.cs130.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {

	public static void main(String[] args) {
		
		// Make sure that the program is started correctly
		if (args.length < 1) {
			System.out.println("Usage: MyServer <port>");
			return;
		}
		
		// Collect the parameters from the command line and error check them
		String _port = args[0];
		Integer port = Integer.valueOf(_port);
		if ((port <= 1024) || (port > 9999)) {
			System.out.println("Your port number seems to be out of range (1024 < port < 10000): \"" + _port + "\"");
			return;
		}
		
		//Establish a server
		try(ServerSocket server = new ServerSocket(port)){
			//Create a list of clients that are connected
			ArrayList<ClientHandler> clientList = new ArrayList<ClientHandler>();
			while (true) {
				//Wait for clients to connect
				Socket s = server.accept();
				System.out.println("Client connected...");
				
				//Set up a thread to manage the client
				ClientHandler service = new ClientHandler(s,clientList);
				//Add the client to the list
				clientList.add(service);
				Thread t = new Thread(service);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Something went wrong with the socket");
		}
	}
}
