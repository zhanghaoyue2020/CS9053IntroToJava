
import java.io.*;
import java.net.*;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Server extends JFrame implements Runnable {
	JTextArea ta;	    
	ServerSocket serverSocket;
	Socket socket ;
	InetAddress inetAddress ;
	DataInputStream inputFromClient ;
	DataOutputStream outputToClient ;
	public Server() {
		super("Server");
		ta = new JTextArea();
		this.add(ta);
		new Thread(this).start();
	}
	public void run() {
		try {
			serverSocket = new ServerSocket(8000);
			while (true) {
				ta.append("Waiting for connection\n");
				socket = serverSocket.accept();
				inetAddress = socket.getInetAddress();
				ta.append("Received connection from "+ inetAddress.getHostName() +"\n");
				ta.append("with address " + inetAddress.getHostAddress() +" on port " + socket.getPort() + "\n");
				inputFromClient= new DataInputStream(socket.getInputStream());
				outputToClient= new DataOutputStream(socket.getOutputStream());
				double radius = inputFromClient.readDouble();
				double area = radius * radius * Math.PI;
				outputToClient.writeDouble(area);
				ta.append("Radius received from client: " + radius + '\n');
				ta.append("Area is: " + area + '\n'); 
	            Thread.sleep(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server s =  new Server();
		s.setSize(400, 200);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
	}
}