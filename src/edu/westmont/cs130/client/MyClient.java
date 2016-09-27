package edu.westmont.cs130.client;


public class MyClient {

	public static void main(String[] args) {

		// Make sure that the program is started correctly
		if(args.length < 3){
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
		
	}

}
