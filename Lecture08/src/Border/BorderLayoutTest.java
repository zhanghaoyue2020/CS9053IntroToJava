package Border;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
public class BorderLayoutTest extends JFrame{
	private JButton button1;
	private JButton button2;
	private JPanel panel;
	private JPanel button1Panel;
	private JPanel button2Panel;
	public BorderLayoutTest	() {
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		button1Panel = new JPanel(new GridLayout());
		button2Panel = new JPanel();
		button1Panel.add(button1);
		button2Panel.add(button2);
		panel.add(button1Panel);
		panel.add(button2Panel);
		this.add(panel,BorderLayout.NORTH);
		setSize(500,200);
	}
	public static void main(String[] args) {
		JFrame f = new BorderLayoutTest();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}