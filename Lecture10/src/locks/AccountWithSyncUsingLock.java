package locks;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class AccountWithSyncUsingLock {
	private static Account account = new Account();
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 4; i++) {
			executor.execute(new AddAPennyTask());
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("What is balance ? " + account.getBalance());
	}	
	static class AddAPennyTask implements Runnable {
		static int NUM_TASKS = 0;
		int id;
		public AddAPennyTask() {
			this.id =NUM_TASKS;
			NUM_TASKS+=1;
		}
		public void run() {
			System.out.println("task " + id + " about to deposit");
			account.deposit(1);
			System.out.println("task " + id + " completed deposit");
		}
	}
}
class Account {
	private Lock lock = new ReentrantLock(); // Create a lock
	private int balance = 0;
	public int getBalance() {
		return balance;
	}
	public void deposit(int amount) {
		lock.lock(); //get the lock
		balance = balance+amount;
		lock.unlock(); // Release the lock
	}
}