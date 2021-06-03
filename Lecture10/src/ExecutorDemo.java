import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(new PrintChar('a',30));
		executor.execute(new PrintChar('b',30));
		executor.execute(new PrintChar('c',30));
		executor.execute(new PrintChar('d',30));
		executor.execute(new PrintChar('e',30));
		executor.execute(new PrintChar('f',30));
		executor.execute(new PrintChar('g',30));		
	}
}
