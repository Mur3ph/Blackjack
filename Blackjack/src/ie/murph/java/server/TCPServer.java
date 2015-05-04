package ie.murph.java.server;

import ie.murph.java.gui.Dealhand;
import ie.murph.java.objects.Card;
import ie.murph.java.objects.Deck;
import ie.murph.java.objects.Table;
import ie.murph.java.objects.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	private static ServerSocket m_serverSock;
	private static final int m_PORT = 1234;
	
	public static void main(String[] args)
	{
		System.out.println("Service running on port: " + m_PORT + "\n");
		try
		{
			// Server socket to listen for connections
			// Establish connection to correct port number - STEP 1
			m_serverSock = new ServerSocket(m_PORT);
		}
		catch(IOException io)
		{
			io.printStackTrace();
			System.out.println("Unable to attach to port!");
			System.exit(1);
		}
		do
		{
			run();
		}
		while(true);
	}

	private static void run() 
	{
		Socket socketLink = null;	// STEP 2
		try
		{
			socketLink = m_serverSock.accept();		// STEP 2
			
			// Set up the means to read and write data - STEP 3
			BufferedReader input = new BufferedReader(new InputStreamReader(socketLink.getInputStream()));
			PrintWriter output = new PrintWriter(socketLink.getOutputStream(), true);
			
			Card card = new Card();
			Deck deck = new Deck(card);
			User dealer = new User("Dealer", 10000);
			Table table = new Table(deck, dealer);
			Dealhand deal = null;
			
			//passing and reading an object through BufferReader  
			String message = input.readLine();		// STEP 4
			
			while(!message.equalsIgnoreCase("close"))
			{
				System.out.println();
//				table.addUserToTable(user0);
				output.println("Message from Server --> " + ": " + message);		// STEP 4
				message = input.readLine();
			}
			output.println(" messages received.");		// STEP 4
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		finally 
		{
			try
			{
				System.out.println("\n* Closing Connection");
				socketLink.close(); 		// STEP 5
			}
			catch(IOException io)
			{
				io.printStackTrace();
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}
		}
	}
	
}
