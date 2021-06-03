package graphics;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class RollDice extends JFrame{	
	int dice1;
	int dice2;	
	public RollDice () {
		add(new CreateDice(),BorderLayout.CENTER);
		add(new CreateResult(),BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		RollDice rd = new RollDice();
		rd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rd.setVisible(true);
		rd.setSize(500,300);
	}
	private ImagePanel image1Panel;
	private ImagePanel image2Panel;
	Image1PanelMouseListener image1Listener;
	Image2PanelMouseListener image2Listener;
	class CreateDice extends JPanel{
		public CreateDice() {
			dice1 = (int) (1+5*Math.random()); 
			image1Panel = new ImagePanel(new ImageIcon("die"+dice1+".png").getImage());
			image1Listener = new Image1PanelMouseListener();
			image1Panel.addMouseListener(image1Listener);
			this.add(image1Panel,BorderLayout.WEST);
			dice2 = (int) (1+5*Math.random());
			image2Panel = new ImagePanel(new ImageIcon("die"+dice2+".png").getImage());
			image2Listener = new Image2PanelMouseListener();
			image2Panel.addMouseListener(image2Listener);
			this.add(image2Panel,BorderLayout.EAST);
		}
	}	
	private JLabel result;
	private JButton rollDice;
	class CreateResult extends JPanel{
		public CreateResult() {
			super(new GridLayout(2,1));
			result = new JLabel("Result: " +(dice1+dice2));
			JPanel resultPanel = new JPanel();
			resultPanel.add(result);
			this.add(resultPanel);
			rollDice = new JButton("RollDice");
			rollDice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dice1 = (int) (1+5*Math.random());
					dice2 = (int) (1+5*Math.random());
					Image image1 = new ImageIcon("die"+dice1+".png").getImage();
					Image image2 = new ImageIcon("die"+dice2+".png").getImage();
					image1Panel.changeImage(image1);
					image2Panel.changeImage(image2);
					System.out.println("dice1 "+ dice1 + " dice2 "+ dice2);
					result.setText("Result: " +(dice1+dice2));
					image1Panel.repaint();
					image2Panel.repaint();
				}
			});
			JPanel buttonPanel = new JPanel();
			buttonPanel.add(rollDice);
			this.add(buttonPanel);
		}
	}	
	class Image1PanelMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			dice1 = (int) (1+5*Math.random());
			Image image = new ImageIcon("die"+dice1+".png").getImage();
			image1Panel.changeImage(image);
			System.out.println("dice1 "+dice1);
			result.setText("Result: " +(dice1+dice2));
			repaint();
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}	
	class Image2PanelMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			dice2 = (int) (1+5*Math.random());
			Image image = new ImageIcon("die"+dice2+".png").getImage();
			image2Panel.changeImage(image);
			System.out.println("dice2 "+dice2);
			result.setText("Result: " +(dice1+dice2));
			repaint();
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}	
}
class ImagePanel extends JPanel {
	private Image image;
	public ImagePanel(Image image) {
        this.image = image;
		Dimension size = new Dimension(this.image.getWidth(null), this.image.getHeight(null));
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        this.setLayout(null);
	}
	public void changeImage(Image image) {
        this.image = image;
	}
	public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
	}
}