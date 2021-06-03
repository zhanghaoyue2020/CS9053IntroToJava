package textfields;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class BasicTextField extends JFrame {
	JTextField textField;
	public BasicTextField() {
		textField = new JTextField(12);
		/*
		class EnterActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				System.out.println(textField.getText());
			}
	    }      
		textField.addActionListener(new EnterActionListener());
		textField.addActionListener((e) -> System.out.println(textField.getText()));
		class TypingListener implements CaretListener {
			public void caretUpdate(CaretEvent e) {
				System.out.println(textField.getText());
			}			
		}
		textField.addCaretListener(new TypingListener());
		*/
		textField.addCaretListener((e)-> System.out.println(textField.getText()));
		this.setLayout(new FlowLayout());
		this.add(textField);
		this.setSize(175, 75);
	}
	public static void main(String[] args) {
		JFrame btf = new BasicTextField();
		btf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btf.setVisible(true);
	}
}