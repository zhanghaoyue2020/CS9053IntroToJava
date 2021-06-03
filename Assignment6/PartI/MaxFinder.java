package PartI;
import java.util.ArrayList;
public class MaxFinder{	
	private ArrayList<Number> numberList = new ArrayList<>(); 
	public void add(ArrayList<? extends Number> List) {
		for(int i = 0; i < List.size(); i++)
			numberList.add(List.get(i));
	}	
	public void add(Number number) {
		numberList.add(number);
	}
	public Number max() {
		Number max = numberList.get(0);
		double number1 = numberList.get(0).doubleValue();
		for(int i = 0; i < numberList.size(); i++) {
			double number2 = numberList.get(i).doubleValue();
			if (number2 > number1)
				max = numberList.get(i);
				number1 = numberList.get(i).doubleValue();
		}
		return max;
	}	
	public static void main(String[] args ) {		
		ArrayList<Integer> integerList = new ArrayList<>();
		integerList.add(1); 
		integerList.add(2); 
		integerList.add(-2); 		
		ArrayList<Double> doubleList = new ArrayList<>();
		doubleList.add(1.5);
		doubleList.add(2.5);
		doubleList.add(2.333);		
		int a = 100;		
		double b = 5.6;
		MaxFinder mf = new MaxFinder();
		mf.add(integerList);
		mf.add(doubleList);
		mf.add(a);
		mf.add(b);
		System.out.println("The arraylist is: " + mf.numberList); 
		System.out.println("The Largest number is: " + mf.max()); 
	}
}