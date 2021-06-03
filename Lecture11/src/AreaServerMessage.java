public class AreaServerMessage {
	Double area;
	String Message;
	public AreaServerMessage(Double area, String message) {
		super();
		this.area = area;
		this.Message = message;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
}