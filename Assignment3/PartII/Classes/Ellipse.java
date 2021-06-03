package Classes;
public class Ellipse {
	public static void main(String[] args) {
		Ellipse ellipse1 = new Ellipse();
		Ellipse ellipse2 = new Ellipse(3.5,2.8);
		System.out.println(ellipse1.getId() + "\nThe area of an ellipse with semi major axis of "+ ellipse1.getSemiMajorAxis() + " and semi minor axis of " + ellipse1.getSemiMinorAxis() + " is " + ellipse1.getArea());		
		System.out.println(ellipse2.getId() + "\nThe area of an ellipse with semi major axis of "+ ellipse2.getSemiMajorAxis() + " and semi minor axis of " + ellipse2.getSemiMinorAxis() + " is " + ellipse2.getArea());
	}	
	private static int nextId = 0;
	private int id =0;
	private double semiMajorAxis = 2.0;
	private double semiMinorAxis = 1.0;
	public Ellipse() {
		Ellipse.nextId++;
		this.id = Ellipse.nextId;
	}
	public Ellipse(double a, double b) {
		this();
		this.semiMajorAxis = a;
		this.semiMinorAxis = b;
	}
	public double getSemiMajorAxis() {
		return this.semiMajorAxis;
	}	
	public double getSemiMinorAxis() {
		return this.semiMinorAxis;
	}	
	public double getArea() {
		return semiMajorAxis * semiMinorAxis * Math.PI; 
	}	
	public int getId() {
		return this.id;
	}
}


