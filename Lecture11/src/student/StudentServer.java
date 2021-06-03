package student;
import java.io.*;
import java.net.*;
public class StudentServer {
	ServerSocket serverSocket;
	Socket socket ;
	private ObjectOutputStream outputToFile;
	private ObjectInputStream inputFromClient;
	public StudentServer() {
		try {
			serverSocket = new ServerSocket(8000);
			System.out.println("Server started ");
			outputToFile = new ObjectOutputStream(new FileOutputStream("student.dat", true));
			while (true) {
				socket = serverSocket.accept();
				inputFromClient = new ObjectInputStream(socket.getInputStream());
				Object object = inputFromClient.readObject();
				StudentAddress s = (StudentAddress)object;
				System.out.println("got object " + object.toString());
				outputToFile.writeObject(s);
				outputToFile.flush();
				System.out.println("A new student object is stored");
			}
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				inputFromClient.close();
				outputToFile.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}	
	public static void main(String[] args) {
		new StudentServer();
	}
}