package PartI;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
public class RemoveMethods {
	public static void remAllStack(Stack<Object> stack, Object item) {
		Stack<Object> temp = new Stack<Object>(); 
		while(!stack.isEmpty()) {
			if (Objects.equals(stack.peek(), item))    
				stack.pop();
			else    
				temp.push(stack.pop());
		}
		while(!temp.isEmpty())		
			stack.push(temp.pop());
	}	
	public static void remAllQueue(Queue<Object> queue, Object item) {
		Queue<Object> temp = new  ArrayDeque<Object>();
		while(!queue.isEmpty()) {
			if (Objects.equals(queue.peek(), item))
				queue.remove();
			else
				temp.offer(queue.remove());
		}
		while(!temp.isEmpty())
			queue.offer(temp.remove());
	}	
	public static void main(String[] args) {
		Stack<Object> stk = new Stack<Object>();
		stk.push(new Integer(24));
		stk.push(new Integer(2));
		stk.push(new Integer(9));
		stk.push(new Integer(2));
		stk.push(new Integer(7));
		stk.push(new Integer(10));
		stk.push(new Integer(16));
		System.out.println("begin: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(2));
		System.out.println("end: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(24));
		System.out.println("end: stk is " + stk);		
		Queue<Object> q = new ArrayDeque<Object>(); // you should probably find a concrete class for this
		q.offer(new Integer(24));
		q.offer(new Integer(2));
		q.offer(new Integer(9));
		q.offer(new Integer(2));
		q.offer(new Integer(7));
		q.offer(new Integer(10));
		q.offer(new Integer(16));
		System.out.println("begin: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(2));
		System.out.println("end: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(24));
		System.out.println("end: q is " + q);		
	}
}