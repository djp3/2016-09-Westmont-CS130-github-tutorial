package edu.westmont.cs130.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) {

		// Make sure that the program is started correctly
		if((args.length < 3)||(args.length >3)){
			System.out.println("Usage: MyClient <name> <ipaddress> <port>");
			return;
		}
		
		// Collect the parameters from the command line and error check them
		String name = args[0];
		String ipAddress = args[1];
		String _port = args[2];
		Integer port = Integer.valueOf(_port);
		if((port <= 1024) || (port > 9999)){
			System.out.println("Your port number seems to be out of range (1024 < port < 10000): \""+_port+"\"");
			return;
		}
			//Establish a socket connection to the server
		PrintWriter out;
		Scanner in;
		System.out.println("Establishing connection to "+ipAddress+":"+port);
		try(Socket s = new Socket(ipAddress,port)){
			//Set up input from and output to server
			out = new PrintWriter(s.getOutputStream());
			in = new Scanner(s.getInputStream());
			
			System.out.println("\t...connected.");
					
			//Execute our protocol which is to join by sending our name
			out.println(name);
			out.flush();
			/*
					
			//Set up one thread to listen for messages from the user to send to server
			UserInputManager ms = new UserInputManager(out);
			Thread t1 = new Thread(ms);
			t1.start();
					
			//Set up one thread to receive messages from the server
			ServerInputManager mr = new ServerInputManager(name,in);
			Thread t2 = new Thread(mr);
			t2.start();
					
			//Wait in a loop until both threads have quit
			while(t1.isAlive() && t2.isAlive()){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}*/
					
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Unable to find host");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to establish socket");
		}
	}

}
