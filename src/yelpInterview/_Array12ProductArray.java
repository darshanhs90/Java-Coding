package yelpInterview;

import java.util.Arrays;

public class _Array12ProductArray {
	public static void main(String a[]){
		int inputArray[] = {10, 3, 5, 6, 2};
		System.out.println(Arrays.toString(findProductArray(inputArray)));
	}

	private static int[] findProductArray(int[] inputArray) {
		int product=1;
		for (int i = 0; i < inputArray.length; i++) {
			product*=inputArray[i];
		}
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=product/inputArray[i];
		}
		return inputArray;
	}

}