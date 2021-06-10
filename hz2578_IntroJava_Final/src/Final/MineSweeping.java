package Final;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import javax.swing.*;

public class MineSweeping extends JFrame {	
	//setting;
	static final int ROW = 16;
	static final int COLUMN = 16;
	static final int FRAME_WIDTH = COLUMN*16+5; 
	static final int FRAME_HIGHT = ROW*20+50;
	static final int LOSE = 258;
	static final int WIN = 257;
	static int MINE = 40;
	static int TIME = 1000;
	static final int MINECODE = 9;
	//frame variables;
	JMenuBar part1;
	JPanel part2 = new JPanel(new GridLayout(1,1));
	JPanel part3 = new JPanel(new GridLayout(ROW,COLUMN)); 
	JPanel part4 = new JPanel(new GridLayout(1,1)); 
	//part2 variables;
	JLabel remainingTime = new JLabel();
	int time; //remaining time
	Timer timer;
	ActionListener timeListener = new TimeListener();
	//part3 variables;
	int safeCell;//number of cells been discovered
	JButton[][] map;
	int[][] mapData; //0-8 the number of mines near it; 9 mine;	
	int[][] mapIcon; //0-8 the number of mines near it; 9 mine; 10 havn't been discovered; 11 report; 12 wrong report;
	MouseListener buttonListener = new ButtonListener();
	//part4 variables;
	JLabel remainingMines = new JLabel();
	int mines;//remaining time
	//IO variables;
	Socket socket;
	ObjectInputStream fromServer;
	ObjectOutputStream toServer;
	GameData data;
	Integer scores;
	ClientInf inf;
	//client information;
	int client;
	
	public MineSweeping(int client) {
		super("Mine Sweeping");
		//create client;
		this.client = client;
		timer = new Timer(1000,timeListener); //timer is universal for all rounds; 
		//create frame;
		this.createMenus();
		JPanel north = new JPanel(new GridLayout(2,1));
		north.add(part1);
		north.add(part2);
		this.add(north,BorderLayout.NORTH);
		this.add(part3,BorderLayout.CENTER);
		this.add(part4,BorderLayout.SOUTH);
		//frame initialization;
		this.setSize(FRAME_WIDTH,FRAME_HIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		//start game;
		this.newGame();
	}
	
	public static void main(String[] arg) throws Exception {
		new MineSweeping(1);
		new MineSweeping(2);
		new MineSweeping(3);
	}
	
	//part1:new game;
	private void newGame() {
		this.createRemainingTime();
		this.createMap();
		this.createRemainingMines();
	}
	//part1:download game;
	public void readData() {
		//create net;
		try {
			socket = new Socket("Localhost",8000);
			toServer = new ObjectOutputStream(socket.getOutputStream());
			fromServer = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//ask for a data;
		inf = new ClientInf(null,null,client);
		try {
			toServer.writeObject(inf);
			toServer.flush();
			data = (GameData) fromServer.readObject();
			fromServer.close();
			toServer.close();
			socket.close();
		}catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		if(data==null) {
			this.newGame();
			return;
		}
		//setting
		this.TIME = data.getTIME();
		this.MINE = data.getMINE();
		this.time = data.getTime();
		this.safeCell = data.getSafeCell();
		this.mines = data.getMines();
		this.mapData = data.getMapData();	
		this.mapIcon = data.getMapIcon();
		//rebuild;
		timer.start();
		remainingTime.setText("Time: "+time);
		part3.removeAll();
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COLUMN;j++) {
				JButton button = new JButton(new ImageIcon(mapIcon[i][j]+".png"));
				button.addMouseListener(buttonListener);
				part3.add(button);
				map[i][j]=button;
			}
		}
		remainingMines.setText(""+mines);
	}
	//part1:upload game;
	public void saveData() {
		if(mines == LOSE) {
			createMessageBox("Your Game is Over, Can't be Saved");
			return;
		}
		//create net;
		try {
			socket = new Socket("Localhost",8000);
			toServer = new ObjectOutputStream(socket.getOutputStream());
			fromServer = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//win and upload scores;
		if(mines == WIN) {
			inf = new ClientInf(null,time,client);
			try {
				toServer.writeObject(inf);
				toServer.flush();
				fromServer.close();
				toServer.close();
				socket.close();
				createMessageBox("Your Score is "+time+".");
			}catch(Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		//unfinished game;
		else {
			data = new GameData(MINE,TIME,time,safeCell,mapData,mines,mapIcon);
			inf = new ClientInf(data,null,client);
			try {
				toServer.writeObject(inf);
				toServer.flush();
				fromServer.close();
				toServer.close();
				socket.close();
				createMessageBox("Game has been Saved");
			}catch(Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
	}
	//part2:remaining time count;
	class TimeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			time--;
			remainingTime.setText("Time: "+time);
			timer.start();
			if(time ==0) {
				lose();
			}
		}
	}
	//part3:click the cell;
	class ButtonListener implements MouseListener{
		JButton botton;
		public void mouseClicked(MouseEvent e) {
			botton = (JButton) e.getSource();
			for(int i=0;i<ROW;i++) {
				for(int j=0;j<COLUMN;j++) {
					//find the grid
					if(botton==map[i][j]) {
						//left discover;
						if (e.getButton()==MouseEvent.BUTTON1) {
							openCell(i,j);
						}
						//right report or cancel report;
						if (e.getButton()==MouseEvent.BUTTON3) {
							if(mapIcon[i][j]==11) {
								recoverCell(i,j);
							}
							else {
								reportCell(i,j);
							}
						}
					}
				}
			}			
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	//part3:open a cell when icon=10
	private void openCell(int i,int j) {
		if(mapIcon[i][j]!=10){
			return;	
		}
		else if(mapData[i][j]==MINECODE) {
			lose();
		}
		else {
			mapIcon[i][j]=mapData[i][j];
			map[i][j].setIcon(new ImageIcon(mapIcon[i][j]+".png"));
			safeCell++;
			if((MINE+safeCell)==COLUMN*ROW) {
				win();
			}
			if(mapData[i][j]==0) {
				if(i>0 && j>0            && mapIcon[i-1][j-1]==10)  openCell(i-1,j-1);
				if(i>0                   && mapIcon[i-1][j]==10)    openCell(i-1,j);
				if(i>0 && j<COLUMN-1     && mapIcon[i-1][j+1]==10)  openCell(i-1,j+1);
				if(j>0                   && mapIcon[i][j-1]==10)    openCell(i,j-1);
				if(j<COLUMN-1            && mapIcon[i][j+1]==10)    openCell(i,j+1);
				if(i<ROW-1 && j>0        && mapIcon[i+1][j-1]==10)  openCell(i+1,j-1);
				if(i<ROW-1               && mapIcon[i+1][j]==10)    openCell(i+1,j);
				if(i<ROW-1 && j<COLUMN-1 && mapIcon[i+1][j+1]==10)  openCell(i+1,j+1);
			}
		}
	}
	//part3:report a cell when icon=10;
	private void reportCell(int i, int j){
		if(mapIcon[i][j]!=10){
			return;	
		}
		else {
			mapIcon[i][j]=11;
			map[i][j].setIcon(new ImageIcon(mapIcon[i][j]+".png"));
			mines--;
			remainingMines.setText(""+mines);
		}
	}
	//part3:cancel report a cell when game isn't over;
	private void recoverCell(int i,int j) {
		if((mines == WIN)||(mines == LOSE)) {
			return;
		}
		mapIcon[i][j]=10;
		map[i][j].setIcon(new ImageIcon(mapIcon[i][j]+".png"));
		mines++;
		remainingMines.setText(""+mines);
	}
	
	//game:lose;
	private void lose() {
		timer.stop();
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COLUMN;j++) {
				// open unreported mines;
				if(mapData[i][j]==MINECODE) {
					if(mapIcon[i][j]==11) {
						continue;
					}
					else {
						mapIcon[i][j]=9;
						map[i][j].setIcon(new ImageIcon(mapIcon[i][j]+".png"));
					}
				}
				// open unopened cells;
				else if (mapIcon[i][j]==10){
					mapIcon[i][j]=mapData[i][j];
					map[i][j].setIcon(new ImageIcon(mapIcon[i][j]+".png"));
					map[i][j].setEnabled(false);
				}
				// find wrong reported cells;
				else if (mapIcon[i][j]==11){
					mapIcon[i][j]=12;
					map[i][j].setIcon(new ImageIcon(mapIcon[i][j]+".png"));
				}
			}
		}
		mines = LOSE;
		remainingMines.setText("YOU  LOSE");
	}
	//game:win;
	private void win() {
		timer.stop();
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COLUMN;j++) {
				// open unreported mines;
				if(mapData[i][j]==MINECODE){
					if(mapIcon[i][j]==11) {
						continue;
					}
					else {
						mapIcon[i][j]=11;
						map[i][j].setIcon(new ImageIcon(mapIcon[i][j]+".png"));
					}
				}
			}
		}
		mines = WIN;
		remainingMines.setText("YOU  WIN");
		saveData();
	}
	
	//create the frame and initialization:
	//part1 frame;
	private void createMenus(){
		JMenu menuFile;
		JMenuItem menuNewItem;
		JMenuItem menuOpenItem;
		JMenuItem menuSaveItem;
		JMenuItem menuExitItem;
		part1 = new JMenuBar();
		menuNewItem = new JMenuItem("New");
		menuNewItem.addActionListener((e)->this.newGame());			
		menuOpenItem = new JMenuItem("Open");
		menuOpenItem.addActionListener((e)->this.readData());			
		menuSaveItem = new JMenuItem("Save");
		menuSaveItem.addActionListener((e)->this.saveData());				
		menuExitItem = new JMenuItem("Exit");
		menuExitItem.addActionListener((e)->System.exit(0));
		menuFile = new JMenu("GAME");
		menuFile.add(menuNewItem);
		menuFile.add(menuOpenItem);
		menuFile.add(menuSaveItem);
		menuFile.add(menuExitItem);
		part1.add(menuFile);
	}
	//part2 frame;
	private void createRemainingTime(){
		//initialize timer;
		time = TIME;
		timer.start();
		remainingTime.setText("Time: "+time);
		part2.add(remainingTime);
	}
	//part3 frame;
	private void createMap(){
		//initialize mines;
		safeCell = 0;
		map = new JButton[ROW][COLUMN];
		mapData = new int[ROW][COLUMN];
		mapIcon = new int[ROW][COLUMN];
		//put mines;
		Random rand= new Random();
		for(int i=0;i<MINE;) {
			int row = rand.nextInt(ROW);
			int column = rand.nextInt(COLUMN);
			if(mapData[row][column]!=MINECODE) {
				mapData[row][column]=MINECODE;
				i++;
			}
		}
		//count surrounding mines;
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COLUMN;j++) {
				if(mapData[i][j]==MINECODE)  continue;
				int n =0;
				if(i>0 && j>0            && mapData[i-1][j-1]==MINECODE)  n++;
				if(i>0                   && mapData[i-1][j]==MINECODE)  n++;
				if(i>0 && j<COLUMN-1     && mapData[i-1][j+1]==MINECODE)  n++;
				if(j>0                   && mapData[i][j-1]==MINECODE)  n++;
				if(j<COLUMN-1            && mapData[i][j+1]==MINECODE)  n++;
				if(i<ROW-1 && j>0        && mapData[i+1][j-1]==MINECODE)  n++;
				if(i<ROW-1               && mapData[i+1][j]==MINECODE)  n++;
				if(i<ROW-1 && j<COLUMN-1 && mapData[i+1][j+1]==MINECODE)  n++;
				mapData[i][j]=n;
			}
		}
		//display the map;
		part3.removeAll();
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COLUMN;j++) {
				mapIcon[i][j]=10;
				JButton button = new JButton(new ImageIcon(mapIcon[i][j]+".png"));
				button.addMouseListener(buttonListener);
				part3.add(button);
				map[i][j]=button;
			}
		}
	}
	//part4 frame;
	private void createRemainingMines(){
		//initialize mines number;
		mines = MINE;
		remainingMines.setText(""+mines);
		part4.add(remainingMines);
	}
	
	//appendix: show massage;
	private void createMessageBox(String msg){
		JFrame frame = new JFrame("Result");
		JLabel lbl = new JLabel(msg);
		frame.add(lbl);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}