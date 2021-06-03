public class TaskThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Runnable printA = new PrintChar('a',80);
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(new PrintChar('b',30));
		Thread thread3 = new Thread(new PrintNum(50));		
		thread1.start();
		thread2.start();		
		thread2.join();
		System.out.println("\nthread 2 finished");
		thread3.start();		
		thread1.join();
		System.out.println("thread 1 finished");		
		thread3.join();
		System.out.println("thread 3 finished");
	}
}
class PrintChar implements Runnable{   
	private char charToPrint;
	private int times;
	public PrintChar (char charToPrint,int times) {
		this.charToPrint = charToPrint;
		this.times = times;
	}
	public void run() {
		for(int i = 0; i < this.times; i++) {
			System.out.print(this.charToPrint );
			if ((i+1) % 10 == 0) System.out.println();
			try{
				if(i>28) Thread.sleep(1);
			}catch (InterruptedException ex) {
			}
		}
	}
}
class PrintNum implements Runnable{
	private int lastNumber;
	public PrintNum (int lastNumber) {
		this.lastNumber = lastNumber;
	}
	public void run() {
		for(int i = 0; i < this.lastNumber; i++) {
			System.out.print((i+1)+" ");
			if ((i+1) % 10 == 0) System.out.println();
			try{
				if(i>28) Thread.sleep(1);
			}catch (InterruptedException ex) {
			}
		}
	}
}