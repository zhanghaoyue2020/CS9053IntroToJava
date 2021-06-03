package queues;
import java.util.Queue;
public class Consumer implements Runnable {
	public static final int DELAY = 400;	
	Queue<Object> in;//queue of MiddleMan	
	public Consumer(Queue<Object> in) {
		this.in = in;
	}	
	public void run() {
		Object a = null;
		Object b = null;
		//sync queue of MiddleMan;
			//queue of MiddleMan != null; a = object from MiddleMan;b = object from MiddleMan
		//pause this thread;
		while (true) {
			synchronized(in) {
				if (in.peek() != null) {
					Object obj = in.remove();
					if (a == null) {
						a = obj;
					} else if (b == null) {
						b = obj;
					}
					if ((a != null) && (b != null)) {
						System.out.print(this.toString() + ": ");
						if (a instanceof Number) {
							System.out.println( String.format("%f" ,((Number)a).doubleValue() + ((Number)b).doubleValue()));
						} else {
							System.out.println(a.toString() + " "+ b.toString());
						}
						a = null;
						b = null;
					}
				}
			}
			try {
				Thread.sleep((long) (Math.random()*DELAY));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
}