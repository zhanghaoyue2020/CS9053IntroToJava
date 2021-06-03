package queues;
import java.util.Queue;
public abstract class MiddleMan implements Runnable {
	public static int DELAY = 20;
	Queue<?> in;//queue of Producer
	Queue<Object> out;//queue of MiddleMan
	Object outObj;//object from Producer to MiddleMan
	public MiddleMan(Queue<? extends Object> in, Queue<Object> out) {
		this.in = in;
		this.out = out;
		outObj = null;
	}	
	public abstract boolean isInstance(Class clazz);
	public void run() {
		while (true) {
			//object == null; sync queue of Producer; run until can remove an object from queue of Producer;
			//object != null;
				//queue of MiddleMan >=10; pause this thread; run until <10;
				//queue of MiddleMan <10; offer the object to queue of MiddleMan; object = null;
					//queue of MiddleMan =0; "Why did this happen";
			//pause this thread;
			if (outObj == null) {
				synchronized(in) { // <-- you will uncomment this after you finish Question 1
					if ((in.peek() != null) && (this.isInstance(in.peek().getClass()))) {
						this.outObj = in.remove();
					} else {
						this.outObj = null;
						continue;
					}
				} // <-- uncomment this after you finish Question 1
			}
			if (outObj != null) {
				while (out.size() >= 10) { 
					try {
						Thread.sleep((long) (DELAY*Math.random()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
				synchronized(out) {
					if (out.size() >= 10) {
						continue;
					} else {
						out.offer(outObj);
						if (out.contains(null)) {
							System.out.println("why did this happen?");
						}
						outObj = null;
					}
				}
			}
			try {
				Thread.sleep((long) (DELAY*Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}	
	}	
}