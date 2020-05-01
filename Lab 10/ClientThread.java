import java.io.*;
import java.net.*;
import java.util.Scanner;

class ClientThread extends Thread {
 
	private Socket socket = null ;
	public ClientThread (Socket socket) { this.socket = socket ; }
	public static boolean ok = false;
	
	public void run () {
 
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true)
			  {
				String request = in.readLine();
 
				
				System.out.println(request);
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				if(request.equals(".exit"))
					{
					System.out.println("Player left the server." );
					
					}
				
					if(request.equals(".stop"))
						{
							System.out.println("Server will shutdown in 5 seconds.");
							ok = true;
							sleep(5000);
							socket.close();	
							break;
						}
				
				String raspuns = "raspuns"; // pot adauga aici comenzi pentru jocul care ulterior ca va aparea pentru partea optionala
				out.println(raspuns);
				
				out.flush();
			}
			} catch (IOException | InterruptedException e) {
				System.err.println("Communication error... " + e);
			} finally {
				try {
					socket.close(); 
				} catch (IOException e) { System.err.println (e); }
			}
		}
	}