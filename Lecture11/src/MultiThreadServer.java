import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
public class MultiThreadServer extends JFrame implements Runnable {
	private JTextArea ta;
	private int clientNo = 0;
	ServerSocket serverSocket;
	Set<Socket> connections;
	InetAddress inetAddress;
	public MultiThreadServer() {
		this.setTitle("MultiThreadServer");
		ta = new JTextArea(10,10);
		JScrollPane sp = new JScrollPane(ta);
		this.add(sp);
		new Thread(this).start();
	}
	public void run() {
		try {
			serverSocket = new ServerSocket(8000);
			connections = new HashSet<>();
			ta.append("MultiThreadServer started at " + new Date() + '\n');
			while (true) {
				Socket socket = serverSocket.accept();
				connections.add(socket);
				clientNo++;
				ta.append("Starting thread for client " + clientNo + " at " + new Date() + '\n');
				inetAddress = socket.getInetAddress();
				ta.append("Client " + clientNo + "'s host name is " + inetAddress.getHostName() + "\n");
				ta.append("Client " + clientNo + "'s IP Address is " + inetAddress.getHostAddress() + "\n");
				ta.append("Client " + clientNo + "'s port is " + socket.getPort() + "\n");
				new Thread(new HandleAClient(socket, clientNo)).start();
				connections.remove(socket);
			}
		} catch(IOException ex) {
			System.err.println(ex);
		}    
	}	
	void broadcastMessge() {
		for(Socket s:connections) {
			try {
				DataOutputStream outputToClient = new DataOutputStream(s.getOutputStream());
			}catch(Exception e){
				System.err.println("error: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	class HandleAClient implements Runnable {
		private Socket socket; // A connected socket
		InetAddress inetAddress;  
		DataInputStream inputFromClient;
		DataOutputStream outputToClient;
		private int clientNum;
		public HandleAClient(Socket socket, int clientNum) {
			this.socket = socket;
			this.clientNum = clientNum;
			this.inetAddress = socket.getInetAddress();
		}
		public void run() {
			try {
				inputFromClient = new DataInputStream(socket.getInputStream());
				outputToClient = new DataOutputStream(socket.getOutputStream());
				while (true) {
					double radius = inputFromClient.readDouble();
					double area = radius * radius * Math.PI;
					outputToClient.writeDouble(area);
					ta.append("radius received from client: " + this.clientNum + " " + radius + '\n');
					ta.append("Area found: " + area + '\n');
				}
			} catch(IOException ex) {
				ta.append("IOException: " + inetAddress.getHostAddress() +  ";"+socket.getPort() + '\n');
				ex.printStackTrace();
			}
		}
	}  
	public static void main(String[] args) {
		MultiThreadServer mts = new MultiThreadServer();
		mts.setSize(400,200);
		mts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mts.setVisible(true);
	}
}