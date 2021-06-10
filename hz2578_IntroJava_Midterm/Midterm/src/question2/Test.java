package question2;
public class Test {
	public static void main (String[] args)  {		
		//public MyVector(int n)
		MyVector a = new MyVector(5);
		System.out.println(a.toString() + "\n");		
		//public void save(String filename)
		a.save("fiveZeros.txt");		
		//public static MyVector read(String filename)
		MyVector b = new MyVector(0);
		try {
			b = MyVector.read("fiveZeros.txt");
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		}
		System.out.println(b.toString() + "\n");		
		//public MyVector sum(MyVector v) throws InCompatibleDimensions
		MyVector c = new MyVector(5);
		for( int i = 0; i < c.myVector.length; i++) {
			c.setData(i, i+2);
		}
		System.out.println(c.toString());
		MyVector d = new MyVector(5);
		for( int i = 0; i < d.myVector.length; i++) {
			d.setData(i, i-1);
		}
		System.out.println(d.toString());
		try {
			System.out.println(c.sum(d).toString() + "\n");
		} catch (InCompatibleDimensions e) {
			e.printStackTrace();
		}
		//public MyVector multiply(MyVector v) throws InCompatibleDimensions
		try {
			System.out.println(c.multiply(d) + "\n");
		} catch (InCompatibleDimensions e) {
			e.printStackTrace();
		}
		//InCompatibleDimensions
		MyVector e = new MyVector(6);
		for( int i = 0; i < e.myVector.length; i++) {
			e.setData(i, i);
		}
		System.out.println(e.toString());
		try{
			System.out.println(c.sum(e).toString());
		}catch(InCompatibleDimensions icd) {
			icd.printStackTrace();
		}
		System.out.println();		
		//InvalidFileFormatException
		try {
			b = MyVector.read("strangeData.txt");
		} catch (InvalidFileFormatException iffe) {
			iffe.printStackTrace();
		}
		System.out.println(b.toString() + "\n");		
		//NumberFormatException
		try {
			b = MyVector.read("badData.txt");
		} catch (InvalidFileFormatException e1) {
			e1.printStackTrace();
		}
		System.out.println(b.toString() + "\n");
	}
}