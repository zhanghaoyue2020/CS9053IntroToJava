import java.io.*;
import java.net.*;
public class SimpleServer {	
	DataInputStream in;
	DataOutputStream out;
	ServerSocket server;
	Socket socket;	
	public SimpleServer() {
		try {
			server = new ServerSocket(8000);
			System.out.println("waiting to accept a connection");
			socket = server.accept();
			System.out.println("connection accepted");			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Message From Server");			
			System.out.println(in.readUTF());
		} catch (IOException e) {
			System.err.println("error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {		
		new SimpleServer();
	}
}