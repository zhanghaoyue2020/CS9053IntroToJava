package bankthreads;
import java.util.*;
public class SyncMethodBank extends Bank {
	public SyncMethodBank(int n, double initialBalance) {
		super(n, initialBalance);
	}
	public synchronized void transfer(int from, int to, double amount) {
		super.transfer(from, to, amount);
	}
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static final double MAX_AMOUNT = 1000;
	public static final int DELAY = 10;
	public static void main(String[] args) {
		Bank bank = new SyncMethodBank(NACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < 10; i++) {
			Runnable r = () -> {
				while(true){
					int fromAccount = (int)(bank.size() * Math.random());
					int toAccount = (int)(bank.size() * Math.random());
					double amount = MAX_AMOUNT*Math.random();
					bank.transfer(fromAccount, toAccount, amount);
					try {
						Thread.sleep((int)(DELAY*Math.random()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			new Thread(r).start();
		}	
	}
}