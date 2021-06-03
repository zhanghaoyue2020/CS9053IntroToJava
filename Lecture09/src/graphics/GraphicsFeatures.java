package graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class GraphicsFeatures extends JFrame {
	public GraphicsFeatures() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(900,200);
		this.add(new CreateMainPanel());	
	}
	public static void main(String[] args) {
		GraphicsFeatures graphicsFeatures = new GraphicsFeatures();
		graphicsFeatures.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphicsFeatures.setVisible(true);
	}
}
class CreateMainPanel extends JPanel {
	public CreateMainPanel(){
		this.setLayout(new GridLayout(1,3));
		this.add(new PaintPanel());
		this.add(new LinesRectsOvalsJPanel());
		this.add(new ImagePanel("die1.png"));
	}
}
class PaintPanel extends JPanel {
	private final ArrayList<Point> points = new ArrayList<>();
	public PaintPanel() {
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent event) {
				points.add(event.getPoint());
				repaint();
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 		
		for (Point point : points) {
			g.fillOval(point.x, point.y, 4,4);
		}
	}
}
class LinesRectsOvalsJPanel extends JPanel {
	public LinesRectsOvalsJPanel() {
		this.setPreferredSize(new Dimension(400,200));
	}	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // call the superclass's paint Method
		this.setBackground(Color.WHITE);		
		g.setColor(Color.RED);
		g.drawLine(5,  30,  190, 30);	
		g.setColor(Color.BLUE);
		g.drawRect(5, 40, 90 ,55);
		g.fillRect(100, 40, 90, 55);			
		g.setColor(Color.CYAN);
		g.drawRoundRect(290, 40, 90, 55, 20, 20);
		g.fillRoundRect(190, 40, 90, 55, 50, 50);			
		g.setColor(Color.GREEN);
		g.draw3DRect(5, 100, 90, 55, true);
		g.fill3DRect(100, 100, 90, 55, false);			
		g.setColor(Color.MAGENTA);
		g.drawOval(195, 100, 90, 55);
		g.fillOval(290, 100, 90, 55);
	}
}
class ImagePanel extends JPanel {
	private Image img;
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}	
	public ImagePanel(Image img) {
		this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        this.setLayout(null);
	}
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}

/*
class CreatePaintPanel extends PaintPanel {
	public CreatePaintPanel(){
		Dimension size = new Dimension(200,180);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setSize(size);
	}
}
*/