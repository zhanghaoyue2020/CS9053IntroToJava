package bankaccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class InvestmentFrame extends JFrame{  
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private JLabel resultLabel;    
	private BankAccount account;
	private JPanel panel;
	private ActionListener listener; 
	private static final double DEFAULT_RATE = 10;
	private static final double INITIAL_BALANCE = 1000; 
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 200;
	private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
	public InvestmentFrame(){
		account = new BankAccount(INITIAL_BALANCE); 
		// Use instance fields for components 
		resultLabel = new JLabel("balance=" + DECIMAL_FORMAT.format(account.getBalance()));
		// Use helper methods
		createRateField();
		createButton();
		createPanel();
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	public void createRateField(){
		rateLabel = new JLabel("Interest Rate: ");
		rateField = new JTextField(10);
		rateField.setText("" + DEFAULT_RATE);
	}
	public void createButton(){
		button = new JButton("Add Interest");
		//define inner class
		class AddInterestListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				double rate = Double.parseDouble(rateField.getText());
				double interest = account.getBalance() * rate / 100;
				account.deposit(interest);
				resultLabel.setText("balance=" + DECIMAL_FORMAT.format(account.getBalance()));
			}            
		}
		listener = new AddInterestListener();
		button.addActionListener(listener);
	}
	public void createPanel(){
		panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(resultLabel);      
		this.add(panel);
	}
	public static void main(String[] args) {
		JFrame frame = new InvestmentFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);      
	}
}