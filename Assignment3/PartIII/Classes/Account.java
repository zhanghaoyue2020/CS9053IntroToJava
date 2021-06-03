package Classes;
public class Account {
	private static int account_count = 0;
	private double balance = 1000;
	private int id;	
	public Account() {
		Account.account_count++;
		this.id = Account.account_count;
	}	
	public Account (double startingBalance) {
		this();
		this.balance = startingBalance;
	}
	public boolean withdraw (double amount) {
		if (amount <= this.balance) {
			this.balance = this.balance - amount;
			return true;
		}
		else 
			return false;	
	}
	public double getBalance() {
		return this.balance;
	}	
	public void deposit(double amount) {
		this.balance = this.balance + amount; 
	}	
	public int getId() {
		return this.id;
	}
}