public class LargestPairProduct {
	public static void main(String[] args) {
		int[] intArray = {17, 1, 3, 12, 39, 4, 76, 4, 31, 87};
		int product = -1;
		int middleProduct = -1;
		for (int i=0; i < intArray.length ; i++) {
			for (int j=0; j < i; j++) {
				middleProduct = intArray [i] * intArray [j];
				if (middleProduct > product)
					product = middleProduct;
			}
		}
		System.out.println("Maximum product of all pairs in the array: " + product);
	}
}
/*
1.In LargestPairProduct.java, there is a variable intArray which contains 10 integers. Find the largest product of all pairs of numbers in the array and display the result. Nested loops will probably be the right thing to do:

(get each index that will be the first member of the pair)
	(get each index that will be the second member of the pair)

For efficiency¡¯s sake you will want to avoid multiplying pairs repetitively. I.e., if you multiple intArray[5]*intArray[6], there is no need to multiply intArray[6]*intArray[5]

*   0 1 2 3 j
* 0 - - - - 
* 1 + - - -
* 2 + + - -
* 3 + + + -
* i
*/