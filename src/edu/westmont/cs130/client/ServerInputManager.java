package edu.westmont.cs130.client;

import java.util.Scanner;

public class ServerInputManager implements Runnable{


	private Scanner in;
	private String name;

	public ServerInputManager(String userName,Scanner inputFromServer) {
		this.name = userName;
		this.in = inputFromServer;
	}

	@Override
	public void run() {
		while(in.hasNextLine()){
			String incomingMessage = in.nextLine();
			//Exit if this user has sent QUIT and the server responds with appropriate
			// message in response
			if(incomingMessage.equals(this.name+" left the conversation")){
				return;
			}
			else{
				System.out.println(incomingMessage);
			}
		}
	}
		
}
