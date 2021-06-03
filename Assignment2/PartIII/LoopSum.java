import java.util.Scanner;
public class LoopSum {
	public static int sum100() {
		int i = 1;
		int sum = 0;
		for(;;i++) {
			if(i>100) 
				break;
			sum = sum+i;
		}
		return sum;
	}
	public static int sumN(int N) {
		int i = 1;
		int sum = 0;
		for(;;i++) {
			if(i>N)
				break;
			sum = sum+i;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int n =input.nextInt();
		int sum100 = sum100();
		int sumN = sumN(n);
		System.out.println("1+2+。。。。+100=" + sum100);
		System.out.println("1+2+.....+N="+sumN);
	}	
}