package arraylists;
import java.util.*;
public class TestArrayAndLinkedList {
	public static void main(String[] args) {
		List<Object> arrayList = new ArrayList<>();
		arrayList.add(1); // 1 is autoboxed to new Integer(1)
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(0, "black");
		arrayList.add(3, 30);
		System.out.println("A list of objects in the array list:");
		System.out.println(arrayList);
		LinkedList<Object> linkedList = new LinkedList<>(arrayList);
		linkedList.add(1, "red");
		linkedList.removeLast();
		linkedList.addFirst("green");
	//	System.out.println(linkedList);
		ListIterator<Object> listIterator = linkedList.listIterator();
		System.out.println("Display the linked list forward:"); 
	   	while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
	   	System.out.println();
	   	listIterator = linkedList.listIterator(linkedList.size());
		System.out.println("Display the linked list backward:");
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
		}
	}
}