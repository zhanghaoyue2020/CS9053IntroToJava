package fruit;
public class Apple extends Fruit{	
	private String taste = null;
	private String texture = null;	
	public Apple() {
		super();
	}	
	public Apple(String taste, String texture, String color, boolean rotten) {
		this();
		this.taste = taste;
		this.texture =texture;
		super.setColor(color);
		super.setRotten(rotten);
	}	
	public String getTaste() {
		return this.taste;
	}	
	public void setTaste(String taste) {
		this.taste = taste;
	}	
	public String getTexture() {
		return this.texture;
	}	
	public void setTexture(String taxture) {
		this.texture = taxture;
	}	
	public String toString() {
		if( super.getColor()!= null)
			return super.getId() + " / Fruit-Apple / color:"  + super.getColor() + " / rotten:" + super.isRotten()+ " / taste:" + this.taste + " / texture:" + this.texture;
		else
			return super.getId() +" / There is no Apple.";
	}	
	public boolean equals(Object o) {
		if(o instanceof Apple) {
			return (this.taste == ((Apple)o).taste) && (this.texture == ((Apple)o).texture) && (super.getColor()==((Apple)o).getColor()) && (super.isRotten()==((Apple)o).isRotten());
		}
		else
			return false;
	}	
}