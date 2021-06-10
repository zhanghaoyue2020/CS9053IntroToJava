package Final;
import java.io.*;
import java.net.*;
import java.sql.*;

public class Server implements Runnable {
	//net variable
	ServerSocket server;
	ObjectInputStream fromClient;
	ObjectOutputStream toClient;
	//SQL variable
	Connection connect;
	Socket socket;
	PreparedStatement stmt;
	ResultSet rs;
	
	public void run() {
		try {
			server = new ServerSocket(8000);
			connect = DriverManager.getConnection("jdbc:sqlite:javaclass.db");
			System.out.println("Server is working....");
		}catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}	
		while(true) {
			try {
				socket = server.accept();
				fromClient = new ObjectInputStream(socket.getInputStream());
				toClient = new ObjectOutputStream(socket.getOutputStream());
				//prepare database; 
				ClientInf inf;
				GameData data;
				Integer scores;
				Integer client;
				inf = (ClientInf) fromClient.readObject();
				data = inf.getData();
				scores = inf.getScores();
				client = inf.getClient();
				System.out.println("\nreceive information");
				//find data from SQL and send it to Client;
				if ((data== null)&&(scores==null)) {
					System.out.println("want to open");
					stmt = connect.prepareStatement("SELECT GameData FROM MineSweeper WHERE Client = ? ");
					stmt.setInt(1, client);
					rs = stmt.executeQuery();
					while(!rs.isClosed()) {
						if(rs.getBytes(1)==null) {
							rs.next();
							continue;
						}
						data = (GameData) new ObjectInputStream(new ByteArrayInputStream(rs.getBytes(1))).readObject();
						break;
					}
					toClient.writeObject(data);
					if(data==null) {
						System.out.println("can't find data");
					}
					else {
						System.out.println("open successfully");						
					}
				}
				//receive scores from Client and store it in SQL;
				else if((data==null)&&(scores!=null)){
					System.out.println("store scores");
					stmt = connect.prepareStatement("INSERT INTO MineSweeper(Scores,Client) VALUES (?,?)");
					stmt.setInt(1, scores);
					stmt.setInt(2, client);
					stmt.execute();
					System.out.println("store successfully");
				}
				//receive data from Client and store it in SQL;
				else {
					System.out.println("want to save");
					//prepare byte[] form data;
					byte[] dataBytes;
					ByteArrayOutputStream transfer =new ByteArrayOutputStream();
					new ObjectOutputStream(transfer).writeObject(data);
					dataBytes = transfer.toByteArray();
					//find client;
					stmt = connect.prepareStatement("SELECT * FROM MineSweeper WHERE Client = ?");
					stmt.setInt(1, client);
					rs = stmt.executeQuery();
					//there is a data under the client, update it;
					while(!rs.isClosed()) {
						if(rs.getBytes(1)==null) {
							rs.next();
							continue;
						}
						else {
							stmt = connect.prepareStatement("UPDATE MineSweeper SET GameData = ? WHERE Scores = ? AND Client = ?");
							stmt.setBytes(1, dataBytes);
							stmt.setInt(2, -1);
							stmt.setInt(3, client);
							stmt.execute();
							dataBytes=null;
							System.out.println("data changed");
							break;
						}
					}
					//there isn't a data under the client, create one;
					if(dataBytes!=null) {
						stmt = connect.prepareStatement("INSERT INTO MineSweeper(GameData,Scores,Client) VALUES (?,?,?)");
						stmt.setBytes(1, dataBytes);
						stmt.setInt(2, -1);
						stmt.setInt(3, client);
						stmt.execute();
						System.out.println("new data is saved");
					}
				}				
			}catch(Exception e) {
				e.getMessage();
				e.printStackTrace();
			}			
		}
	}

	public static void main(String [] args) throws SQLException, IOException {
		new Thread(new Server()).start();
	}
}