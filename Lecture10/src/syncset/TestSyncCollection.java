package syncset;
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
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("unsyncCollection size is " + unsyncCollection.size() +": " + unsyncCollection);
		for (Thread t : listThreads) {
			t.start();
		}
		try {
			for (Thread t : listThreads) {
				t.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}    
		System.out.println("syncCollection size is " + syncCollection.size() + ": "+ syncCollection);
	}
}