import java.io.*;
import java.net.*;
public class SimpleClient {
	DataInputStream in;
	DataOutputStream out;
	Socket socket;	
	public SimpleClient() {
		try {
			socket = new Socket("localhost",8000);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Message from Client");
			System.out.println(in.readUTF());
		} catch (IOException e) {
			System.err.println("error: " + e.getMessage());
			e.printStackTrace();
		}
	}	
	public static void main(String[] args) {
		new SimpleClient();
	}
}