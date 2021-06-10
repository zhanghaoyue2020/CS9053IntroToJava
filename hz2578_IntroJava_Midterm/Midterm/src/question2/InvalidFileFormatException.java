package question2;
public class InvalidFileFormatException extends Exception{	
	/**
	 * String can't be split
	 */	
	private static final long serialVersionUID = 1L;
	private String information;
	private String line;
	public InvalidFileFormatException (String information, String line) {
		super();
		this.information = information;
		this.line = line;
	}	
	public String getInformation() {
		return information;
	}
	public String getLine() {
		return line;
	}	
}