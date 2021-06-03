package sets;
import java.util.*;
public class TestLinkedHashSet {
	public static void main(String[] args) {
		// Create a linked hash set
		Set<String> set = new LinkedHashSet<>();
		// Add strings to the set
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");
		System.out.println(set);
		// Display the elements in the hash set
		for (String element: set)
			System.out.print(element.toLowerCase() + " ");
		System.out.println();
		Set<String> set2 = new HashSet<>();
		set2.add("Istanbul");
		set2.add("Atlanta");
		set2.add("New York");
		set2.add("San Francisco");
		set2.add("Athens");
		set2.add("New York");
		for (String element: set2)
			System.out.print(element.toLowerCase() + " ");
	}
}