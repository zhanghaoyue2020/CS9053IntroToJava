# CS9053IntroToJava
2021spring

note：https://docs.google.com/document/d/1omLIzwM-K-tvGMOCcawv1uhK9Oap50c5Dk7gv4a-6qw/edit#heading=h.lravd7pgx9cb

##### [Part 1: Input and Output](https://github.com/zhanghaoyue2020/CS9053IntroToJava#part-1-input-and-output) 
[0. Location](https://github.com/zhanghaoyue2020/CS9053IntroToJava#0-location)
[1. Welcome](https://github.com/zhanghaoyue2020/CS9053IntroToJava#1-welcome)
[2. output](https://github.com/zhanghaoyue2020/CS9053IntroToJava#2-output)
[3. input](https://github.com/zhanghaoyue2020/CS9053IntroToJava#3input)

##### [Part 2: Int, Double, String, and Time](https://github.com/zhanghaoyue2020/CS9053IntroToJava#part-2-int-doublestring-and-time)
[4. int and double](https://github.com/zhanghaoyue2020/CS9053IntroToJava#4-int-and-double)
[5. string](https://github.com/zhanghaoyue2020/CS9053IntroToJava#5-string)
[6. System.currentTimeMillis()](https://github.com/zhanghaoyue2020/CS9053IntroToJava#6systemcurrenttimemillis)

##### [Part 3: Classes and Interfaces](https://github.com/zhanghaoyue2020/CS9053IntroToJava#part-3-classes-and-interfaces)
[7. Classes](https://github.com/zhanghaoyue2020/CS9053IntroToJava#7-classes)
[8. interfaces](https://github.com/zhanghaoyue2020/CS9053IntroToJava#8-interfaces)

##### [Part 4: Container (lecture 09)](https://github.com/zhanghaoyue2020/CS9053IntroToJava#part-4-container-lecture-09)
[9. Concrete classes](https://github.com/zhanghaoyue2020/CS9053IntroToJava#9-concrete-classes)
[10. Maps](https://github.com/zhanghaoyue2020/CS9053IntroToJava#10-maps)

##### [Part 5:  Try and Catch](https://github.com/zhanghaoyue2020/CS9053IntroToJava#part-5-try-and-catch)
[11. Exception](https://github.com/zhanghaoyue2020/CS9053IntroToJava#11-exception)
[12. file open, read, write](https://github.com/zhanghaoyue2020/CS9053IntroToJava#12-fileopen-read-write)

##### [Part 6: Threads (Lecture 10)](https://github.com/zhanghaoyue2020/CS9053IntroToJava#part-6-threads-lecture-10)
[13. thread and runnable](https://github.com/zhanghaoyue2020/CS9053IntroToJava#13-thread-and-runnable)
[14. Sync](https://github.com/zhanghaoyue2020/CS9053IntroToJava#14-sync)

##### [Part 7: GUI (Lecture 08, Lecture 09)](https://github.com/zhanghaoyue2020/CS9053IntroToJava#part-7-gui-lecture-08-lecture-09)

##### [Part 8: IOStream (Lecture 11)]

##### [Part 9: DataBase (Lecture 12)]


## Part 1: Input and Output
### 0. Location
package includes only classes and interfaces, pictures must be put under the project file.

![image](https://user-images.githubusercontent.com/85269000/202542010-9c8e422e-c5cb-473e-8381-d9a3db748027.png)

### 1. Welcome
```
public class Welcome {	
	public static void main(String[] args) { 
		System.out.println("Welcome to Java!");
	}
}
```
### 2. output

format output
```
public class FormatDemo { 
    public static void main(String[] args) { 
        System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "Degrees", "Radians", "Sine", "Cosine", "Tangent");

        int degrees = 30;
        double radians = Math.toRadians(degrees);
        System.out.printf("%-10d%-10.4f%-10.4f%-10.4f%-10.4f\n", degrees, radians, Math.sin(radians), Math.cos(radians), Math.tan(radians));

        degrees = 60;
        radians = Math.toRadians(degrees);
        System.out.printf("%-10d%-10.4f%-10.4f%-10.4f%-10.4f\n", degrees, radians, Math.sin(radians), Math.cos(radians), Math.tan(radians));
    }
}

/*
Degrees   Radians   Sine      Cosine    Tangent   
30        0.5236    0.5000    0.8660    0.5774    
60        1.0472    0.8660    0.5000    1.7321    
*/
```
lambda
```
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IterateList {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3);
		
		for (int i = 0; i< intList.size() ; i++) {
			System.out.print(intList.get(i)+"\t");
		}	
		System.out.println();

		for (Integer i : intList) {
			System.out.print(i*i+"\t");
		}
		System.out.println();

		intList.forEach(new Consumer<Integer>() {
			public void accept(Integer i) {
				System.out.print(i+"\t");
			}
		});
		System.out.println();
			
		intList.forEach((Integer i) -> 	System.out.print(i+"\t"));
		System.out.println();	

		intList.forEach((i) -> 	System.out.print(i*i+"\t"));
		System.out.println();
	}
}

/*
1	2	3	
1	4	9	
1	2	3	
1	2	3	
1	4	9	
*/
```

### 3. input

Scanner
```
import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
        System.out.print("Enter an integer: ");
		int v1 = input.nextInt();
		System.out.println("v1 is " + v1);
		
		System.out.print("Enter a double value: ");
		double v2 = input.nextDouble();
		System.out.println("v2 is " + v2);

        System.out.print("Enter a string:");
        String v3 = input.nextLine();
        System.out.println("v3 is " + v3);
	}
}

/*
Enter an integer: 12
v1 is 12
Enter a double value: 12
v2 is 12.0
Enter a string: 12
v3 is 12
*/
```
Function
```
import java.util.function.Function;

public class UsingFunction {
	public static void main (String[] args) {
		Function<Integer, Double> half = a -> a/2.0;
		System.out.println(half.apply(10));
	}
}

/*
5.0
*/
```
Comparator
```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortingExample implements Comparator<String> {
	public int compare(String first, String second) {
		return first.length() - second.length();
	}
	
	public static void main(String[] args) {
		String[] stringArray = {"Dean", "Maria", "Bob", "Constantine", "Ivan", "Boris"};
		System.out.println("original array: " + Arrays.toString(stringArray));

		Arrays.sort(stringArray);
		System.out.println("sorted array1 (default): \t" + Arrays.toString(stringArray));
		
		Arrays.sort(stringArray, new SortingExample());
		System.out.println("sorted array2 (self-defined):\t" + Arrays.toString(stringArray));
		
		Arrays.sort(stringArray, (String first, String second) -> (first.length() - second.length()));		
		System.out.println("sorted array3 (lambda): \t" + Arrays.toString(stringArray));
		
		ArrayList<String> al = new ArrayList<String>();
		for (String s : stringArray) {
			al.add(s);
		}
		al.sort( (String s1, String s2) -> s1.compareTo(s2));
		System.out.println("sorted arraylist1 (lambda)\t" + al);

		al.sort( (String s1, String s2) -> -s1.compareTo(s2));
		System.out.println("sorted arraylist2 (lambda)\t" + al);
		
		al.removeIf((String s) -> s == "Dean");
		System.out.println("sorted arraylist3 (lambda)\t" + al);
	}
}

/*
original array: [Dean, Maria, Bob, Constantine, Ivan, Boris]
sorted array1 (default): 	    [Bob, Boris, Constantine, Dean, Ivan, Maria]
sorted array2 (self-defined):	[Bob, Dean, Ivan, Boris, Maria, Constantine]
sorted array3 (lambda): 	    [Bob, Dean, Ivan, Boris, Maria, Constantine]
sorted arraylist1 (lambda)	    [Bob, Boris, Constantine, Dean, Ivan, Maria]
sorted arraylist2 (lambda)	    [Maria, Ivan, Dean, Constantine, Boris, Bob]
sorted arraylist3 (lambda)	    [Maria, Ivan, Constantine, Boris, Bob]
*/
```
## Part 2: Int, Double, String, and Time
### 4. int and double
Math, Integer.MIN_VALUE
```
public class Literals {
	public static void main(String[] args) {
		final int SIZE =5;
		double pi_val = Math.PI;
		double square = Math.pow(5,2);
		double num = Math.floor(5.5);
		int INT_MIN = Integer.MIN_VALUE;
		double doubleLiteral = 1.23456e2;
		System.out.println(SIZE +"\n"+pi_val+"\n"+square+"\n"+num+"\n"+INT_MIN+"\n"+doubleLiteral);
	}
}
/*
5
3.141592653589793
25.0
5.0
-2147483648
123.456
*/
```
common false
```
import java.util.Scanner;

public class CommonErrors {
	public static void main(String[] args) {
		int value = 2147483647 + 1;
		System.out.println("value is " + value);
		System.out.println(1.0 - 0.1 -0.1 - 0.1 -0.1 - 0.1);
		System.out.println(1.0 -0.9);
	}	
}

/*
value is -2147483648
0.5000000000000001
0.09999999999999998
*/
```

integer pool
```
import java.util.ArrayList;

public class IntegerPool {
	public static void main(String[] args) {
		Number n1 = new Integer(10);
		Number n2 = new Float(12.5);
		Integer n3 = new Integer(5);

		Integer c = 127;
		Integer d = 127;
		System.out.println(c==d); // true
		Integer e = 128;
		Integer f = 128;
		System.out.println(e==f); // false
		System.out.println(e.equals(f)); // true
		
		Integer g = -128;
		Integer h = -128;
		System.out.println(g==h); // true		
		Integer i = -129;
		Integer j = -129;
		System.out.println(i==j); // false		
		System.out.println(i.equals(j)); // true
	}
}

/*
true
false
true
true
false
true
*/
```
### 5. string
convert string to int and double
```
import java.util.Scanner;

public class ConvertStringsAndNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

	    System.out.print("Enter an integer: ");
	    String input_string = input.nextLine();
	    
	    int intValue = Integer.parseInt(input_string);
	    System.out.println("You entered the number " + intValue);
	    
	    double doubleValue = Double.parseDouble(input_string);
	    System.out.println("As a floating point value it would be " + doubleValue);
	}
}

/*
Enter an integer: 1
You entered the number 1
As a floating point value it would be 1.0
*/
```

string.indexOf(char or string)
```
public class StringIndexes {
	public static void main(String[] args) {
		String className = "Introduction to Java Programming";
		System.out.println("Index of the first occurence of 'n' is " + className.indexOf('n'));
		System.out.println("Index of the last occurence of 'n' is " + className.lastIndexOf('n'));
		System.out.println("Index of the first occurence of \"ro\" is " + className.indexOf("ro"));
		System.out.println("Index of the last occurence of \"ro\" is " + className.lastIndexOf("ro"));
	}
}

/*
Index of the first occurence of 'n' is 1
Index of the last occurence of 'n' is 30
Index of the first occurence of "ro" is 3
Index of the last occurence of "ro" is 22
*/
```
string1.compareTo(string2) <0
```
import java.util.Scanner;

public class OrderTwoCities {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first city: ");
		String city1 = input.nextLine();
		System.out.print("Enter the second city: ");
		String city2 = input.nextLine();
    
		if (city1.compareTo(city2) < 0)
			System.out.println("The cities in alphabetical order are " + city1 + " " + city2);
		else if (city1.compareTo(city2) > 0)
			System.out.println("The cities in alphabetical order are " + city2 + " " + city1);
		else
			System.out.println("The cities are identical");
	}
}

/*
Enter the first city: Shanghai
Enter the second city: Beijing
The cities in alphabetical order are Beijing Shanghai
*/
```
pointer
```
import shapes.*;

public class StringLiterals {
	public static void main(String[] args) {
		String a = "Circle"; //a = "Circle"
		String b = "Circle"; //b = "Circle"
		String c = new String("Circle"); // c= &"Circle"1
		String d = new String("Circle"); // d= &"Circle"2
		String e = c; // e = &"Circle"1
		System.out.println(a == b); // a=b
		System.out.println(b == c); // b!=c
		System.out.println(c == d); // c!=d
		System.out.println(c == e); // c=e
		c = new String("Circle"); // c= &"Circle"3
		System.out.println(c == e); // c!=e
	}
}

/*
true
false
false
true
false
*/
```
###  6. System.currentTimeMillis()
```
public class ShowCurrentTime {
	public static void main(String[] args) {
		long total_milliseconds = System.currentTimeMillis();
		long total_seconds = total_milliseconds / 1000;
		long current_second = total_seconds % 60;
		long total_minutes = total_seconds / 60;
		long current_minute = total_minutes % 60;
		long total_hours = total_minutes / 60;
		long current_hour = total_hours % 24;
		System.out.println("Current time is " + current_hour + ":" + current_minute + ":" + current_second + " GMT");
	}
}
```
## Part 3: Classes and Interfaces
### 7. Classes
default value
```
public class Student {
	String name; // name has default value null
	int age; // age has default value 0
	boolean isScienceMajor; // isScienceMajor has default value false
	char gender; // c has default value '\u0000'
}
```
```
public class TestStudent {
	public static void main(String[] args) {
		Student student = new Student();
	    System.out.println("name?            " + student.name); 
	    System.out.println("age?             " + student.age); 
	    System.out.println("isScienceMajor?  " + student.isScienceMajor); 
	    System.out.println("gender?          " + student.gender); 
	}
}

/*
name?            null
age?             0
isScienceMajor?  false
gender?          
*/
```
safe class
```
public class FullFeaturedCircle {
	private static int numObjects = 0;
	private int circleID;
	private double radius = 1.0;
	
	public FullFeaturedCircle() {
		this.circleID = FullFeaturedCircle.numObjects;
		FullFeaturedCircle.numObjects++;
	}
	
	public FullFeaturedCircle(double radius) {
		this();
		this.radius = radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public int getID() {
		return this.circleID;
	}
}
```
```
public class TestFullFeaturedCircle {
	public static void main(String[] args) {
		FullFeaturedCircle circle1 = new FullFeaturedCircle();
		System.out.println("circle1 has radius " + circle1.getRadius() + " and area " + circle1.getArea() + " and ID " + circle1.getID());
		
		FullFeaturedCircle circle2 = new FullFeaturedCircle(4.5);
		System.out.println("circle2 has radius " + circle2.getRadius() + " and area " + circle2.getArea() + " and ID " + circle2.getID());
		
		changeRadius(circle1, 5);
		System.out.println("new radius for circle1 is " + circle1.getRadius() + " which gives a new area of  "+ circle1.getArea() + " even though the radius is still " + circle1.getID());
	}
	
	public static void changeRadius(FullFeaturedCircle c, double newRadius) {		
		c.setRadius(newRadius);
	}
}

/*
circle1 has radius 1.0 and area 3.141592653589793 and ID 0
circle2 has radius 4.5 and area 63.61725123519331 and ID 1
new radius for circle1 is 5.0 which gives a new area of  78.53981633974483 even though the radius is still 0
*/
```
Object, extends,  and instanceof
```
import java.util.Date;

public class GeometricObject /*extents Object*/ {
	private String color = "red";
	private boolean filled = true;
	private Date dateCreated = null;
	
	public GeometricObject() {
		this.color = "green";
		this.filled = true;
		this.dateCreated = new Date();
	}
	
	public GeometricObject(String color, boolean filled) {
		this();
		this.color = color;
		this.filled = filled;		
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return this.filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public String toString() {
		return "Shape[color=" + this.color + ", filled=" + this.filled + "]";
	}
}
```
```
public class Rectangle extends GeometricObject {
	private double width = 1.0;
	private double length = 1.0;
	
	public Rectangle() {
		this.width = 1.0;
		this.length = 1.0;
	}
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	public Rectangle(double width, double length, String color, boolean filled) {
		super(color,filled);
		this.width = width;
		this.length = length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public double getArea() {
		return this.width * this.length;
	}
	
	public double getPerimeter() {
		return 2*this.width + 2*this.length;
	}
	
	public String toString() {
		return "Rectangle[" + super.toString() + ",width=" + this.width + ",length=" + this.length + "]";
	}
}
```
```
public class Circle extends GeometricObject {
	private double radius = 1.0;
	
	public Circle() {
		this.radius = 1.0;
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI*this.radius*this.radius;
	}
	
	public double getPerimeter() {
		return Math.PI*2*this.radius;
	}
	
	public double getDiameter() {
		return 2*this.radius;
	}
	
	public String toString() {
		return "Circle[" + super.toString() + ", radius=" + this.radius + "]";
	}
}
```
```
public class Square extends Rectangle {
	public Square() {
		super(1.0,1.0);
	}
	
	public Square(double side) {
		super(side, side);
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}
	
	public void setSide(double side) {
		super.setLength(side);
		super.setWidth(side);		
	}
	
	public double getSide() {
		return this.getLength();
	}
		
	public void setWidth(double width) {
		this.setSide(width);
	}
	
	public void setLength(double length) {
		this.setSide(length);
	}

	public String toString() {
		return "Square[" + super.toString()  + "]";
	}
}
```
```
public class CastingDemo {
	public static void displayObject(Object object) {
		if (object instanceof Circle) {
			System.out.println("The circle area is " + ((Circle)object).getArea());
			System.out.println("The circle diameter is " + ((Circle)object).getDiameter());
		}
		else if (object instanceof Rectangle) {
			System.out.println("The rectangle area is " + ((Rectangle)object).getArea());
	    }
	}

    public static void main(String[] args) {
		Object object1 = new Circle(1);
		Object object2 = new Square(1);

		displayObject(object1);
	    displayObject(object2);
	}
}

/*
The circle area is 3.141592653589793
The circle diameter is 2.0
The rectangle area is 1.0
*/
```

default class and invoking flow:
```
public class Person {
	public Person() {
		System.out.println("(1) Person's no-arg constructor is invoked"); 
	}
}
```
```
class Employee extends Person {

	public Employee() {
		this("(2) Invoke Employee’s overloaded constructor");
		System.out.println("(3) Employee's no-arg constructor is invoked");
	}
	
	public Employee(String s) {
		System.out.println(s);
	}
}
```
```
public class Faculty extends Employee {
	public Faculty() {
		System.out.println("(4) Faculty's no-arg constructor is invoked");
	}
}

public class Tom extends Faculty {
}

public class Test {
	public static void main(String[] arg) {
		new Tom();
	}
}

/*
(1) Person's no-arg constructor is invoked
(2) Invoke Employee’s overloaded constructor
(3) Employee's no-arg constructor is invoked
(4) Faculty's no-arg constructor is invoked
*/
```

abstract class, abstract method (Override)
```
public abstract class GeometricObject implements Comparable<GeometricObject> {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}
	
	public abstract double getArea();
	public abstract double getPerimiter();
	
	public int compareTo(GeometricObject o) {
		return Double.compare(this.getArea(), o.getArea());
	}
}
```
```
public class Circle extends GeometricObject {
	private double radius;
	
	public Circle() {
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
	
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public double getPerimiter() {
		return 2*radius * Math.PI;
	}
	
	public String toString() {
		return "The circle is created  " + getDateCreated() + " radius = " + this.radius;
	}
}
```
```
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
	
	public double getArea() {
		return width*height;
	}

	public double getPerimiter() {
		return 2*(width+height);
	}
	
	public String toString() {
		return "The rectangle is created  " + getDateCreated() + " width = " + this.width + ", height = " + this.height;
	}
}
```
```
import java.util.HashSet;

public class ObjectPrinter<T extends GeometricObject> {
	private HashSet<T> objSet = new HashSet<T>();
	
	public void add(T t) {
		objSet.add(t);
	}
	
	public void printObjects() {
		for (T t : objSet) {
			System.out.println(t.toString());
		}
	}
	
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		Rectangle rect = new Rectangle(4,5);
		
		ObjectPrinter<GeometricObject> objectPrinter = new ObjectPrinter<GeometricObject>();
		objectPrinter.add(circle);
		objectPrinter.add(rect);
		
		objectPrinter.printObjects();
	}
}

/*
The circle is created  Mon Nov 14 07:14:44 EST 2022 radius = 5.0
The rectangle is created  Mon Nov 14 07:14:44 EST 2022 width = 4.0, height = 5.0
*/
```

inner classes 
```
public class ShowInnerClass {
	private int data =0 ;

	public void m() {
		InnerClass instance = new InnerClass();
		instance.mi();
	}

	private void printData() {
		System.out.println("Data: "+this.data);
	}
	
	class InnerClass {
		public void mi() {
			data++;
			printData();
		}
	}
	
	public static void main(String[] args) {
		ShowInnerClass ob1 = new ShowInnerClass();
		ob1.m();
		ShowInnerClass.InnerClass ob2 = ob1.new InnerClass();
		ob2.mi();	
	}
}

/*
Data: 1
Data: 2
*/
```

### 8. interfaces
#### self-defined interface

Maybe it's only used to make sure you include some specific methods in your own classes, class is able to replace it at most times.

variables in an interface are 'public static final'; methods are 'public abstract'.
```
public interface Edible {
	public abstract String howToEat();
}
```
```
public abstract class Fruit implements Edible{
	String name = null;
	
	public Fruit(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "This is a fruit with name " + this.name;
	}
}
```
```
public class Apple extends Fruit {
	public String species;
	
	public Apple() {
		super("Apple");
		this.species = "Red Delicious";
	}
	
	public String howToEat() {
		return "Apple: Make Apple Cider";
	}
	
	public String toString() {		
		return super.toString() + " " + "This is an Apple of species " + this.species;
	}
}
```
```
public class Orange extends Fruit {
	
	public Orange(String name) {
		super(name);
		System.out.println("Orange's constructor is invoked");
	}

	public String howToEat() {
		return "Orange: Make orange juice";
	}
}
```
```
import java.util.ArrayList;

public class TestEdibles {
	public static void main(String[] args) {
		Apple a = new Apple();
		Orange o = new Orange("Orange");
		
		ArrayList<Edible> edibleList = new ArrayList<Edible>();
		edibleList.add(a);
		edibleList.add(o);
		
		for (int i = 0; i<edibleList.size();i++) {
			Edible myEdible = edibleList.get(i);
			System.out.println(myEdible.howToEat());
		}
	}
}

/*
Apple: Make Apple Cider
Orange: Make orange juice
*/
```
T and Wildcards
```
import java.util.Stack;

public class WildCardNeedDemo {
	public static double max(Stack<? extends Number> stack) {
		double max = stack.pop().doubleValue(); // initialize max
		while (!stack.isEmpty()) {
			double value = stack.pop().doubleValue();
			if (value > max)
				max = value;
	    }
	    return max;
	}
	
	public static void main(String[] args ) {
		Stack<Integer> intStack = new Stack<>();
	    intStack.push(1); // 1 is autoboxed into an Integer Object
	    intStack.push(2);
	    intStack.push(-2);

	    System.out.print("The max number is " + max(intStack)); // Error: 
	}
}

/*
The max number is 2.0
*/
```
## Part 4: Container (lecture 09)

![image](https://user-images.githubusercontent.com/85269000/202549463-dfcec803-9005-4065-bec3-b2ecfea54622.png)

### 9. Concrete classes
Arrays.asList();
```
import java.util.List;
import java.util.Arrays;

public class SortStringIgnoreCase {
	public static void main(String[] args) {
		List <String> cities = Arrays.asList("Atlanta", "Savannah", "new York", "dallas");
		cities.sort(null);
		cities.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

		for (String s: cities) {
			System.out.print(s + " ");
		}
	}
}

/*
Atlanta dallas new York Savannah 
*/
```
ArrayList<>, LinkedList<>
```
import java.util.*;

public class TestArrayAndLinkedList {
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>(); // C++: std::vector<int> arrayList;
		arrayList.add(1); // 1 is autoboxed to new Integer(1)
		arrayList.add(2); // C++: std::arrayList.push(1);
		arrayList.add(3);
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(0, 10);// C++: std::arrayList.insert(0, 10);
		arrayList.add(3, 30);
		
		System.out.println("A list of integers in the array list:");
		System.out.println(arrayList);

		LinkedList<Object> linkedList = new LinkedList<>(arrayList); 
		linkedList.add(1, "red");
		linkedList.removeLast();
		linkedList.addFirst("green");
		
		System.out.println("Display the linked list forward:"); 
		// C++: for(auto p = linkedList.begin();p!=linkedList.end();p++)
		for(ListIterator<Object> listIterator = linkedList.listIterator(); listIterator.hasNext();) { 
			System.out.print(listIterator.next() + " ");
		}
		System.out.println();
		
		System.out.println("Display the linked list backward:");
		for(ListIterator<Object> listIterator = linkedList.listIterator(linkedList.size()); listIterator.hasPrevious();) {
			System.out.print(listIterator.previous() + " ");
		}
		System.out.println();
	}
} 

/*
A list of integers in the array list:
[10, 1, 2, 30, 3, 1, 4]
Display the linked list forward:
green 10 red 1 2 30 3 1 
Display the linked list backward:
1 3 30 2 1 red 10 green 
*/
```
HashSet<>, LinkedHashSet<>
```
import java.util.*;

public class TestLinkedHashSet {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
   		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");
		System.out.println(set);

		for (String element: set) {
			System.out.print(element.toLowerCase() + " ");
		}  
		System.out.println();
		
		Set<String> set2 = new HashSet<>();
   		set2.add("London");
		set2.add("Paris");
		set2.add("New York");
		set2.add("San Francisco");
		set2.add("Beijing");
		set2.add("New York");
  
		for (String element: set2) {
			System.out.print(element.toLowerCase() + " ");
		}
		System.out.println();
	}
} 
/*
[London, Paris, New York, San Francisco, Beijing]
london paris new york san francisco beijing 
san francisco beijing new york london paris 
*/
```
TreeSet<>
```
import java.util.*;

public class TestTreeSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");
		
		TreeSet<String> treeSet = new TreeSet<>(set);
		System.out.println("Sorted tree set: " + treeSet);
		
		System.out.println("first():\t" + treeSet.first());
		System.out.println("last(): \t" + treeSet.last());
		System.out.println("headSet(\"New York\"):\t" + treeSet.headSet("New York"));
		System.out.println("tailSet(\"New York\"):\t" + treeSet.tailSet("New York"));
		System.out.println("lower(\"P\"):\t" + treeSet.lower("P")); // the greatest element that is strictly less than the given element
		System.out.println("higher(\"P\"):\t" + treeSet.higher("Paris"));  // the lowest element that is strictly greater than the given element
		System.out.println("floor(\"P\"):\t" + treeSet.floor("P")); // the greatest element that is less than or equal to the given element
		System.out.println("ceiling(\"P\"):\t" + treeSet.ceiling("Paris")); // the least element that is greater than or equal to the given element
		System.out.println("pollFirst():\t" + treeSet.pollFirst()); // retrieves and removes the lowest element
		System.out.println("pollLast():\t" + treeSet.pollLast()); // retrieves and removes the greatest element
		System.out.println("New tree set:\t" + treeSet);
	}
}

/*
Sorted tree set: [Beijing, London, New York, Paris, San Francisco]
first():	    Beijing
last():     	San Francisco
headSet("New York"):	[Beijing, London]
tailSet("New York"):	[New York, Paris, San Francisco]
lower("P"):	    New York
higher("P"):	San Francisco
floor("P"):	    New York
ceiling("P"):	Paris
pollFirst():	Beijing
pollLast():	    San Francisco
New tree set:	[London, New York, Paris]
*/
```
TreeSet<> with self-defined comparator
```
public abstract class GeometricObject implements Comparable<GeometricObject> {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	public abstract String toString();
	public abstract Double getArea();
		
	public int compareTo(GeometricObject o) {
		return this.getArea().compareTo(o.getArea());
	}		
}
```
```
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
	
	public String toString() {
		return "The rectangle is created  " + getDateCreated() + " width = " + this.width + ", height = " + this.height;
	}
}
```
```
public class Circle extends GeometricObject {
	private double radius;
	
	public Circle() {
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
	
	public String toString() {
		return "The circle is created  " + getDateCreated() + " radius = " + this.radius;
	}
}
```
```
import java.util.Comparator;

public class GeometricObjectComparator<T extends GeometricObject> implements Comparator<T> {
	public int compare(T o1, T o2) {
		if (o1.getArea() > o2.getArea()) {
			return 1;
		} else if (o1.getArea() == o1.getArea()) {
			return 0;
		} else {
			return -1;
		}
	}

    public static void main(String[] args) {
        Set<GeometricObject> set = new TreeSet<>(new GeometricObjectComparator());
        set.add(new Rectangle(4, 5));
        set.add(new Circle(40));
        set.add(new Circle(40));
        set.add(new Rectangle(4, 1));

        System.out.println("A sorted set of geometric objects");
        for (GeometricObject element: set){
            System.out.println("area = " + element.getArea());
        }
    }
}
```
```
import java.util.ArrayList;

public class ListShapes {
	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		
		Circle circle = new Circle(5);
		Rectangle rect = new Rectangle(4,5);
		Circle circle2 = new Circle(2);
		shapeList.add(rect);
		shapeList.add(circle2);
		shapeList.add(circle);
		
		shapeList.sort( (a, b) -> (a.getDateCreated().compareTo(b.getDateCreated())));

		for (int i = 0; i < shapeList.size();i++) {
			GeometricObject shape = shapeList.get(i);
			System.out.println(shape);
		}
	}
}
```

Compare set and list
```
import java.util.*;

public class SetListPerformanceTest {
	static final int N = 50000;

	public static long getTestTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			c.contains((int)(Math.random() * 2 * N));
		return System.currentTimeMillis() - startTime; 
	}
 
	public static long getRemoveTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			c.remove(i);
		return System.currentTimeMillis() - startTime; 
	}

	public static void main(String[] args) {  
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(i);
		Collections.shuffle(list); // Shuffle the array list
   
		Collection<Integer> set1 = new HashSet<>(list);
		System.out.println("Member test time for hash set is " + getTestTime(set1) + " milliseconds");
		System.out.println("Remove element time for hash set is " + getRemoveTime(set1) + " milliseconds");
   
		Collection<Integer> set2 = new LinkedHashSet<>(list);
		System.out.println("Member test time for linked hash set is " + getTestTime(set2) + " milliseconds");
		System.out.println("Remove element time for linked hash set is " + getRemoveTime(set2) + " milliseconds");

		Collection<Integer> set3 = new TreeSet<>(list);
		System.out.println("Member test time for tree set is " + getTestTime(set3) + " milliseconds");
		System.out.println("Remove element time for tree set is " + getRemoveTime(set3) + " milliseconds");

		Collection<Integer> list1 = new ArrayList<>(list);
		System.out.println("Member test time for array list is " + getTestTime(list1) + " milliseconds");
		System.out.println("Remove element time for array list is " + getRemoveTime(list1) + " milliseconds");

		Collection<Integer> list2 = new LinkedList<>(list);
		System.out.println("Member test time for linked list is " + getTestTime(list2) + " milliseconds");
		System.out.println("Remove element time for linked list is " + getRemoveTime(list2) + " milliseconds");
	}
}

/*
Member test time for hash set is 12 milliseconds
Remove element time for hash set is 9 milliseconds
Member test time for linked hash set is 8 milliseconds
Remove element time for linked hash set is 7 milliseconds
Member test time for tree set is 13 milliseconds
Remove element time for tree set is 10 milliseconds
Member test time for array list is 1661 milliseconds
Remove element time for array list is 566 milliseconds
Member test time for linked list is 2719 milliseconds
Remove element time for linked list is 1090 milliseconds
*/
```

PriorityQueue<>
```
import java.util.*;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<String> queue1 = new PriorityQueue<>();
		queue1.offer("Oklahoma");
		queue1.offer("Indiana");
		queue1.offer("Georgia");
		queue1.offer("Texas");
		
		System.out.println("Priority queue using Comparable:");
		while (queue1.size() > 0) {
			System.out.print(queue1.remove() + " ");
		}
		System.out.println();
		
		PriorityQueue<String> queue2 = new PriorityQueue<>(4, Collections.reverseOrder());
		queue2.offer("Oklahoma");
		queue2.offer("Indiana");
		queue2.offer("Georgia");
		queue2.offer("Texas");

		System.out.println("Priority queue using Comparator:");
		while (queue2.size() > 0) {
			System.out.print(queue2.remove() + " ");
		}
		System.out.println();
	}
}

/*
Priority queue using Comparable:
Georgia Indiana Oklahoma Texas 
Priority queue using Comparator:
Texas Oklahoma Indiana Georgia 
*/
```

Stack<>
```
import java.util.Stack;

public class EvaluateExpression {
	public static String insertBlanks(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}   
		System.out.println(result);
		return result;
	}
	
	public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+') 
			operandStack.push(op2 + op1);
		else if (op == '-') 
			operandStack.push(op2 - op1);
		else if (op == '*') 
			operandStack.push(op2 * op1);
		else if (op == '/') 
			operandStack.push(op2 / op1);
	}
	
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
 		Stack<Character> operatorStack = new Stack<>();
 		expression = insertBlanks(expression);
		String[] tokens = expression.split(" ");

		for (String token: tokens) {
			if (token.length() == 0) 
				continue;
			// +,-: clear calculations before; push +,-;
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' ||	operatorStack.peek() == '-' || 	operatorStack.peek() == '*' ||	operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			}
			// +,-: clear calculations before; push *,/;
			else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
				while (!operatorStack.isEmpty() &&	(operatorStack.peek() == '*' ||	operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			}
			// (: mark;
			else if (token.trim().charAt(0) == '(') {
				operatorStack.push('(');
			}
			// ): clear calculations before; pop (
			else if (token.trim().charAt(0) == ')') {
				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.pop(); 
			}
			else { 
				operandStack.push(new Integer(token));
			}
		}

		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}

		return operandStack.pop();
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java EvaluateExpression \"expression\"");
			System.exit(1);
		}
		try {
			System.out.println(evaluateExpression(args[0]));
		}catch (Exception ex) {System.out.println("Wrong expression: " + args[0]);}
	}
}

/*
 ( 35 + 23 )  / 3 * 8 -  ( 3 + 6 ) 
143
*/
```

### 10. Maps
```
import java.util.*;

public class TestMap {
	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Smith", 30);
		hashMap.put("Anderson", 31);
		hashMap.put("Lewis", 29);
		hashMap.put("Cook", 29);
		System.out.println("Display entries in HashMap");
		System.out.println(hashMap + "\n");

		Map<String, Integer> treeMap = new TreeMap<>(hashMap);
		System.out.println("Display entries in ascending order of key");
		System.out.println(treeMap);

		Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
		linkedHashMap.put("Smith", 30);
		linkedHashMap.put("Anderson", 31);
		linkedHashMap.put("Lewis", 29);
		linkedHashMap.put("Cook", 29);		
		System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));		
		System.out.println("Display entries in LinkedHashMap");
		System.out.println(linkedHashMap);
   
		System.out.print("\nNames and ages are ");
		treeMap.forEach((name, age) -> System.out.print(name + ": " + age + " "));
	}
}

/*
Display entries in HashMap
{Lewis=29, Smith=30, Cook=29, Anderson=31}

Display entries in ascending order of key
{Anderson=31, Cook=29, Lewis=29, Smith=30}

The age for Lewis is 29
Display entries in LinkedHashMap
{Smith=30, Anderson=31, Cook=29, Lewis=29}

Names and ages are Anderson: 31 Cook: 29 Lewis: 29 Smith: 30 
*/
```
```
import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";
		Map<String, Integer> map = new TreeMap<>();
		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		map.forEach((k, v) -> System.out.println(k + "\t" + v));
	}
}

/*
a	    2
class	1
fun	    1
good	3
have	3
morning	1
visit	1
*/
```
## Part 5:  Try and Catch
### 11. Exception
ArithmeticException
```
import java.util.Scanner;

public class QuotientWithException { 
	public static int quotient(int number1, int number2) {
		if (number2 == 0)
			throw new ArithmeticException("number2==0");
		return number1 / number2;
	}
  
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
    
		try {
			int result = quotient(number1, number2);
			System.out.println(number1 + " / " + number2 + " is " + result);
		}
		catch (Exception ex) {
			System.out.println("Exception: "+ ex.toString());
			System.out.println("Exception: an integer cannot be divided by zero ");
		}

		System.out.println("Execution continues ...");
	}
}

/*
Enter two integers: 1 0
Exception: java.lang.ArithmeticException: number2==0
Exception: an integer cannot be divided by zero 
Execution continues ...
*/
```
InputMismatchException
```
import java.util.*;

public class InputMismatchExceptionDemo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		
		while (continueInput) {
			try {
				System.out.print("Enter an integer: ");
				int number = input.nextInt();
				System.out.println("The number entered is " + number);
				continueInput = false;
			} 
			catch (Exception ex) {
				System.out.println("Exception: "+ ex.toString());
				System.out.println("Try again. (Incorrect input: an integer is required)");
				input.nextLine(); // discard input 
			}
		} 
	}
}

/*
Enter an integer: q
Exception: java.util.InputMismatchException
Try again. (Incorrect input: an integer is required)
Enter an integer: 1
The number entered is 1
*/
```
IOException
```
import java.io.IOException;

public class TestException {
	void f2() throws Exception{
		throw new IOException("This doesn't exit.");
	}
	
	void f1() throws Exception{
		f2();
	}
	
	public static void main(String[] args) {
		TestException e = new TestException();
		try {
			e.f1();
		}
		catch(Exception ex) {
			System.out.println("Exception: "+ ex.toString());
			System.out.println("Print stack trace:");
			ex.printStackTrace();
		}
	}
}

/*
Exception: java.io.IOException: This doesn't exit.
Print stack trace:
java.io.IOException: This doesn't exit.
	at exceptions.TestException.f2(TestException.java:7)
	at exceptions.TestException.f1(TestException.java:11)
	at exceptions.TestException.main(TestException.java:17)
*/
```

IllegalArgumentException
```
public class Circle{
	private double radius = 1.0;
	
	public Circle() {
		this.radius = 1.0;
	}
	
	public Circle(double radius) throws Exception{
		if (radius >=0 ) 
			this.radius = radius;
		else 
			throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) {
		try {
			new Circle(-1);
		}
		catch(Exception ex) {
			System.out.println("Exception: "+ex.toString());
		}
	}
}

/*
Exception: java.lang.IllegalArgumentException
*/
```

self-defined exception
```
public class InvalidRadiusException extends Exception {
	private double radius;
	public InvalidRadiusException(double radius) {
		super("Invalid radius " + radius);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
}
```
```
public class Circle{
	private double radius = 1.0;
	
	public Circle() {
		this.radius = 1.0;
	}
	
	public Circle(double radius) throws InvalidRadiusException{
		if (radius >=0 ) 
			this.radius = radius;
		else 
			throw new InvalidRadiusException(radius);
	}
	
	public static void main(String[] args) {
		try {
			new Circle(-1);
		}
		catch(Exception ex){
			System.out.println("Exception: "+ ex.toString());
		}
	}
}

/*
Exception: shapes.InvalidRadiusException: Invalid radius -1.0
*/
```

### 12. file open, read, write
open
```
import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File myFile = new File("data.txt");
		System.out.println("File exists: "+ myFile.exists());
		System.out.println("File length: "+ myFile.length());
		System.out.println("File path: "+ myFile.getAbsolutePath());
	}
}

/*
File exists: true
File length: 26
File path: /home/luna/Downloads/Lecture05/data.txt
*/
```
reed a file
```
import java.io.*;

public class ReadIntoArray {
	public static void main(String[] args) { 
		int[] arr = new int[15]; 
		
		FileReader f =null;
		try {
			f = new FileReader("data.txt");
		}
		catch(Exception ex) {System.out.println("Exception: "+ ex.toString());}
		
		BufferedReader in = new BufferedReader(f); 
		try {
			int i=0; 
			while (true) { 
				String linea = in.readLine(); 
				System.out.print(linea+"\t");
				arr[i++] = Integer.parseInt(linea); 
				if(linea==null)
					break;
			} 
		}		
		catch(Exception ex) {System.out.println("Exception: "+ ex.toString());}

		try {
			f.close(); 
		}
		catch(Exception ex) {System.out.println("Exception: "+ ex.toString());}
		
		for(int num: arr) {
			System.out.print(num+"\t");
		}
	}
}

/*
10	5	2	3	5	94	A	Exception: java.lang.NumberFormatException: For input string: "A"
10	5	2	3	5	94	0	0	0	0	0	0	0	0	0	
*/

/*
10	5	2	3	5	94	23	45	2	5	1	12	23	22	1	2	Exception: java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 15
10	5	2	3	5	94	23	45	2	5	1	12	23	22	1	
*/
```

write data to a file
```
import java.io.*;
import java.util.Scanner;

public class WriteOutput {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		FileWriter fout = null;
		try {
			fout = new FileWriter("outputfile.txt");
		} catch (Exception ex) {System.out.println("Exception: "+ex.toString());}
		
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(fout);
		} catch (Exception ex) {System.out.println("Exception: "+ex.toString());}
		
		String ln = null;
		while (true) {
			System.out.print("Input data: ");
			ln = in.nextLine();
			if(ln.equals("-1"))
				break;
			try {
				out.write(ln);
				out.newLine();
				out.flush();
			} catch (Exception ex) {System.out.println("Exception: "+ex.toString());}
		}
		
		try {
			fout.close();
		} catch (Exception ex) {System.out.println("Exception: "+ex.toString());}
	}
}

/*
Input data: 1
Input data: 2
Input data: 3
Input data: -1
*/
```

## Part 6: Threads (Lecture 10)
### 13. thread and runnable

(interface) Runnable
```
class PrintChar implements Runnable{   
	private char charToPrint;
	private int times;
	
    public PrintChar (char charToPrint,int times) {
		this.charToPrint = charToPrint;
		this.times = times;
	}
	
    public void run() {
		for(int i = 0; i < this.times; i++) {
			System.out.print(this.charToPrint );
			if ((i+1) % 10 == 0) System.out.println();
			try{
				if(i>28) Thread.sleep(1);
			}catch (InterruptedException ex) { }
		}
	}
}
```
```
class PrintNum implements Runnable{
	private int lastNumber;
	public PrintNum (int lastNumber) {
		this.lastNumber = lastNumber;
	}
	public void run() {
		for(int i = 0; i < this.lastNumber; i++) {
			System.out.print((i+1)+" ");
			if ((i+1) % 10 == 0) System.out.println();
			try{
				if(i>28) Thread.sleep(1);
			}catch (InterruptedException ex) { }
		}
	}
}
```
```
public class TaskThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new PrintChar('a',80));
		Thread thread2 = new Thread(new PrintChar('b',30));
		Thread thread3 = new Thread(new PrintNum(50));		
		thread1.start();
		thread2.start();		
		thread2.join();
		System.out.println("\nthread 2 finished");
		thread3.start();		
		thread1.join();
		System.out.println("thread 1 finished");		
		thread3.join();
		System.out.println("thread 3 finished");
	}
}

/*
bbbbbbbbbaaaaaaaaaa
ab
bbbbbbbbabb
bbbbbbbaaaaaaaa
bbb
aaaaaaaaaa
a
thread 2 finished
1 2 3 4 5 6 7 8 9 10 
11 12 13 14 15 a16 17 18 19 20 
21 22 23 24 25 26 27 28 29 30 
a31 a32 a33 a34 a35 a36 a37 a
38 a39 a40 
a41 a42 a43 a44 a45 a46 a47 a
48 a49 a50 
aaaaaaaa
aaaaaaaaaa
aaaaaaaaaa
thread 1 finished
thread 3 finished
*/
```
ThreadPool
```
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(new PrintChar('a',30));
		executor.execute(new PrintChar('b',30));
		executor.execute(new PrintChar('c',30));
		executor.execute(new PrintChar('d',30));
		executor.execute(new PrintChar('e',30));
		executor.execute(new PrintChar('f',30));
		executor.execute(new PrintChar('g',30));		
	}
}

/*
aaaaaaaaaa
abbbbbbbbbb
bbbbbbbbbb
bbbbbbbbbb
ccccccaaaaaaaaa
acccc
cccaaaaaaaaccddddddda
cccddd
dddcc
cccccdddddccccc
dd
dddddddddd
eeeeeeeeee
eeeeeeeeee
eeeeefffffffffeeeee
ggggf
fffffffggggggfff
fffff
ggggfffff
gggggg
gggggggggg
*/
```
priority
```
class A extends Thread {
	public void run() {
		for (int i=0;i<100;i++) {
			Thread.yield();
			Thread.yield();
			Thread.yield();
			System.out.print("A");	
		}
		System.out.println("Exit from A");
	}
}
```
```
class B extends Thread {
	public void run() {
		for (int i=0;i<100;i++) {
			Thread.yield();
			Thread.yield();
			Thread.yield();
			System.out.print("B");	
		}
		System.out.println("Exit from B");
	}
}
```
```
class C extends Thread {
	public void run() {
		for (int i=0;i<100;i++) {
			Thread.yield();
			Thread.yield();
			Thread.yield();
			System.out.print("C");	
		}
		System.out.println("Exit from C");
	}
}
```
```
public class ThreadTest {
	public static void main(String[] args) {
		A a = new A();
		a.setPriority(Thread.MIN_PRIORITY);
		a.start();
		new B().start();
		C c = new C();
		c.setPriority(Thread.MAX_PRIORITY);
		c.start();
	}
}

/*
AAAAAAAABBBBBCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBCCAAAAAABCAAAAABBBBBBBBBBBBBBCCCCCCCAABBBBBBBBBCCCCCCCAAAAAABBBBBBBBCCCCCCCCCAAAAAAABBBBBBCCExit from B
AACACACACACACACACACACACACACACACACACExit from C
AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAExit from A
*/
```
### 14. Sync
```
public class Account {
	private static int idcount=0;
	private int accountid;
	private double balance;
	
	public Account() {
		balance=0;
		accountid = idcount++;
	}	
	
	public Account(double balance) {
		this();
		this.balance = balance;
	}	
	
	public double getBalance() {
		return this.balance;
	}	
	
	public void deposit(double dep) {
		balance += dep;
	}	
	
	public double withdraw(double with) {
		balance -= with;
		return balance;
	}
}
```
Without Sync
```
public class Bank {
	private volatile Account[] accounts;
	
	public Bank(int n, double initialBalance) {
		accounts = new Account[n];
		for (int j = 0;j< n ; j++) {
			accounts[j] = new Account(initialBalance);
		}
	}
	
	public int size() {
		return accounts.length;
	}
	
	public double getTotalBalance() {
		double sum = 0;
		for (Account a: accounts) {
			sum += a.getBalance();
		}
		return sum;
	}	
	
	public void transfer(int from, int to, double amount){		
		if (accounts[from].getBalance() < amount) 
			return;
		System.out.print(Thread.currentThread());
		accounts[from].withdraw(amount);
		try {
			Thread.sleep(1);
		} catch (Exception e) {e.printStackTrace();}
		accounts[to].deposit(amount);
		System.out.printf(" %10.2f from %2d to %2d    Total Balance: %10.2f%n",  amount, from, to, this.getTotalBalance());
	}

	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static final double MAX_AMOUNT = 1000;
	public static final int DELAY = 50;
	
	public static void main(String[] args) {
		Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < 100; i++) {
			Runnable r = () -> {
				while(true){
					int fromAccount = (int)(bank.size() * Math.random());
					int toAccount = (int)(bank.size() * Math.random());
					double amount = MAX_AMOUNT*Math.random();
					bank.transfer(fromAccount, toAccount, amount);
					try{
						Thread.sleep((int)(DELAY*Math.random()));
					}catch(Exception e) {}
				}
			};
			new Thread(r).start();
		}	
	}
}

/*
Thread[#99,Thread-78,5,main]     515.91 from 15 to 61    Total Balance:   98636.78
     168.52 from 12 to 59    Total Balance:   98805.30
     380.03 from 50 to 34    Total Balance:   99185.34
     814.66 from 19 to 26    Total Balance:  100000.00
Thread[#95,Thread-74,5,main]Thread[#77,Thread-56,5,main]Thread[#40,Thread-19,5,main]Thread[#22,Thread-1,5,main]Thread[#87,Thread-66,5,main]Thread[#23,Thread-2,5,main]     371.00 from 45 to 56    Total Balance:   98294.53
      41.71 from 74 to  8    Total Balance:   98336.25
Thread[#102,Thread-81,5,main]      25.25 from 69 to 39    Total Balance:   97526.04
Thread[#122,Thread-94,5,main]      60.88 from 86 to 51    Total Balance:   96778.77
Thread[#94,Thread-73,5,main]     874.25 from 25 to 86    Total Balance:   97438.07
     703.37 from 27 to 47    Total Balance:   98141.44
Thread[#25,Thread-4,5,main]Thread[#127,Thread-99,5,main]     835.46 from 41 to 19    Total Balance:   98066.13
Thread[#102,Thread-81,5,main]     808.15 from 24 to 78    Total Balance:   98739.60
*/
```
Data Sync
```
public class SyncDataBank{
	private Account[] syncAccounts;	
	
	public SyncDataBank(int n, double initialBalance) {
		syncAccounts = new Account[n];
		for (int j = 0;j< n ; j++) 	{
			syncAccounts[j] = new Account(initialBalance);
		}
	}
	
	public int size() {
		return syncAccounts.length;
	}
	
	public double getTotalBalance() {
		double sum = 0;
		for (Account a: syncAccounts) {
			sum += a.getBalance();
		}
		return sum;
	}
	
	public void transfer(int from, int to, double amount){
		if (syncAccounts[from].getBalance() < amount) 
			return;
		System.out.print(Thread.currentThread());
		syncAccounts[from].withdraw(amount);
		syncAccounts[to].deposit(amount);
		System.out.printf(" %10.2f from %2d to %2d    Total Balance: %10.2f%n",  amount, from, to, this.getTotalBalance());
	}
	
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static final double MAX_AMOUNT = 1000;
	public static final int DELAY = 10;
	
	public static void main(String[] args) {
		SyncDataBank bank = new SyncDataBank(NACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < 100; i++) {
			Runnable r = () -> {
				while(true){
					int fromAccount = (int)(bank.size() * Math.random());
					int toAccount = (int)(bank.size() * Math.random());
					double amount = MAX_AMOUNT*Math.random();
					bank.transfer(fromAccount, toAccount, amount);
					try{
						Thread.sleep((int)(DELAY*Math.random()));
					}catch(Exception e) {}
				}
			};
			new Thread(r).start();
		}	
	}
}
/*
Thread[#53,Thread-32,5,main]     330.48 from  0 to  6    Total Balance:  100000.00
Thread[#84,Thread-63,5,main]      40.41 from  0 to 34    Total Balance:  100000.00
Thread[#95,Thread-74,5,main]     616.51 from 91 to 55    Total Balance:  100000.00
Thread[#88,Thread-67,5,main]Thread[#65,Thread-44,5,main]     145.37 from  7 to 81    Total Balance:  100000.00
Thread[#55,Thread-34,5,main]     304.97 from 36 to 52    Total Balance:  100000.00
      20.36 from 43 to 93    Total Balance:  100000.00
Thread[#21,Thread-0,5,main]     298.92 from 15 to 79    Total Balance:  100000.00
Thread[#61,Thread-40,5,main]     181.16 from  5 to 45    Total Balance:  100000.00
Thread[#120,Thread-92,5,main]     123.24 from 13 to 78    Total Balance:  100000.00
*/
```
Method Sync
```
import java.util.*;
public class SyncMethodBank extends Bank {
	public SyncMethodBank(int n, double initialBalance) {
		super(n, initialBalance);
	}
	
	public synchronized void transfer(int from, int to, double amount) {
		super.transfer(from, to, amount);
	}
	
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static final double MAX_AMOUNT = 1000;
	public static final int DELAY = 10;
	
	public static void main(String[] args) {
		Bank bank = new SyncMethodBank(NACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < 10; i++) {
			Runnable r = () -> {
				while(true){
					int fromAccount = (int)(bank.size() * Math.random());
					int toAccount = (int)(bank.size() * Math.random());
					double amount = MAX_AMOUNT*Math.random();
					bank.transfer(fromAccount, toAccount, amount);
					try {
						Thread.sleep((int)(DELAY*Math.random()));
					} catch (InterruptedException e) {e.printStackTrace();}
				}
			};
			new Thread(r).start();
		}	
	}
}

/*
Thread[#27,Thread-6,5,main]     305.15 from 89 to 48    Total Balance:  100000.00
Thread[#25,Thread-4,5,main]     164.55 from 17 to 71    Total Balance:  100000.00
Thread[#28,Thread-7,5,main]     200.96 from  3 to 22    Total Balance:  100000.00
Thread[#22,Thread-1,5,main]     804.90 from 11 to 52    Total Balance:  100000.00
Thread[#28,Thread-7,5,main]      82.65 from 31 to 33    Total Balance:  100000.00
Thread[#28,Thread-7,5,main]     664.37 from 27 to 39    Total Balance:  100000.00
Thread[#27,Thread-6,5,main]      48.80 from 51 to 58    Total Balance:  100000.00
Thread[#24,Thread-3,5,main]     160.49 from 88 to  9    Total Balance:  100000.00
Thread[#25,Thread-4,5,main]      88.49 from 50 to 25    Total Balance:  100000.00
Thread[#25,Thread-4,5,main]     680.78 from 86 to 11    Total Balance:  100000.00
*/
```
Lock
```
class Account {
	private Lock lock = new ReentrantLock(); // Create a lock
	private int balance = 0;
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		lock.lock(); //get the lock
		balance = balance+amount;
		lock.unlock(); // Release the lock
	}
}
```
```
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AccountWithSyncUsingLock {
	private static Account account = new Account();	
	
	static class AddAPennyTask implements Runnable {
		static int NUM_TASKS = 0;
		int id;
		public AddAPennyTask() {
			this.id =NUM_TASKS;
			NUM_TASKS+=1;
		}
		public void run() {
			System.out.println("task " + id + " about to deposit");
			account.deposit(1);
			System.out.println("task " + id + " completed deposit");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 4; i++) {
			executor.execute(new AddAPennyTask());
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("What is balance ? " + account.getBalance());
	}
}

/*
task 2 about to deposit
task 3 about to deposit
task 0 about to deposit
task 0 completed deposit
task 1 about to deposit
task 1 completed deposit
task 2 completed deposit
task 3 completed deposit
What is balance ? 4
*/
```
Sync collection

But this doesn't make much sense

```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TestSyncCollection {
	public static void main(String[] args) {
		Collection<Integer> unsyncCollection = new ArrayList<Integer>();	
		Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<Integer>());
		
		Runnable badListOperations = () -> {
			unsyncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
		};
		
		Runnable listOperations = () -> {
			syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
		};  
		
		Thread[] badListThreads = new Thread[100];
		Thread[] listThreads = new Thread[100];
		
		for (int i=0;i<100;i++) {
			badListThreads[i] =new Thread(badListOperations);
			listThreads[i] =new Thread(listOperations);
		}
		
		for (Thread t : badListThreads) {
			t.start();
		}
		try {
			for (Thread t : badListThreads) {
				t.join();
			}
		} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println("unsyncCollection size is " + unsyncCollection.size() +": " + unsyncCollection);
		
		for (Thread t : listThreads) {
			t.start();
		}
		try {
			for (Thread t : listThreads) {
				t.join();
			}
		} catch (InterruptedException e) {e.printStackTrace();}    
		System.out.println("syncCollection size is " + syncCollection.size() + ": "+ syncCollection);
	}
}

/*
unsyncCollection size is 564: [1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6]
syncCollection size is 600: [1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6]
*/
```
```
// example for "doesn't make much sense"

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorFailFastTest {
	private List<Integer> list = new ArrayList<>();	 
	
	public IteratorFailFastTest() {
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
	} 
	
	public void runUpdateThread() {
		Thread thread1 = new Thread(new Runnable() { 
			public void run() {
				for (int i = 100; i < 200; i++) {
					System.out.println(i+" adding");
					list.add(i);
				}
			}
		}); 
		thread1.start();
	} 
	
	public void runIteratorThread() {
		Thread thread2 = new Thread(new Runnable() { 
			public void run() {
				ListIterator<Integer> iterator = list.listIterator();                
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}           
			}
		});        
		thread2.start();
	}
	
	public static void main(String[] args) {
		IteratorFailFastTest tester = new IteratorFailFastTest();
		tester.runUpdateThread();
		tester.runIteratorThread();
	}
}
```
Sync queue
```
import java.util.Queue;

public class Consumer<T> implements Runnable{
	public static final int DELAY = 10;
	private static int idcount = 0;
	private int threadId;
	private Queue<T> q;
	
	public Consumer(Queue<T> queue) {
		threadId = idcount;
		idcount++;
		this.q = queue;
	}	
	
	public void run() {
		while(true) {
			synchronized(q) {
			  	if (q.peek() != null) {
					T v = q.peek();
					try {
						T j = q.remove();
						System.out.println("Consumer thread " + this.threadId + " got " + j.toString());
					} catch (Exception e) {	System.err.println("Consumer thread " + this.threadId + " has error " + e.toString() + " -- thought I would get " + v.toString());}
				}
				try {
					Thread.sleep((int)(DELAY*Math.random()));
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	}
}
```

## Part 7: GUI (Lecture 08, Lecture 09)

![image](https://user-images.githubusercontent.com/85269000/202547150-69c8bd60-2c7d-48b8-9f14-6662ef9f509d.png)

ActionListener; Timer
```
import java.awt.event.*;
import javax.swing.Timer;

public class TimePrinter implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		System.out.println("Event source: " + event.getSource());
	}
	
	public static void main(String[] args) {
		new Timer(1000, new TimePrinter()).start();
		while(true);
	}
}

/*
Event source: javax.swing.Timer@106a6c13
Event source: javax.swing.Timer@106a6c13
Event source: javax.swing.Timer@106a6c13
.....
*/
```
Toolkit; JOptionPane

![image](https://user-images.githubusercontent.com/85269000/202549971-e7952a7b-f4bb-43c9-93f2-53c1b513fa21.png)

```
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TalkingClock {
	private int interval;
	private boolean beep;
	
	public TalkingClock (int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;	
	}	

	public class TimePrinter implements ActionListener {		
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone, the time is " + java.time.Instant.ofEpochMilli(event.getWhen()));
			System.out.println("Interval is " + interval);
			if (beep) 
				java.awt.Toolkit.getDefaultToolkit().beep();
		}		
	}

	public void start() {
		Timer timer = new Timer(interval, new TimePrinter());
		timer.restart();
	}
	
	public static void main(String[] args) {
		TalkingClock tc = new TalkingClock(1000, true);
		tc.start();
		javax.swing.JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);
	}
}

/*
At the tone, the time is 2022-11-14T18:55:06.058Z
Interval is 1000
At the tone, the time is 2022-11-14T18:55:07.059Z
Interval is 1000
*/
```

JLable, JTextField, JButton

![image](https://user-images.githubusercontent.com/85269000/202550418-72e1ce12-92df-4220-8c97-edd037f06fd4.png)

```
public class BankAccount {
	private double balance;
	
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double deposit) {
		this.balance += deposit;
	}
}
```
```
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InvestmentFrame extends JFrame {  
	private BankAccount account;

	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private JLabel resultLabel;

	private static final double DEFAULT_RATE = 10;
	private static final double INITIAL_BALANCE = 1000; 
    
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 200;
	
	private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
    
	public InvestmentFrame(){  
		account = new BankAccount(INITIAL_BALANCE);
		
		createRateField();
		createButton();
		resultLabel = new JLabel("balance=" + DECIMAL_FORMAT.format(account.getBalance()));
		createPanel();

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
    
	public void createRateField(){
		rateLabel = new JLabel("Interest Rate: ");
		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);
	}
 
	public void createButton(){      	
		class AddInterestListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(rateField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter...");
					return;
				}
				double rate = Double.parseDouble(rateField.getText());
				double interest = account.getBalance() * rate / 100;
				account.deposit(interest);
				resultLabel.setText("balance=" + DECIMAL_FORMAT.format(account.getBalance()));
			}            
		}
		button = new JButton("Add Interest");
		button.addActionListener(new AddInterestListener());
	}
 
    public void createPanel(){
    	JPanel panel = new JPanel();
    	panel.add(rateLabel);
    	panel.add(rateField);
       	panel.add(button);
       	panel.add(resultLabel);      
       	this.add(panel);
    }
    
    public static void main(String[] args){  
    	JFrame frame = new InvestmentFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);      
    }
}
```

JTextArea, JScrollPane

![image](https://user-images.githubusercontent.com/85269000/202551009-3cfc3ccd-3425-4ab3-8ff9-f93d523c6d6c.png)

```
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaViewer extends JFrame{
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private BankAccount account;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	private static final double DEFAULT_RATE = 10;
	private static final double INITIAL_BALANCE = 1000;
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 200;

	private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
	
	public TextAreaViewer() {
		account= new BankAccount(INITIAL_BALANCE);
		
		createRateField();
		createScrollPane();
		createButton();
		this.add(createNorthPanel(),BorderLayout.NORTH);
		this.add(scrollPane);
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	
	private void createRateField() {
		rateLabel = new JLabel("Interest Rate: ");
		final int FIELD_WIDTH = 10;
		rateField =	new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);
	}
	
	private void createScrollPane() {
		final int AREA_ROWS = 10;
		final int AREA_COLUMNS = 30;
		textArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
	}
	
	private void createButton() {
		button = new JButton("Add Interest");
		class CalculateListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(rateField.getText().trim().equals("")) {
					javax.swing.JOptionPane.showMessageDialog(null, "Please enter...");
					return;
				}
				double rate = Double.parseDouble(rateField.getText());
				double interest = account.getBalance() * rate / 100;
				account.deposit(interest);
				textArea.append(DECIMAL_FORMAT.format(account.getBalance()) + "\n");
			}            
		}
		button.addActionListener(new CalculateListener());
	}
	
	private JPanel createNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.add(rateLabel);
		northPanel.add(rateField);
		northPanel.add(button);
		return northPanel;
	}
	
	public static void main(String[] args) {
		TextAreaViewer frame = new TextAreaViewer();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}
```
CaretListener

![image](https://user-images.githubusercontent.com/85269000/202551280-77dde9b1-3d84-4f56-98e1-417340742e3c.png)

```
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class BasicTextField extends JFrame {

	JTextField textField;
	
	public BasicTextField() {
		textField = new JTextField(12);
	//	textField.addActionListener((e) -> System.out.println("textfield has value: " + textField.getText()));
		textField.addCaretListener(new TypingListener());
		this.setLayout(new FlowLayout());
		this.add(textField);
		this.setSize(175, 75);
	}
	
	class TypingListener implements CaretListener {
		public void caretUpdate(CaretEvent e) {
			System.out.println("textfield has value: " + textField.getText());
		}
	}
	
	public static void main(String[] args) {
		BasicTextField btf = new BasicTextField();
		btf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btf.setVisible(true);
	}
}
```

JComboBox, JCheckBox, JRadioButton, ButtonGroup 

![image](https://user-images.githubusercontent.com/85269000/202551452-20d5ecd1-8f4f-431c-828e-486d5d632be2.png)

```
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ChoiceFrame extends JFrame{
	private JLabel sampleField;
	private JCheckBox italicCheckBox;
	private JCheckBox boldCheckBox;
	private JRadioButton smallButton;
	private JRadioButton mediumButton;
	private JRadioButton largeButton;
	private JComboBox facenameCombo;
	private ActionListener listener;

	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	
	class ChoiceListener implements ActionListener {  
		public void actionPerformed(ActionEvent event) {
			setSampleFont();
		}
	}
	
	public ChoiceFrame() {  
		listener = new ChoiceListener();

		sampleField = new JLabel("Big Java");
		this.add(sampleField, BorderLayout.CENTER);		
		createControlPanel();
		
		setSampleFont();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public void createControlPanel() {
		JPanel facenamePanel = createComboBox();
		JPanel sizeGroupPanel = createCheckBoxes();
		JPanel styleGroupPanel = createRadioButtons();

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 1));
		controlPanel.add(facenamePanel);
		controlPanel.add(sizeGroupPanel);
		controlPanel.add(styleGroupPanel);
		
		add(controlPanel, BorderLayout.SOUTH);
	}

	public JPanel createComboBox() {
		facenameCombo = new JComboBox();
		facenameCombo.addItem("Serif");
		facenameCombo.addItem("SansSerif");
		facenameCombo.addItem("Monospaced");
		facenameCombo.setEditable(true);
		facenameCombo.addActionListener(listener);
		
		JPanel panel = new JPanel();
		panel.add(facenameCombo);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Font"));
		return panel;
	}

	public JPanel createCheckBoxes() {
		italicCheckBox = new JCheckBox("Italic");
		italicCheckBox.addActionListener(listener);
		
		boldCheckBox = new JCheckBox("Bold");
		boldCheckBox.addActionListener(listener);

		JPanel panel = new JPanel();
		panel.add(italicCheckBox);
		panel.add(boldCheckBox);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));
		return panel;
	}

	public JPanel createRadioButtons() {
		smallButton = new JRadioButton("Small");
		smallButton.addActionListener(listener);

		mediumButton = new JRadioButton("Medium");
		mediumButton.addActionListener(listener);

		largeButton = new JRadioButton("Large");
		largeButton.addActionListener(listener);
		largeButton.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(smallButton);
		group.add(mediumButton);
		group.add(largeButton);

		JPanel panel = new JPanel();
		panel.add(smallButton);
		panel.add(mediumButton);
		panel.add(largeButton);
		panel.setBorder (new TitledBorder(new EtchedBorder(), "Size"));
		return panel;
	}

	public void setSampleFont() {  
		String facename = (String) facenameCombo.getSelectedItem();
		
		int style = 0;
		if (italicCheckBox.isSelected()) 
			style = style + Font.ITALIC;
		if (boldCheckBox.isSelected()) 
			style = style + Font.BOLD;
         
		int size = 0;
		final int SMALL_SIZE = 24;
		final int MEDIUM_SIZE = 36;
		final int LARGE_SIZE = 48;
		if (smallButton.isSelected()) 
			size = SMALL_SIZE;
		else if (mediumButton.isSelected()) 
			size = MEDIUM_SIZE;
		else if (largeButton.isSelected()) 
			size = LARGE_SIZE;
               
		sampleField.setFont(new Font(facename, style, size));      
		sampleField.repaint();
	}
   
	public static void main(String[] args) {  
		JFrame frame = new ChoiceFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);      
	}
}
```

JMenuBar, JMenu, JMenuItem

![image](https://user-images.githubusercontent.com/85269000/202551650-83adfd05-7667-42ec-b39f-5b23eec9f6ba.png)

```
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuFrame extends JFrame{
	private JLabel sampleField;
	private String facename;
	private int fontstyle;
	private int fontsize;
	
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;

	public MenuFrame() {  
		sampleField = new JLabel("Big Java");
		this.add(sampleField, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();     
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		menuBar.add(createFontMenu());

		facename = "Serif";
		fontsize = 24;
		fontstyle = Font.PLAIN;
		setSampleFont();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		return menu;
	}
	
	public JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");      
		item.addActionListener((lestener)->{System.exit(0);});
		return item;
	}
	
	public JMenu createFontMenu() {
		JMenu menu = new JMenu("Font");
		menu.add(createFaceMenu());
		menu.add(createSizeMenu());
		menu.add(createStyleMenu());
		return menu;
	}  

	public JMenu createFaceMenu() {
		JMenu menu = new JMenu("Face");
		menu.add(createFaceItem("Serif"));
		menu.add(createFaceItem("SansSerif"));
		menu.add(createFaceItem("Monospaced"));
		return menu;
	}  

	public JMenu createSizeMenu() {
		JMenu menu = new JMenu("Size");
		menu.add(createSizeItem("Smaller", -1));
		menu.add(createSizeItem("Larger", 1));
		return menu;
	}  

	public JMenu createStyleMenu() {
		JMenu menu = new JMenu("Style");
		menu.add(createStyleItem("Plain", Font.PLAIN));
		menu.add(createStyleItem("Bold", Font.BOLD));
		menu.add(createStyleItem("Italic", Font.ITALIC));
		menu.add(createStyleItem("Bold Italic", Font.BOLD + Font.ITALIC));
		return menu;
	}  

	public JMenuItem createFaceItem(final String name) {
		JMenuItem item = new JMenuItem(name);          
		item.addActionListener((listener)->	{facename = name;setSampleFont();});
		return item;
	}

	public JMenuItem createSizeItem(String name, final int ds) {
		JMenuItem item = new JMenuItem(name);     
		item.addActionListener((listener)->{fontsize = fontsize + ds;setSampleFont();});
		return item;
	}

	public JMenuItem createStyleItem(String name, final int style) {
		JMenuItem item = new JMenuItem(name);      
		item.addActionListener((listener)->{fontstyle = style;setSampleFont();});
		return item;
	}

	public void setSampleFont() { 
		sampleField.setFont(new Font(facename, fontstyle, fontsize));
		sampleField.repaint();
	}
	
	public static void main(String[] args) {  
		JFrame frame = new MenuFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);      
	}
}
```

JSlider

![image](https://user-images.githubusercontent.com/85269000/202551765-721a043d-86bd-43ae-b057-f85ec29e37b2.png)

```
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SliderFrame extends JFrame {  
	private JPanel colorPanel;
	private JSlider redSlider;
	private JTextField redValue;
	private JSlider greenSlider;
	private JTextField greenValue;
	private JSlider blueSlider;
	private JTextField blueValue;
	private ChangeListener listener;
	
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	
	private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#");
	
	class ColorListener implements ChangeListener {  
		public void stateChanged(ChangeEvent event) {  
			setSampleColor();
		}
	}   
	
	public SliderFrame(){  
		listener = new ColorListener();
		
		colorPanel = new JPanel();
		this.add(colorPanel, BorderLayout.CENTER);
		this.add(createControlPanel(), BorderLayout.SOUTH);
		
		this.setSampleColor();
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public JPanel createControlPanel(){
		redSlider = new JSlider(0, 100, 60);
		redSlider.addChangeListener(listener);
		redValue = new JTextField(3);
		redValue.setEditable(false);
		
		greenSlider = new JSlider(0, 100, 60);
		greenSlider.addChangeListener(listener);
		greenValue = new JTextField(3);
		greenValue.setEditable(false);

		blueSlider = new JSlider(0, 100, 60);
		blueSlider.addChangeListener(listener);
		blueValue = new JTextField(3);
		blueValue.setEditable(false);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 3));
		controlPanel.add(new JLabel("Red"));
		controlPanel.add(redSlider);
		controlPanel.add(redValue);
		controlPanel.add(new JLabel("Green"));
		controlPanel.add(greenSlider);
		controlPanel.add(greenValue);
		controlPanel.add(new JLabel("Blue"));
		controlPanel.add(blueSlider);
		controlPanel.add(blueValue);
		return controlPanel;      
	}
   
	public void setSampleColor() {
		float red = 0.01F * redSlider.getValue();
		float green = 0.01F * greenSlider.getValue();
		float blue = 0.01F * blueSlider.getValue();
		redValue.setText(DECIMAL_FORMAT.format(red*100));
		greenValue.setText(DECIMAL_FORMAT.format(green*100));
		blueValue.setText(DECIMAL_FORMAT.format(blue*100));
		colorPanel.setBackground(new Color(red, green, blue));
		colorPanel.repaint();
	}
	
	public static void main(String[] args) {  
		SliderFrame frame = new SliderFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
```
JPanel, JFrame

![image](https://user-images.githubusercontent.com/85269000/202552137-43771e93-73b1-4dc5-931f-bf6d3ef13d95.png)

```
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class ColorJPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(new Color(255, 0 , 0));
		g.fillRect(15, 25, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 40);
		
		
		g.setColor(new Color(0.5f, 0.75f, 0.0f));
		g.fillRect(15, 50, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 65);
		
		
		g.setColor(Color.BLUE);
		g.fillRect(15, 75, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 90);
		
		Color color = Color.MAGENTA;
		g.setColor(color);
		g.fillRect(15, 100, 100, 20);
		g.drawString("RGB values: " + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue(), 130, 115);
	}
}
```
```
import javax.swing.JFrame;

public class ShowColors extends JFrame {

	public ShowColors() {
		super("Using colors");
		ColorJPanel colorJPanel = new ColorJPanel();
		this.add(colorJPanel);
		this.setSize(500,180);
	}
	
	public static void main(String[] args) {
		ShowColors showColors = new ShowColors();
		showColors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showColors.setVisible(true);
	}
}
```

![image](https://user-images.githubusercontent.com/85269000/202552543-400ac30e-c1b0-4b99-a30c-78b72a018965.png)

```
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	private final ArrayList<Point> points = new ArrayList<>();
	
	class MousePaint extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent event) {
			points.add(event.getPoint());
			repaint();
		}
	}
	
	public PaintPanel() {
		this.addMouseMotionListener(new MousePaint());
		
		Dimension size = new Dimension(200,180);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setSize(size);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Point point : points) {
			g.fillOval(point.x, point.y, 4,4);	
		}
	}
}
```
```
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LinesRectsOvalsJPanel extends JPanel {
	LinesRectsOvalsJPanel() {
		this.setPreferredSize(new Dimension(400,200));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.RED);
		g.drawLine(5,  30,  190, 30);

		g.setColor(Color.BLUE);
		g.drawRect(5, 40, 90 ,55);
		g.fillRect(100, 40, 90, 55);
		
		g.setColor(Color.CYAN);
		g.fillRoundRect(190, 40, 90, 55, 50, 50);
		g.drawRoundRect(290,40,90,55,20,20);
		
		g.setColor(Color.GREEN);
		g.draw3DRect(5, 100, 90, 55, true);
		g.fill3DRect(100, 100, 90, 55, false);
		
		g.setColor(Color.MAGENTA);
		g.drawOval(195, 100, 90, 55);
		g.fillOval(290, 100, 90, 55);
	}
}
```
```
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}
	
	public ImagePanel(Image img) {
		this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
	}
	
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
```
```
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsFeatures extends JFrame {
	public GraphicsFeatures() {
		this.setBackground(Color.LIGHT_GRAY);
		this.add(setupPanels());
		this.setSize(1200,200);
	}
	
	public JPanel setupPanels() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,3));
		mainPanel.add(new PaintPanel());
		mainPanel.add(new LinesRectsOvalsJPanel());
		mainPanel.add(new ImagePanel("die1.png"));
		return mainPanel;
	}
	
	public static void main(String[] args) {
		GraphicsFeatures graphicsFeatures = new GraphicsFeatures();
		graphicsFeatures.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphicsFeatures.setVisible(true);
	}
}
```
## Part 8: IOStream (Lecture 11)
## Part 9: DataBase (Lecture 12)
