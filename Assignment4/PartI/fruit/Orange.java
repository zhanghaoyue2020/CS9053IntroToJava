package fruit;
public class Orange extends Citrus{	
	private String type = null;	
	public Orange() {
		super();
		super.setColor("Orange");
	}	
	public Orange(String type, String taste, boolean rotten) {
		this();
		this.type = type;
		super.setTaste(taste);
		super.setRotten(rotten);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
	public String toString() {
		if ((this.type != null) && (super.getColor() != null))
			return super.getId() + " / Fruit-Citrus-Orange / " + super.getColor()+ " / " + super.isRotten() + " / " + super.getTaste() + " / " + this.type;
		else
			return super.getId() + " / There is no Orange.";
	}	
	public boolean equas(Object o) {
		if(o instanceof Orange)
			return (super.getColor() == ((Orange)o).getColor()) && (this.type == ((Orange)o).getType()) && (super.getTaste()==((Orange)o).getTaste()) && (super.isRotten()==((Orange)o).isRotten());
		else
			return false;
	}
}