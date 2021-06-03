package bankthreads;
public class Bank {
	private volatile Account[] accounts;
	public Bank(int n, double initialBalance) {
		accounts = new Account[n];
		for (int j = 0;j< n ; j++) 
			accounts[j] = new Account(initialBalance);
	}
	public void transfer(int from, int to, double amount){		
		synchronized (this){
			if (accounts[from].getBalance() < amount) return;
			System.out.print(Thread.currentThread());
			accounts[from].withdraw(amount);
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			accounts[to].deposit(amount);
		}
		System.out.printf(" %10.2f from %2d to %2d    Total Balance: %10.2f%n",  amount, from, to, this.getTotalBalance());
	}
	public double getTotalBalance() {
		double sum = 0;
		for (Account a: accounts)
			sum += a.getBalance();
		return sum;
	}	
	public int size() {
		return accounts.length;
	}
/*	
	public static void main(String [] args) {
		new Bank(100,1000).transfer(52, 46, 200); 
	}
*/
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static final double MAX_AMOUNT = 1000;
	public static final int DELAY = 10;
	public static void main(String[] args) {
		Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
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