package graphics;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class ShowColors extends JFrame {
	public ShowColors() {
		super("Using colors");
		this.add(new ColorJPanel());
		this.setSize(500,180);
	}	
	public static void main(String[] args) {
		ShowColors showColors = new ShowColors();
		showColors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showColors.setVisible(true);
	}
}
class ColorJPanel extends JPanel {
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.setColor(new Color(255, 0 , 0));
		g.fillRect(15, 25, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 40);
		g.setColor(new Color(0.5f, 0.75f, 0.0f));
		g.fillRect(15, 50, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 65);
		g.setColor(Color.BLUE);
		g.fillRect(15, 75, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 90);		
		Color color = Color.MAGENTA;
		g.setColor(color);
		g.fillRect(15, 100, 100, 20);
		g.drawString("RGB values: " + color.getRed() + ", " +color.getGreen() + ", " + color.getBlue(),	130, 115);
	}
}