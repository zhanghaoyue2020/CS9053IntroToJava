package bankaccount;
public class BankAccount {
	private double balance;	
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	public double getBalance() {
		return this.balance;
	}
	public void deposit(double deposit) {
		this.balance += deposit;
	}
}