package fruit;
public class Citrus extends Fruit{
	private String taste = null;
	public Citrus(){
		super();
	}	
	public Citrus(String taste, String color, boolean rotten) {
		this();
		this.taste = taste;
		super.setColor(color);
		super.setRotten(rotten);
	}	
	public String getTaste() {
		return this.taste;
	}	
	public void setTaste(String taste) {
		this.taste = taste;
	}	
	public String toString() {
		if(super.getColor() != null)
			return super.getId() + " / Fruit-Citrus / color:" + super.getColor() + " / rotten:" + super.isRotten() + " / taste:" + this.taste;
		else
			return super.getId() + " / There is no Citrus."; 
	}
	public boolean equals(Object o) {
		if(o instanceof Citrus) {
			return (this.taste == ((Citrus)o).taste) && (super.getColor()==((Citrus)o).getColor()) && (super.isRotten()==((Apple)o).isRotten());
		}
		else
			return false;
	}
}