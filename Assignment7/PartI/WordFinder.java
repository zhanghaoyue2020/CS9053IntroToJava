import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WordFinder extends JFrame {
	JFileChooser jFileChooser;
	WordList wordList;
	DefaultListModel listModel;
	JList list;
	private JScrollPane scrollPane;
	public static void main(String[] args) {
		WordFinder wordFinder = new WordFinder();
		wordFinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wordFinder.setVisible(true);
	}
	public WordFinder() {
		this.setSize(500, 300);
		this.setJMenuBar(new CreateMenus());
		this.add(new CreateTopPanel(),BorderLayout.NORTH);
		listModel = new DefaultListModel();
		list = new JList(listModel);
		scrollPane = new JScrollPane(list);
		this.add(scrollPane,BorderLayout.CENTER);
	}	
	private void find(String string){
		listModel.clear();
		List searchResult = wordList.find(string);
		for (Iterator i = searchResult.iterator(); i.hasNext(); ) {
			listModel.addElement(i.next());    
		}
	}
	class CreateTopPanel extends JPanel {
		private JLabel find;
		private JTextField textField;
		private JButton clear;
		CreateTopPanel(){
			super();			
			find = new JLabel("Find: ");
			textField = new JTextField(15);
			class TypingListener implements CaretListener{
				public void caretUpdate(CaretEvent e) {
					find(textField.getText());					
				}
			}
			textField.addCaretListener(new TypingListener());
			clear = new JButton("clear");
			class ClearListener implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					textField.setText("");	
				}			
			}
			clear.addActionListener(new ClearListener());
			this.add(find);
			this.add(textField);
			this.add(clear);
		}
	}
	class CreateMenus extends JMenuBar {
		private JMenu menuFile;
		private JMenuItem menuOpenItem;
		private JMenuItem menuExitItem;
		CreateMenus(){
			super();
			menuOpenItem = new JMenuItem("Open");
			class OpenActionListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					OpenFileListener myFileListener = new OpenFileListener();
					myFileListener.actionPerformed(e);
				}
			}
			menuOpenItem.addActionListener(new OpenActionListener());
			menuExitItem = new JMenuItem("Exit");
			menuExitItem.addActionListener((e)->System.exit(0));
			menuFile = new JMenu("File");
			this.add(menuFile);
			menuFile.add(menuOpenItem);
			menuFile.add(menuExitItem);
		}
	}	
	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jFileChooser = new JFileChooser(".");
			wordList = new WordList();
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println("You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());
					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);
					find("");  
				} catch (IOException error){
					error.printStackTrace();
				}
			}
		}
	}
}
