package synclists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class IteratorSafeListTest {
	private List<Integer> safeList = Collections.synchronizedList(new ArrayList<>());
	public IteratorSafeListTest() {
		for (int i = 0; i < 100; i++) {
			safeList.add(i);
		}
	}
	public void runUpdateThread() {
		new Thread(new Runnable(){
			public void run() {
				for (int i = 100; i < 200; i++) {
					System.out.println(i+" adding");
					safeList.add(i);
				}
			}
		}).start();
	}
	public void runIteratorThread() {
		new Thread(new Runnable() {
			public void run() {
				ListIterator<Integer> iterator = safeList.listIterator();
				synchronized (safeList) {
					while (iterator.hasNext())   System.out.println(iterator.next());
				}
			}
		}).start();
	}
	public static void main(String[] args) {
		IteratorSafeListTest tester = new IteratorSafeListTest();
		tester.runUpdateThread();
		tester.runIteratorThread();
	}
}