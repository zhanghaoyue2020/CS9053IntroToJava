public class ShapeException extends Exception{
	private String nonShape;
	public ShapeException(String se) {
		super("This is not a shape: " + se);
		this.nonShape = se;
	}
	public String getString() {
		return this.nonShape;
	}
}