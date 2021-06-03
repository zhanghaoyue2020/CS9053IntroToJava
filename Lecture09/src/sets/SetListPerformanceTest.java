package sets;
import java.util.*;
public class SetListPerformanceTest {
	static final int N = 20000;
	public static void main(String[] args) {  
		// Add numbers 0, 1, 2, ..., N - 1 to the array list
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(i);
		Collections.shuffle(list); // Shuffle the array list
		// Create a hash set, and test its performance
		Collection<Integer> set1 = new HashSet<>(list);
		System.out.println("HashSet");
		System.out.println("create " + getCreateTime(set1));
		System.out.println("Member test " + getTestTime(set1));
		System.out.println("Remove element " + getRemoveTime(set1));
		// Create a linked hash set, and test its performance
		Collection<Integer> set2 = new LinkedHashSet<>(list);
		System.out.println("LinkedHashSet");
		System.out.println("create " + getCreateTime(set2));
		System.out.println("Member test " + getTestTime(set2) );
		System.out.println("Remove element " + getRemoveTime(set2) );
		// Create a tree set, and test its performance
		Collection<Integer> set3 = new TreeSet<>(list);
		System.out.println("TreeSet");   
		System.out.println("create " + getCreateTime(set3));
		System.out.println("Member test " + getTestTime(set3) );
		System.out.println("Remove element " + getRemoveTime(set3) );
		// Create an array list, and test its performance
		Collection<Integer> list1 = new ArrayList<>(list);
		System.out.println("ArrayList");
		System.out.println("create " + getCreateTime(list1));
		System.out.println("Member test " + getTestTime(list1));
		System.out.println("Remove element " + getRemoveTime(list1));
		// Create a linked list, and test its performance
		Collection<Integer> list2 = new LinkedList<>(list);
		System.out.println("LinkedList");
		System.out.println("create " + getCreateTime(list2));
		System.out.println("Member test " + getTestTime(list2) );
		System.out.println("Remove element " + getRemoveTime(list2) );
	}
	public static long getCreateTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			c.add(i);
		return System.currentTimeMillis() - startTime;
	}
	public static long getTestTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		// Test if a number is in the collection
		for(int i = 0; i < N; i++)
			c.contains((int)(Math.random() * 2 * N));
		return System.currentTimeMillis() - startTime; 
	}
	public static long getRemoveTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			c.remove(i);
		return System.currentTimeMillis() - startTime; 
	}
}