package divisors;
import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Stack;
public class CreateList implements Runnable{
	long min;
	long max;
	Entry<Long,Long> a;
	Stack<Entry<Long,Long>> list;
	static final int INTERVAL = 29;	
	public CreateList(Stack<Entry<Long,Long>> list, long min, long max) {
		this.min = min;
		this.max = max;
		this.list = list;
	}	
	public void run() {
		long i = min;
		while(i<=max) {
			if(i+INTERVAL<max) 
				a = new AbstractMap.SimpleEntry<Long,Long>(i, i+INTERVAL);
			else 
				a = new AbstractMap.SimpleEntry<Long,Long>(i, max);
			list.push(a);
			//System.out.print(Thread.currentThread());
			//System.out.println(a);
			i= i+INTERVAL+1;
		}
		while(!list.isEmpty()) {
		}
	}
}