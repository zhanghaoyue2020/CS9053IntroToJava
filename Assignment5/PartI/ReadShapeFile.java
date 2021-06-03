import java.io.*;
import java.util.ArrayList;
import shapes.*;
/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFile {
	public static GeometricObject createShape(String shapeName)throws ShapeException {
		/* if shapeName is "Circle" return Circle();
		 * if shapeName is "Square" return Square();
		 * if shapeName is "Rectangle" return Rectangle();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */		
		if (shapeName.equals("Circle"))
			return new Circle();
		else if (shapeName.equals("Square"))
			return new Square();
		else if (shapeName.equals("Rectangle"))
			return new Rectangle();
		else
			throw new ShapeException(shapeName);
	}	
	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("shapes.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
		}catch(FileNotFoundException fnfe) {
			System.err.println("file not found: " + fnfe.getMessage());
			System.exit(1);
		}
		String inString = null;
		br = new BufferedReader(fr);		
		/* create a loop to read the file line-by-line */
		try {
			inString = br.readLine();
			while(inString != null) {
				try{
					GeometricObject shape = createShape(inString);
					shapeList.add(shape);
				}catch (ShapeException se) {
					System.err.println("Cannot create shape: " + inString);
				}
				inString = br.readLine();
			}
		}catch(IOException ioe) {
			System.err.println("IOException: " + ioe.toString());
		}
		for(int i = 0; i < shapeList.size(); i++)
		System.out.println((i+1) +" "+ shapeList.get(i));
	}	
}