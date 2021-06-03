package threadqueues;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class SynchronizedQueue {
	public Queue<Integer> syncQueue;
	Producer p;
	Consumer<Integer>[] consumers;	
	public SynchronizedQueue(int numConsumers) {
		syncQueue = new ConcurrentLinkedQueue<Integer>();
		consumers = new Consumer[numConsumers];
		for (int i= 0; i<consumers.length; i++) {
			new Thread(new Consumer<Integer>(syncQueue)).start();
		}
		new Thread(new Producer(syncQueue)).start();
	}
	public static void main(String[] args) {
		new SynchronizedQueue(5);
	}
}