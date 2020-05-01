import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {

	
	public static void main (String[] args) throws IOException {
		 
		String serverAddress = "127.0.0.1"; 
		int PORT = 4444; 
		 
		try (
				Socket socket = new Socket(serverAddress, PORT);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			) 
		{
			
			
			while(true)
			{
			Scanner scan =  new Scanner(System.in);
			String request = scan.nextLine();
			out.println(request);
			if(request.equals(".exit"))
			{
				socket.close();
			}
			
			if(request.equals(".stop"))
				{
					System.out.println("Server will shutdown in 5 seconds.");
					socket.close();
					break;
				}
			
			
			
			String response = in.readLine();
			System.out.println(response);
			
			out.flush();
			
			}		
			
		 } catch (UnknownHostException e) {
			 System.err.println("No server listening... " + e);
		 	}
	}
	}