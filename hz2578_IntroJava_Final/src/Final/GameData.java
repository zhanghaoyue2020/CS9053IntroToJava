package Final;

public class GameData implements java.io.Serializable {
	int MINE;
	int TIME;
	int time;
	int safeCell;
	int[][] mapData;		
	int mines;
	int[][] mapIcon;
	public GameData(int mINE, int tIME, int time2, int safeCell, int[][] mapData, int mines, int[][] mapIcon) {
		super();
		MINE = mINE;
		TIME = tIME;
		time = time2;
		this.safeCell = safeCell;
		this.mapData = mapData;
		this.mines = mines;
		this.mapIcon = mapIcon;
	}
	public int getMINE() {
		return MINE;
	}
	public int getTIME() {
		return TIME;
	}
	public int getTime() {
		return time;
	}
	public int getSafeCell() {
		return safeCell;
	}
	public int[][] getMapData() {
		return mapData;
	}
	public int getMines() {
		return mines;
	}
	public int[][] getMapIcon() {
		return mapIcon;
	}
}