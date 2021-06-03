package threadqueues;

import java.util.Queue;
public class Producer implements Runnable{
	private static int idcount = 0;
	private int id;
	private Queue<Integer> q;
	public Producer(Queue<Integer> queue) {
		id = idcount;
		idcount++;
		this.q = queue;
	}
	public static final int DELAY = 5;
	public void run() {
		while(true) {
	//		Integer i = new Integer((int) (Integer.MAX_VALUE*Math.random()));
			Integer i = new Integer((int) (1000*Math.random()));
			q.offer(i);
			System.out.println("Producer thread "+ id + " put " + i.toString());
			try {
				Thread.sleep((int)DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}