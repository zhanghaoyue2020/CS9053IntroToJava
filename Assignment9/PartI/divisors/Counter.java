package divisors;
import java.util.Stack;
import java.util.Map.Entry;
public class Counter implements Runnable {	
	Entry<Long,Long> a;
	Stack<Entry<Long,Long>> list;
	Stack<Entry<Long,Long>> result;	
	public Counter(Stack<Entry<Long,Long>> list, Stack<Entry<Long,Long>> result) {
		this.list = list;
		this.result = result;
	}	
	public void run() {
		long min;
		long max;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true) {
			synchronized(list) {
				if ((!list.isEmpty())&&(a == null)) {
					a = list.pop();
				}
				if (list.isEmpty())  break;
			}
			if(a != null) {
				if(a.getKey()<a.getValue()) {
					min = a.getKey();
					max = a.getValue();
				} else {
					max = a.getKey();
					min = a.getValue();
				}
				Entry<Long,Long> element = CountDivisors.maxDivisors(min, max);
				synchronized(result) {
					result.push(element);
					System.out.print(Thread.currentThread());
					System.out.println(" "+ min +" ~ " + max +" "+ element);
				}
				a = null;
			}
		}		
	}
}