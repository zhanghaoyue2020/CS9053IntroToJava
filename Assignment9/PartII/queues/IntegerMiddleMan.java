package queues;
import java.util.Queue;
public class IntegerMiddleMan extends MiddleMan {
	public IntegerMiddleMan(Queue<Object> in, Queue<Object> out) {
		super(in, out);	
	}
	public boolean isInstance(Class clazz) {
		if (clazz == Integer.class) {
			return true;
		}
		return false;
	}
}