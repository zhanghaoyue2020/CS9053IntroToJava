import java.util.Scanner;
public class NumberToEnglish {
	public static String numberToEnglish(int num) {
		String number = null;
		//num->-num
		if (num < 0) {
			num = -num;
			number = " negative" + NumberToEnglish.numberToEnglish(num);
		}
		//read 999,000,000
		else if (num/1000000 != 0) {
			int million = num / 1000000;
			int millionRemaining = num % 1000000;
			number = NumberToEnglish.thousandToEnglish(million) + " million" + NumberToEnglish.numberToEnglish(millionRemaining);
		}
		//read 000,999,000
		else if(num/1000 != 0){
			int thousand = num / 1000;
			int thousandRemaining = num % 1000;
			number = NumberToEnglish.thousandToEnglish(thousand) + " thousand" + NumberToEnglish.thousandToEnglish(thousandRemaining);
		}
		//read 000,000,999
		else if(num/1 != 0) 
			number = NumberToEnglish.thousandToEnglish(num);
		//read 000,000,000
		else 
			number = "zero";
		return number;
	}
	public static String thousandToEnglish(int num) {
		String number = null;
		//read 900
		if (num/100 != 0) {
			int hundred = num / 100;
			int hundredRemaining = num % 100;
			number = NumberToEnglish.transferToEnglish(hundred) + " hundred" + NumberToEnglish.thousandToEnglish(hundredRemaining);
		}
		//read 21-99
		else if(num > 20) {
			int decade = num / 10;
			int digit = num % 10;
			number = NumberToEnglish.transferToEnglish(decade*10) + NumberToEnglish.transferToEnglish(digit);
		}
		//read 00-20
		else {
			number = NumberToEnglish.transferToEnglish(num);
		}
		return number;
	}
	public static String transferToEnglish(int num) {		
		String number = null;
		int digit = num;
		switch(digit) {
			case(0): number=" ";break;
			case(1): number=" one";break;
			case(2): number=" two";break;
			case(3): number=" three";break;
			case(4): number=" four";break;
			case(5): number=" five";break;
			case(6): number=" six";break;
			case(7): number=" seven";break;
			case(8): number=" eight";break;
			case(9): number=" nine";break;
			case(10): number=" ten";break;
			case(11): number=" eleven";break;
			case(12): number=" twelve";break;
			case(13): number=" thirteen";break;
			case(14): number=" fourteen";break;
			case(15): number=" fifteen";break;
			case(16): number=" sixteen";break;
			case(17): number=" seventen";break;
			case(18): number=" eighteen";break;
			case(19): number=" nineteen";break;
			case(20): number=" twenty";break;
			case(30): number=" thirth";break;
			case(40): number=" forty";break;
			case(50): number=" fifty";break;
			case(60): number=" sixty";break;
			case(70): number=" seventy";break;
			case(80): number=" eighty";break;
			case(90): number=" ninety";break;
		}
		return number;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: " );
		int number = in.nextInt();
		if ((number>999999999)||(number<-999999999)) 
			System.out.println("exceeding the scale.");
		else
			System.out.println("The number " + number + " in English is " + NumberToEnglish.numberToEnglish(number));
	}
}