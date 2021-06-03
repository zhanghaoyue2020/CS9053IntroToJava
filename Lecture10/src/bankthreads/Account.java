package bankthreads;
public class Account {
	private static int idcount=0;
	private int accountid;
	private double balance;
	public Account() {
		balance=0;
		accountid = idcount++;
	}	
	public Account(double balance) {
		this();
		this.balance = balance;
	}	
	public double getBalance() {
		return this.balance;
	}	
	public void deposit(double dep) {
		balance += dep;
	}	
	public double withdraw(double with) {
		balance -= with;
		return balance;
	}
}
