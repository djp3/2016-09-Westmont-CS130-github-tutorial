package edu.westmont.cs130.client;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserInputManager implements Runnable{

	private PrintWriter out;

	public UserInputManager(PrintWriter out) {
		this.out = out;
	}
	
	public void run(){
		try(Scanner incomingFromUser = new Scanner(new InputStreamReader(System.in))){
			String message = "";
			System.out.print("Enter your chat messages: ");
			while((!message.equals("QUIT")) && incomingFromUser.hasNext()){
				message = incomingFromUser.nextLine();
				out.println(message);
				out.flush();
			}
		}
	}
}
