package edu.westmont.cs130.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientHandler implements Runnable{

	private Socket socket = null;;
	private Scanner in = null;
	private PrintWriter out = null;
	private List<ClientHandler> others;
	
	private String name;

	public ClientHandler(Socket s,List<ClientHandler> others) throws IOException {
		this.socket = s;
		this.others = others;
		
		this.in = new Scanner(socket.getInputStream());
		this.out = new PrintWriter(socket.getOutputStream());
	}
	
	/**
	 * Use this method to output a message to the client that is managed by this
	 *  object
	 * @param sender
	 * @param message
	 */
	public void sendMessage(String sender,String message){
		if(this.out != null){
			System.out.println("Server sending:"+sender+":"+message);
			this.out.println(sender+" says \""+message+"\"");
			this.out.flush();
		}
		else{
			System.out.println("Couldn't output the message because connection was null");
		}
	}

	@Override
	public void run() {
		try{
			//According to our protocol the first message from client
			//is the client's name, so grab it
			if(this.in.hasNextLine()){
				this.name = this.in.nextLine();
				System.out.println(this.name+" joined the conversation");
			}
			
			//The next messages are chat messages until QUIT
			while(this.in.hasNextLine()){
				String message = this.in.nextLine();
				if(message.equals("QUIT")){
					System.out.println(this.name+" left the conversation");
					return;
				}
				else{
					//When we get a message, go through the list of all the
					// connected clients and send the message
					for(ClientHandler c:this.others){
						if(this != c){
							c.sendMessage(this.name,message);
						}
					}
				}
			}
		}
		finally{
			if(this.socket != null){
				try {
					this.socket.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
