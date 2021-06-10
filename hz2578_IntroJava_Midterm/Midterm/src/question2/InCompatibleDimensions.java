package question2;
public class InCompatibleDimensions extends Exception{	
	/**
	 * different dimension
	 */	
	private static final long serialVersionUID = 1L;
	private String information;
	private int thisLength;
	private int differentLength;	
	public InCompatibleDimensions (String information, int thisLength, int differentLength) {
		super(information + ": " + thisLength + " and " + differentLength);
		this.information = information;
		this.thisLength = thisLength;
		this.differentLength = differentLength;
	}	
	public String getInformation() {
		return information;
	}
	public int getThisLength() {
		return thisLength;
	}
	public int getDifferentLength() {
		return differentLength;
	}	
}