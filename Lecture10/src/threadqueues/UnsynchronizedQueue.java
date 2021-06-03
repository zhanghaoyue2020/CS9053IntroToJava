package threadqueues;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class UnsynchronizedQueue {
	public Queue<Integer> unsyncQueue;
	Producer p;
	Consumer<Integer>[] consumers;	
	public UnsynchronizedQueue(int numConsumers) {
		unsyncQueue = new LinkedList<Integer>();
		p = new Producer(unsyncQueue);
		consumers = new Consumer[numConsumers];
		for (int i= 0; i<consumers.length; i++) {
			consumers[i] = new Consumer<Integer>(unsyncQueue);
		}
		new Thread(p).start();
		for (Consumer<Integer> c : consumers) {
			new Thread(c).start();
		}
	}	
	public static void main(String[] args) {
		UnsynchronizedQueue unsyncQ = new UnsynchronizedQueue(5);
	}
}