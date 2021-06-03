package threethreads;
public class ThreadTest {
	public static void main(String[] args) {
		A a = new A();
		a.setPriority(Thread.MIN_PRIORITY);
		a.start();
		new B().start();
		C c = new C();
		c.setPriority(Thread.MAX_PRIORITY);
		c.start();
	}
}
class A extends Thread {
	public void run() {
		for (int i=0;i<100;i++) {
			Thread.yield();
			Thread.yield();
			Thread.yield();
			System.out.print("A");	
		}
		System.out.println("Exit from A");
	}
}
class B extends Thread {
	public void run() {
		for (int i=0;i<100;i++) {
			Thread.yield();
			Thread.yield();
			Thread.yield();
			System.out.print("B");	
		}
		System.out.println("Exit from B");
	}
}
class C extends Thread {
	public void run() {
		for (int i=0;i<100;i++) {
			Thread.yield();
			Thread.yield();
			Thread.yield();
			System.out.print("C");	
		}
		System.out.println("Exit from C");
	}
}