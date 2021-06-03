package fruit;
public class Fruit {	
	private String color = null;
	private boolean rotten = false;
	private static int next_id = 1;
	private int id;	
	public Fruit() {
		this.id = this.next_id;
		this.next_id ++; 
	}	
	public Fruit(String color,boolean rotten) {
		this();
		this.color = color;
		this.rotten = rotten;
	}	
	public String getColor() {
		return this.color;
	}	
	public void setColor(String color) {
		this.color = color;
	}	
	public boolean isRotten() {
		return this.rotten;
	}	
	public void setRotten(boolean rotten) {
		this.rotten = rotten;
	}	
	public int getId() {
		return this.id;		
	}	
	public String toString() {
		if (this.color != null)
			return this.id + " / Friut / color:"+ this.color + " / rotten:" + this.rotten;
		else
			return this.id + " / There is no Fruit.";
	}	
	public boolean equals(Object o) {
		if(o instanceof Fruit) {
			return (this.color==((Fruit)o).getColor()) && (this.rotten==((Fruit)o).isRotten());
		}
		else
			return false;
	}
	public void deleteFruit() {
		this.color = null;
	}
}