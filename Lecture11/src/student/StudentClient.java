package student;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;
public class StudentClient extends JFrame {
	private JTextField tfName = new JTextField(20);
	private JTextField tfStreet = new JTextField(20);
	private JTextField tfCity = new JTextField(20);
	private JTextField tfState = new JTextField(3);
	private JTextField tfZip = new JTextField(6);
	private JButton btRegister = new JButton("Register to the Server");
	Socket socket;
	ObjectOutputStream toServer;
	public StudentClient() {
		super("StudentClient");
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel infoPanel = new JPanel(new GridLayout(6,2));
		infoPanel.add(new JLabel("Name"));
		infoPanel.add(tfName);
		infoPanel.add(new JLabel("Street"));
		infoPanel.add(tfStreet);
		infoPanel.add(new JLabel("City"));
		infoPanel.add(tfCity);
		infoPanel.add(new JLabel("State"));
		infoPanel.add(tfState);
		infoPanel.add(new JLabel("Zip"));
		infoPanel.add(tfZip);
		mainPanel.add(infoPanel, BorderLayout.CENTER);
		JPanel controlPanel = new JPanel();
		controlPanel.add(btRegister);
		btRegister.addActionListener(new ButtonListener());
		mainPanel.add(controlPanel, BorderLayout.SOUTH);
		this.add(mainPanel);
	}
	/** Handle button action */
	private class ButtonListener implements ActionListener {	  
		public void actionPerformed(ActionEvent e) {
			try {
				socket = new Socket("localhost", 8000);		
				toServer = new ObjectOutputStream(socket.getOutputStream());		
				String name = tfName.getText().trim();
				String street = tfStreet.getText().trim();
				String city = tfCity.getText().trim();
				String state = tfState.getText().trim();
				String zip = tfZip.getText().trim();				
				StudentAddress s = new StudentAddress(name, street, city, state, zip);
				toServer.writeObject(s);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		StudentClient sc = new StudentClient();
		sc.setSize(450, 200);
		sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sc.setVisible(true);
	}
}