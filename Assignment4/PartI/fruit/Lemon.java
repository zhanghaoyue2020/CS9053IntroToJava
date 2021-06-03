package fruit;
public class Lemon extends Citrus{	
	private int sourness = 0;
	public Lemon() {
		super();
		super.setColor("yellow");
	}	
	public Lemon(int sourness,String taste, boolean rotten) {
		this();
		this.sourness = sourness;
		super.setTaste(taste);
		super.setRotten(rotten);
	}	
	public int getSourness() {
		return this.sourness;
	}	
	public void setSourness(int sourness) {
		this.sourness = sourness;
	}	
	public String toString(){
		if ((super.getTaste() != null) && (super.getColor() != null))
			return super.getId() + " / Fruit-Citrus-Lemon / color:" + super.getColor() + " / rotten:" + super.isRotten() + " / taste:" +super.getTaste() + " / sourness:" + this.sourness;
		else
			return super.getId() + " / There is no Lemon.";
	}	
	public boolean equals(Object o) {
		if(o instanceof Lemon) {
			return (super.getColor() == ((Lemon)o).getColor()) && (this.sourness == ((Lemon)o).getSourness()) && (super.getTaste()==((Lemon)o).getTaste()) && (super.isRotten()==((Lemon)o).isRotten());
		}
		else
			return false;
	}
}