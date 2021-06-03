package threadqueues;
import java.util.Queue;
public class Consumer<T> implements Runnable{
	public static final int DELAY = 10;
	private static int idcount = 0;
	private int threadId;
	private Queue<T> q;
	public Consumer(Queue<T> queue) {
		threadId = idcount;
		idcount++;
		this.q = queue;
	}	
	public void run() {
		while(true) {
			synchronized(q) {
			  	if (q.peek() != null) {
					T v = q.peek();
					try {
						T j = q.remove();
						System.out.println("Consumer thread " + this.threadId + " got " + j.toString());
					} catch (Exception e) {
						System.err.println("Consumer thread " + this.threadId + " has error " + e.toString() + " -- thought I would get " + v.toString());
						continue;
					}
				}
				try {
					Thread.sleep((int)(DELAY*Math.random()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}