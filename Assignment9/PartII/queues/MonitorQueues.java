package queues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
public class MonitorQueues implements Runnable {
	Queue<Object> generalPurposeQueue;
	Queue<Object> integerQueue;
	Queue<Object> stringQueue;	
	private IntegerMiddleMan m1,m2;
	private StringMiddleMan m3,m4;
	private Consumer c1;
	private Consumer c2;
	private Producer p;
	private static final int DELAY = 10;
	public MonitorQueues() {		
		generalPurposeQueue = new LinkedList<Object>();
		integerQueue = new ConcurrentLinkedQueue<Object>();
		stringQueue = new ConcurrentLinkedQueue<Object>();		
		p = new Producer(generalPurposeQueue);
		m1 = new IntegerMiddleMan(generalPurposeQueue, integerQueue);
		m2 = new IntegerMiddleMan(generalPurposeQueue, integerQueue);
		m3 = new StringMiddleMan(generalPurposeQueue, stringQueue);
		m4 = new StringMiddleMan(generalPurposeQueue, stringQueue);
		c1 = new Consumer(integerQueue);
		c2 = new Consumer(stringQueue);	
	}
	public void run() {
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(m1).start();
		new Thread(m2).start();
		new Thread(m3).start();
		new Thread(m4).start();
		new Thread(p).start();
		while (true) {
			if (integerQueue.size() > 10) {
				System.out.println("Alert. Queue 1  > 10. Shouldn't happen");
			}
			if (stringQueue.size() > 10) {
				System.out.println("Alert. Queue 2 > 10. Shouldn't happen");
			}
			if (generalPurposeQueue.size() > Producer.MAX_QUEUE_SIZE) {
				System.out.println("Alert. Input Queue > " + Producer.MAX_QUEUE_SIZE + ". Shouldn't happen");
			}			
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}	
	public static void main(String[] args) {
		MonitorQueues mq = new MonitorQueues();
		Thread t = new Thread(mq);
		t.start();
	}
}

/* Q1:
 * 
 * Since the queue of Producer is not synchronized, when this code is returned true:
 * if ((in.peek() != null) && (this.isInstance(in.peek().getClass()))) 
 * Then some other MiddleMan (there are 2 IntegerMiddleMan thread and 2 StringMiddleMan
 * thread) thread will have remove the object from the queue, and the queue of Producer
 * will be null. As a result, thread will meet an error : NoSuchElementException
 * 
 * Q2:
 * 
 * Since what the MiddleMan do to the queue of Producer is to remove objects, no matter
 * whether the queue is sync or not, the queue won't be longer as long as the Producer
 * don't operate. And there is only one "producer" thread.
 * 
 */