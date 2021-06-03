package shapes;

public class Rectangle extends GeometricObject {
	private double width;
	private double height;	
	public Rectangle() {		
	}	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}	
	public Rectangle(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
	}	
	public double getWidth() {
		return width;
	}	
	public void setWidth(double width) {
		this.width = width;
	}	
	public double getHeight() {
		return height;
	}	
	public void setHeight(double height) {
		this.height = height;
	}	
	public Double getArea() {
		return width*height;
	}
	public Double getPerimiter() {
		return 2*(width+height);
	}
	public String toString() {
		return "The rectangle is created  " + getDateCreated() + " width = " + this.width + ", height = " + this.height;
	}
}