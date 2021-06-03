package bankthreads;

public class SyncDataBank{
	private Account[] syncAccounts;	
	public SyncDataBank(int n, double initialBalance) {
		syncAccounts = new Account[n];
		for (int j = 0;j< n ; j++) 	syncAccounts[j] = new Account(initialBalance);
	}
	public void transfer(int from, int to, double amount){
		synchronized(syncAccounts[from]) {
			if (syncAccounts[from].getBalance() < amount) return;
			System.out.print(Thread.currentThread());
			synchronized(syncAccounts[to]) {
				syncAccounts[to].deposit(amount);
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			syncAccounts[from].withdraw(amount);
			System.out.printf(" %10.2f from %2d to %2d    Total Balance: %10.2f%n",  amount, from, to, this.getTotalBalance());
		}
	}
	public double getTotalBalance() {
		double sum = 0;
		for (Account a: syncAccounts)
			sum += a.getBalance();
		return sum;
	}
	public int size() {
		return syncAccounts.length;
	}
/*	
	public static void main(String[] args) {
		new SyncDataBank(100,1000).transfer(52, 46, 200);
	}
*/
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static final double MAX_AMOUNT = 1000;
	public static final int DELAY = 10;
	public static void main(String[] args) {
		SyncDataBank bank = new SyncDataBank(NACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < 10; i++) {
			Runnable r = () -> {
				while(true){
					int fromAccount = (int)(bank.size() * Math.random());
					int toAccount = (int)(bank.size() * Math.random());
					double amount = MAX_AMOUNT*Math.random();
					bank.transfer(fromAccount, toAccount, amount);
					//	Thread.sleep((int)(DELAY*Math.random()));
				}
			};
			new Thread(r).start();
		}	
	}
}
// add synchronized(from) and then synchronized(to) blocks