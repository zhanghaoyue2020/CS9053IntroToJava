package choice;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
public class ChoiceFrame extends JFrame{	
	private JLabel sampleField;
	private JCheckBox italicCheckBox;
	private JCheckBox boldCheckBox;
	private JRadioButton smallButton;
	private JRadioButton mediumButton;
	private JRadioButton largeButton;
	private JComboBox facenameCombo;
	private ActionListener listener;
	private JPanel facenamePanel;
	private JPanel styleGroupPanel;
	private JPanel sizeGroupPanel;
	private JPanel controlPanel;
	private ButtonGroup group;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	public ChoiceFrame(){  
		// Construct text sample
		sampleField = new JLabel("Big Java");
		add(sampleField, BorderLayout.CENTER);
		// This listener is shared among all components
		class ChoiceListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				setSampleFont();
			}
		}
		listener = new ChoiceListener();
		createControlPanel();
		setSampleFont();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	public void createControlPanel(){
		facenamePanel = createComboBox();
		styleGroupPanel = createCheckBoxes();
		sizeGroupPanel = createRadioButtons();
		// Line up component panels
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 1));
		controlPanel.add(facenamePanel);
		controlPanel.add(styleGroupPanel);
		controlPanel.add(sizeGroupPanel);
		// Add panels to content pane
		add(controlPanel, BorderLayout.SOUTH);
	}
/**
      Creates the combo box with the font style choices.
      @return the panel containing the combo box
*/
	public JPanel createComboBox(){
		facenameCombo = new JComboBox();
		facenameCombo.addItem("Serif");
		facenameCombo.addItem("SansSerif");
		facenameCombo.addItem("Monospaced");
		facenameCombo.setEditable(false);
		facenameCombo.addActionListener(listener);
		JPanel panel = new JPanel();
		panel.add(facenameCombo);
		return panel;
	}
/**
      Creates the check boxes for selecting bold and italic styles.
      @return the panel containing the check boxes
*/
	public JPanel createCheckBoxes(){
		italicCheckBox = new JCheckBox("Italic");
		italicCheckBox.addActionListener(listener);
		boldCheckBox = new JCheckBox("Bold");
		boldCheckBox.addActionListener(listener);
		JPanel panel = new JPanel();
		panel.add(italicCheckBox);
		panel.add(boldCheckBox);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));
		return panel;
	}
/**
      Creates the radio buttons to select the font size
      @return the panel containing the radio buttons
*/
	public JPanel createRadioButtons(){
		smallButton = new JRadioButton("Small");
		smallButton.addActionListener(listener);
		mediumButton = new JRadioButton("Medium");
		mediumButton.addActionListener(listener);
		largeButton = new JRadioButton("Large");
		largeButton.addActionListener(listener);
		largeButton.setSelected(true);
		// Add radio buttons to button group
		group = new ButtonGroup();
		group.add(smallButton);
		group.add(mediumButton);
		group.add(largeButton);
		JPanel panel = new JPanel();
		panel.add(smallButton);
		panel.add(mediumButton);
		panel.add(largeButton);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
		return panel;
	}
/**
      Gets user choice for font name, style, and size
      and sets the font of the text sample.
*/
	public void setSampleFont() {
		// Get font name   
		String facename = (String) facenameCombo.getSelectedItem();
		// Get font style
		int style = 0;
		if (italicCheckBox.isSelected()) 
			style = style + Font.ITALIC;
		if (boldCheckBox.isSelected()) 
			style = style + Font.BOLD;
		// Get font size   
		int size = 0;
		final int SMALL_SIZE = 24;
		final int MEDIUM_SIZE = 36;
		final int LARGE_SIZE = 48;
		if (smallButton.isSelected()) 
			size = SMALL_SIZE;
		else if (mediumButton.isSelected()) 
			size = MEDIUM_SIZE;
		else if (largeButton.isSelected()) 
			size = LARGE_SIZE;
		// Set font of text field
		sampleField.setFont(new Font(facename, style, size));      
		sampleField.repaint();
	}
	public static void main(String[] args){
		JFrame frame = new ChoiceFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);      
	}
}