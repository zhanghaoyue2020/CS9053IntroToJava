package question2;
import java.io.*;
public class MyVector {	
	/* MyVector(int n): constructor creates a vector of size n 
	 * with all values set to zero
	 */	
	double[] myVector;
	public MyVector(int n) {
		myVector = new double[n];  
		for(int i = 0; i < n; i ++) {
			this.setData(i, 0);
		}
	}
	public String toString() {
		String stringLine = "";
		for (int i = 0; i < this.myVector.length; i++ )	{
			stringLine = stringLine + String.valueOf(this.myVector[i]) + " ";
		}
		return stringLine;
	}
	public void setData(int index, double data) {
		myVector [index] = data;
	}	
	/* void save(String filename): saves the values of the vector 
	 * to a file with the name filename
	 */
	public void save(String filename) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(filename);
		}catch(IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
		bufferedWriter = new BufferedWriter (fileWriter);
		try{
			bufferedWriter.write(this.toString());
			bufferedWriter.flush();
			bufferedWriter.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}	
	/* static MyVector read(String filename): reads the values of 
	 * a vector from the file named filename, creates the vector, 
	 * and returns it
	 */
	public static MyVector read(String filename) throws InvalidFileFormatException{
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(filename);
		}catch(FileNotFoundException fnfe) {
			System.err.println("file not found: " + fnfe.getMessage());
			System.exit(1);
		}		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String stringLine = null;
		String[] stringData = null;
		try {
			stringLine = bufferedReader.readLine();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		stringData = stringLine.split(" ");
		MyVector myVector = new MyVector(stringData.length);
		do{
			try {
				stringLine = bufferedReader.readLine();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			if(stringLine == null)
				break;
			else
				try {
					throw new InvalidFileFormatException( "this row will not be split:",  stringLine);
				}catch(InvalidFileFormatException iffe) {
					System.err.println(iffe.getInformation() + " " + iffe.getLine());
					iffe.printStackTrace();
				}
		}while(stringLine != null);				
		double data;
		for(int i = 0; i < stringData.length; i ++) {
			try{
				data = Double.parseDouble(stringData[i]);
				myVector.setData(i, data);
			}catch(NumberFormatException nfe) {
				System.err.println("data " + i + " should be double:" + nfe.getMessage());
				nfe.printStackTrace();
			}
		}
		return myVector;
	}	
	/* MyVector sum(MyVector v): adds the value of the current 
	 * vector to the vector v and returns a new vector representing 
	 * the sum. Throws the exception  IncompatibleDimensions if 
  	 * the matrices are of different dimensions
	 */
	public MyVector sum(MyVector v) throws InCompatibleDimensions{
		if(this.myVector.length == v.myVector.length) {
			MyVector multiplyVector = new MyVector(this.myVector.length);
			for (int i = 0; i < this.myVector.length ; i++ ) {
				multiplyVector.setData(i, this.myVector[i] + v.myVector[i]);
			}
			return multiplyVector;
		}
		else
			throw new InCompatibleDimensions("different dimensions", this.myVector.length, v.myVector.length);
	}	
	/* MyVector multiply(MyVector v): calculates the dot product 
	 * of MyVector and v and returns a new vector representing the 
	 * dot product. Throws the exception  IncompatibleDimensions 
	 * if the matrices are of different dimensions
	 */
	public double multiply(MyVector v) throws InCompatibleDimensions{
		if(this.myVector.length == v.myVector.length) {
			double potProduct = 0;
			for (int i = 0; i < this.myVector.length ; i++ ) {
				potProduct = potProduct + this.myVector[i] * v.myVector[i];
			}
			return potProduct;
		}
		else
			throw new InCompatibleDimensions("different dimensions", this.myVector.length, v.myVector.length);
	}	
}