package edu.westmont.cs130.server;

public class MyServer {

	public static void main(String[] args) {
		
		// Make sure that the program is started correctly
		if ((args.length < 1) || (args.length > 1)){
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
	}
}
