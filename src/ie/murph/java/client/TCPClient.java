package ie.murph.java.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

//	private static InetAddress m_host;
	private static final int m_PORT = 1234;
	
	public static void main(String[] args)
	{
		run();
	}

	private static void run() 
	{
		Socket socketLink = null;
		try
		{
			// Link the socket to the host - STEP 1
			socketLink = new Socket("localhost", m_PORT);
			// Set up the means to read and write data - STEP 2
			BufferedReader input = new BufferedReader(new InputStreamReader(socketLink.getInputStream()));
			PrintWriter output = new PrintWriter(socketLink.getOutputStream(), true);
			// Set up stream for keyboard entry
			BufferedReader userEntry = new BufferedReader(new InputStreamReader(System.in));
			
			//Initialize two strings for storing messages send and message response
			String message, response;
			// Loop while user doesn't enter 'close'
			do
			{
				// Send the message to the server - STEP 3
				// Read the reply from the server - STEP 3
				System.out.println("\nEnter your message please: \n");
				message = userEntry.readLine();
				output.println(message); 
				response = input.readLine();
				System.out.println("\nFrom Server> " + response);
			}while(!message.equalsIgnoreCase("close"));
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		finally
		{
			try
			{
				// Close or end the socket after finished with it - STEP 4
				System.out.println("\nClosing Connection.. ");
				socketLink.close();
				System.out.println("\nConnection Closed.. ");
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
