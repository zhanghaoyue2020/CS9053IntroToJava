package textareaviewer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import bankaccount.BankAccount;
/**
   This program shows a frame with a text area that displays
   the growth of an investment. 
*/
public class TextAreaViewer extends JFrame{  
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
	private final static int AREA_ROWS = 10;
	private final static int AREA_COLUMNS = 30;
	private BankAccount account;
	private static final double DEFAULT_RATE = 10;
	private static final double INITIAL_BALANCE = 1000;
	private JLabel rateLabel;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTextField rateField;
	private JButton calculateButton;
	public TextAreaViewer() {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		account = new BankAccount(INITIAL_BALANCE);
		this.add(craeteNorthPanel(),BorderLayout.NORTH);
		this.add(createTextAreaPanel());   
	}
	private JPanel createTextAreaPanel() {
		textArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		return panel;
	}
	private JPanel craeteNorthPanel() {
		rateLabel = new JLabel("Interest Rate: ");
		rateField = new JTextField(10);
		rateField.setText("" + DEFAULT_RATE);
		calculateButton = new JButton("Add Interest");
		class CalculateListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				double rate = Double.parseDouble(rateField.getText());
				double interest = account.getBalance()* rate / 100;
				account.deposit(interest);
				textArea.append(DECIMAL_FORMAT.format(account.getBalance()) + "\n");
			}            
		}	
		ActionListener listener = new CalculateListener();
		calculateButton.addActionListener(listener);
		JPanel Panel = new JPanel();
		Panel.add(rateLabel);
		Panel.add(rateField);
		Panel.add(calculateButton);
		return Panel;
	}
	public static void main(String[] args){
		JFrame frame = new TextAreaViewer();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}