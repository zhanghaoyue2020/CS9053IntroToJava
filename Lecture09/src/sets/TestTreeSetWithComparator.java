package sets;
import shapes.*;
import java.util.*;
public class TestTreeSetWithComparator {
	public static void main(String[] args) {
		// Create a tree set for geometric objects using a comparator
		Set<GeometricObject> set = new TreeSet<>();
		set.add(new Rectangle(4,5));
		set.add(new Circle(6));
		set.add(new Rectangle(4,5)); 
		set.add(new Rectangle(4,1));
		Circle c1 = new Circle(40);
		Circle c2 = new Circle(40);
		System.out.println(c1.equals(c2));
		// Display geometric objects in the tree set
		System.out.println("A sorted set of geometric objects");
		for (GeometricObject element: set)
			System.out.println("area = " + element.getArea());
	}
}