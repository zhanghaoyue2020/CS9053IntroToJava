package divisors;
import java.util.Map.Entry;
import java.util.AbstractMap;
import java.util.Stack;
public class ThreadedMaxDivisors implements Runnable {		
	private long min;
	private long max;
	Entry<Long,Long> element;
	Stack<Entry<Long,Long>> list;
	Stack<Entry<Long,Long>> result;
	private static final int THREADS_NUMBER = 60;
	public ThreadedMaxDivisors(long min, long max) {
		this.min = min;
		this.max = max;
		list = new Stack<>();
		result = new Stack<>();
	}	
	public void run() {
		Thread createList = new Thread (new CreateList(list,min,max));
		createList.start();
		for(int i = 0; i<THREADS_NUMBER; i++) {
			new Thread (new Counter(list,result)).start();
		}
		try {
			createList.join();
			Thread.sleep(THREADS_NUMBER);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		Entry<Long,Long> answer = new AbstractMap.SimpleEntry<Long,Long>((long)0,(long)0);
		while (!result.isEmpty()) {
				element = result.pop();
			//	System.out.print(Thread.currentThread());
			//	System.out.println("out " + element);
				if (element.getValue()>answer.getValue())
					answer = element;
		}
		System.out.println(answer);
	}	
	public static void main(String[] args) throws InterruptedException {
		long min = 100_000;
		long max = 200_000;		
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new ThreadedMaxDivisors(min,max));
		t.start();
		t.join();
		long endTime = System.currentTimeMillis();
		System.out.println("Threaded elapsed time: " + (endTime - startTime));
		startTime = System.currentTimeMillis();
		Entry<Long,Long> e = CountDivisors.maxDivisors(min, max);
		long number = e.getKey();
		long numDivisors = e.getValue();
		System.out.println("\n" + number + ": " + numDivisors);
		endTime = System.currentTimeMillis();
		System.out.println("Non-threaded elapsed time: " + (endTime - startTime));
	}
}