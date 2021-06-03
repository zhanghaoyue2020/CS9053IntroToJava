import java.util.*;
public class TwoDimensionalArray {
	public static void main(String[] args) {
		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};
		/* copy arrayOne and arrayTwo into twoDimArray */
		/* print out the first list of 5 numbers in twoDimArray
		 * on one line, and the second list of 5 numbers in twoDimArray
		 * on the next line
		 */
		/* the solution should use nested loops: one loop to loop over
		 * each array in twoDimArray, and one loop to loop over each element
		 * in that array
		 */
		for (int i = 0 ; i < twoDimArray.length ; i++) {
			for (int j = 0; j < arrayOne.length ; j++) {
				switch (i) {
				case (0): twoDimArray[0][j] = arrayOne[j];break;
				case (1): twoDimArray[1][j] = arrayTwo[j];break;
				}
			}
		}
		System.out.println("twoDimArray is \n" + Arrays.toString(twoDimArray[0]) + "\n" + Arrays.toString(twoDimArray[1]));
	}
}
//2.In TwoDimensionalArray.java, we have a two dimensional array called twoDimArray and two one-dimensional arrays, arrayOne and arrayTwo. You will copy the CONTENTS of arrayOne into twoDimArray[0] and the CONTENTS of arrayTwo into twoDimArray[1]. Use two nested loops and index 0 of the first dimension of twoDimArray means choosing arrayOne as the array to copy and index 1 of the first dimension means choosing arrayTwo.