package sliderframe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
public class SliderFrame extends JFrame{
	private JPanel colorPanel;
	private JSlider redSlider;
	private JSlider greenSlider;
	private JSlider blueSlider;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	public SliderFrame(){
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		colorPanel = new JPanel();
		this.add(colorPanel,BorderLayout.CENTER);
		this.add(createControlPanel(), BorderLayout.SOUTH);
		setSampleColor();
	}
	public JPanel createControlPanel(){
		class ColorListener implements ChangeListener{
			public void stateChanged(ChangeEvent event){
				setSampleColor();
			}
		}   
		ChangeListener listener = new ColorListener();
		redSlider = new JSlider(0, 100, 100);
		redSlider.addChangeListener(listener);
		redSlider.setBorder(new EtchedBorder());
		greenSlider = new JSlider(0, 100, 0);
		greenSlider.addChangeListener(listener);
		blueSlider = new JSlider(0, 100, 0);
		blueSlider.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		panel.setBorder(new EtchedBorder());
		panel.add(new JLabel("Red"));
		panel.add(redSlider);
		panel.add(new JLabel("Green"));
		panel.add(greenSlider);
		panel.add(new JLabel("Blue"));
		panel.add(blueSlider);
		return panel;
	}
	/**
		Reads the slider values and sets the panel to
		the selected color.
	*/
	public void setSampleColor(){
		// Read slider values
		float red = 0.01F * redSlider.getValue();
		float green = 0.01F * greenSlider.getValue();
		float blue = 0.01F * blueSlider.getValue();
		// Set panel background to selected color
		colorPanel.setBackground(new Color(red, green, blue));
		colorPanel.repaint();
	}
	public static void main(String[] args){ 
		SliderFrame frame = new SliderFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}

/*
for setSampleColor:
redValue.setText(DECIMAL_FORMAT.format(red));
greenValue.setText(DECIMAL_FORMAT.format(green));
blueValue.setText(DECIMAL_FORMAT.format(blue));
*/

/* new fields:
private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
private JTextField redValue;
private JTextField greenValue;
private JTextField blueValue;
*/

/* add to panel:
controlPanel.add(blueValue), etc 
*/

/* in create control panel:
greenValue = new JTextField(3);, etc
*/