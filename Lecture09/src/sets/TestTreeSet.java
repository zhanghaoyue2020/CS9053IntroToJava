package sets;
import java.util.*;
public class TestTreeSet {
	public static void main(String[] args) {
		// Create a hash set
		Set<String> set = new HashSet<>();   
		// Add strings to the set
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");
		TreeSet<String> treeSet = new TreeSet<>(set);
		System.out.println("Sorted tree set: " + treeSet);
		// Use the methods in SortedSet interface
		System.out.println("first(): " + treeSet.first());
		System.out.println("last(): " + treeSet.last());
		System.out.println("headSet(\"New York\"): " + treeSet.headSet("New York"));
		System.out.println("tailSet(\"New York\"): " + treeSet.tailSet("New York"));
		// Use the methods in NavigableSet interface
		System.out.println("lower(\"P\"): " + treeSet.lower("P")); // the greatest element that is strictly less than the given element
		System.out.println("higher(\"P\"): " + treeSet.higher("Paris"));  // the lowest element that is strictly greater than the given element
		System.out.println("floor(\"P\"): " + treeSet.floor("P")); // the greatest element that is less than or equal to the given element
		System.out.println("ceiling(\"P\"): " + treeSet.ceiling("Paris")); // the least element that is greater than or equal to the given element
		System.out.println("pollFirst(): " + treeSet.pollFirst()); // retrieves and removes the lowest element
		System.out.println("pollLast(): " + treeSet.pollLast()); // retrieves and removes the greatest element
		System.out.println("New tree set: " + treeSet);
	}
}