package shapes;
public class Circle extends GeometricObject {
	private double radius;
	public Circle() {
		/* super();*/
	}
	public Circle(double radius) {
		this.radius = radius;		
	}
	public Circle (double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Double getArea() {
		return radius * radius * Math.PI;
	}
	public Double getDiameter() {
		return 2*radius;
	}
	public Double getPerimiter() {
		return 2*radius * Math.PI;
	}
	public void printCircle() {
		System.out.println("The circle is created  " + getDateCreated() +" and the radius is " + radius);
	}
	public String toString() {
		return "The circle is created  " + getDateCreated() +" radius = " + this.radius;
	}
}