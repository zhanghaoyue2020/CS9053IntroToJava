import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;
public class Client extends JFrame  {
	JTextArea textArea;
	Socket socket;
	DataOutputStream toServer;
	DataInputStream fromServer;
	public Client() {
		super("Client");
		JPanel topPanel = new JPanel(new GridLayout(2,1));
		JPanel controlPanel = new JPanel();
		topPanel.add(textField());
		controlPanel.add(openButton());
		controlPanel.add(closeButton());
		topPanel.add(controlPanel);
	  	textArea = new JTextArea(30,30);
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(textArea, BorderLayout.CENTER);
	}
	public JTextField textField() {
		JTextField textField = new JTextField(5);
		class TextFieldListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//Socket socket = null;
				try {
					//textArea.append("making connection..."+"\n");
					//socket = new Socket("localhost", 8000);
					//textArea.append("connected to locallhost"+'\n');
					//Socket socket = new Socket("130.254.204.36", 8000);
					//Socket socket = new Socket("drake.Armstrong.edu", 8000);
					fromServer = new DataInputStream(socket.getInputStream());
					toServer = new DataOutputStream(socket.getOutputStream());
				}catch (IOException ex) {
					textArea.append(ex.toString() + '\n');
				}
				try {
					double radius = Double.parseDouble(textField.getText().trim());
					toServer.writeDouble(radius);
					toServer.flush();
					double area = fromServer.readDouble();
					textArea.append("Radius is " + radius + "\n");
					textArea.append("Area received from the server is " + area + '\n');
		//			socket.close();
				}catch (IOException ex) {
					System.err.println(ex);
				}
			}
		}
		textField.addActionListener(new TextFieldListener());
		return textField;
	}
	public JButton closeButton(){
		JButton closeButton = new JButton("Close Connection");
		closeButton.addActionListener((e) -> { 
			try { 
				socket.close(); 
				textArea.append("connection closed");
			} catch (Exception e1) {
				System.err.println("error"); 
			}
		});
		return closeButton;
	}
	public JButton openButton(){
		JButton openButton = new JButton("Open COnnection");
		class OpenConnectionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					socket = new Socket("localhost", 8000);
					textArea.append("connected");
				} catch (IOException e1) {
					e1.printStackTrace();
					textArea.append("connection Failure");
				}
			}
		}
		openButton.addActionListener(new OpenConnectionListener()); 
		return openButton;
	}
	public static void main(String[] args) {
		Client c = new Client();
		c.setSize(400, 200);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
	}
}