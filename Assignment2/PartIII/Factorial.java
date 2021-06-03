import java.util.Scanner;
public class Factorial {
	public static void main(String[] args) {
		int val = 1;
		Scanner input = new Scanner (System.in);
		System.out.print("Enter a integer: ");
		int N = input.nextInt();
		for(int i=1;i<=N;i++) {
			val = val * i; 
		}
		System.out.println( N +"!=" + val);
	}
}