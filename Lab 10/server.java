import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class server {


	
	 public static final int PORT = 4444;
	 
	 public server() throws IOException 
	 {
		 ServerSocket serverSocket = null ;

		 try {
			 System.out.println ("Waiting for a client ...");
			 serverSocket = new ServerSocket(PORT);
			 Socket socket = serverSocket.accept();
			 while (true) {
		
				 new ClientThread(socket).start();
				 //if(ClientThread.ok == true)
					 break;
			 	}
		 } catch (IOException e) {
			 System.err. println ("Ooops... " + e);
		 } finally {
			 serverSocket.close();
		 }
	 }
	 public static void main ( String [] args ) throws IOException {
		 server server = new server ();
	 }


}