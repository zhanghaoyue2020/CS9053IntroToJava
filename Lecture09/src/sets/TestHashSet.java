package sets;
import java.util.*;
public class TestHashSet {
	public static void main(String[] args) {
		// Create a hash set
		Set<String> set = new HashSet<>();
		String london = new String("London");
		String paris = new String("Paris");
		String sanfran = new String("San Francisco");
		String sanfran2 = new String("San Francisco");
		System.out.println(sanfran == sanfran2);
		System.out.println(london.hashCode());
		System.out.println(paris.hashCode());
		System.out.println(sanfran.hashCode());
		System.out.println(sanfran2.hashCode());
		// Add strings to the set
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");
		System.out.println();
		System.out.println(set);
		// Display the elements in the hash set
		for (String s: set) {
			System.out.print(s.toUpperCase() + " ");
		}
		// Process the elements using a forEach method
		System.out.println();
		set.forEach(e -> System.out.print(e.toLowerCase() + " "));
	}
}