import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class JDBCInterface extends JFrame {
	//frame size
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 600;
	final int AREA_ROWS = 20;
	final int AREA_COLUMNS = 40;
	private JPanel part1 = new JPanel(); //insert
	private JPanel part2 = new JPanel(); //query
	private JPanel part3 = new JPanel(); //display
	//part1 variables;
	JTextField lNameValue,fNameValue,ageValue,cityValue;
	//part2 variables;
	JTextField lastNameQuery;
	//part3 variables;
	JTextArea textQueryArea;
	//database variables;
	private Connection conn;
	private PreparedStatement insertStmt;
	private PreparedStatement queryStmtLastName;
	private Statement printAll;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	public JDBCInterface() {
		//create connection;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:assignment.db");
			insertStmt = conn.prepareStatement("Insert into People(last,First,age,city) Values(?,?,?,?)");
			queryStmtLastName = conn.prepareStatement("Select * from People WHERE Last = ?");
			printAll = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Connection error: " + e);
			System.exit(1);
		}
		//initializing the frame;
		this.createInsertPanel();
		this.createQueryPanel();
		this.createDisplayPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(part1);
		panel.add(part2);
		panel.add(part3);
		this.add(panel);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); 
		this.setResizable(false);
	}
	//part1: insert data;
	class InsertButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if((fNameValue.getText().equals(""))||(lNameValue.getText().equals(""))||(ageValue.getText().equals(""))||(cityValue.getText().equals(""))){
				createMessageBox("All field must be filled.");
				return;
			}
			try  {
				insertStmt.setString(1, lNameValue.getText());
				insertStmt.setString(2, fNameValue.getText());
				insertStmt.setString(3, ageValue.getText());
				insertStmt.setString(4, cityValue.getText());
				insertStmt.execute();
				createMessageBox("Insert Successfully.");
				clear();
			} catch (SQLException event) {
				createMessageBox(event.getMessage());
				event.printStackTrace();
			}
		}		
	}
	//part2: query through last name;
	class QueryButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			if(lastNameQuery.getText().isEmpty()) {
				try {
					rs = printAll.executeQuery("Select * from People");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					queryStmtLastName.setString(1, lastNameQuery.getText());
					rs = queryStmtLastName.executeQuery();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			try {			
				rsmd = rs.getMetaData();
				System.out.println(rs.getObject(1));
				int numColumns = rsmd.getColumnCount();
				String rowString = "";
				for(int j=1;j<=numColumns;j++) {
					Object o = rsmd.getColumnName(j);
					rowString += o.toString() + "\t";
				}
				rowString += "\n";
				while (rs.next()) {
					for (int i=1;i<=numColumns;i++) {
						Object o = rs.getObject(i);
						rowString += o.toString() + "\t";
					}
					rowString += "\n";
				}
				textQueryArea.setText(rowString);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	public static void main(String[] args){  
		new JDBCInterface();   
	}
	//part1
	private void createInsertPanel() {
		JLabel lName,fName,age,city;
		JButton insert;
		lName = new JLabel("Last Name: ");
		fName = new JLabel("First Name: ");
		age = new JLabel("age: ");
		city = new JLabel("city: ");
		lNameValue = new JTextField(10);
		fNameValue = new JTextField(10);
		ageValue = new JTextField(10);
		cityValue = new JTextField(10);
		insert = new JButton("Insert");
		insert.addActionListener(new InsertButtonListener());
		JPanel panel = new JPanel(new GridLayout(4,2));
		panel.add(lName);
		panel.add(lNameValue);
		panel.add(fName);
		panel.add(fNameValue);
		panel.add(age);
		panel.add(ageValue);
		panel.add(city);
		panel.add(cityValue);
		part1.add(panel,BorderLayout.CENTER);
		part1.add(insert);
	}
	//part2
	private void createQueryPanel() {
		JLabel lName;
		JButton query;
		lName = new JLabel("Last Name: ");
		lastNameQuery = new JTextField(10);
		query = new JButton("Query");
		query.addActionListener(new QueryButtonListener());
		JPanel panel = new JPanel(new GridLayout(1,2));
		panel.add(lName);
		panel.add(lastNameQuery);
		part2.add(panel,BorderLayout.CENTER);
		part2.add(query);
	}
	//part3
	private void createDisplayPanel() {
		JScrollPane scrollPane;
		textQueryArea = new JTextArea(AREA_ROWS,AREA_COLUMNS);
		textQueryArea.setEditable(false);
		scrollPane = new JScrollPane(textQueryArea);
		part3.add(scrollPane);
	}
	//part1 and part 2:clear text field
	private void clear() {
		lNameValue.setText("");
		fNameValue.setText("");
		ageValue.setText("");
		cityValue.setText("");
		lastNameQuery.setText("");
	}
	//part1: pop window
	private void createMessageBox(String msg){
		JFrame frame = new JFrame("Result");
		JLabel lbl = new JLabel(msg);
		frame.add(lbl);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}