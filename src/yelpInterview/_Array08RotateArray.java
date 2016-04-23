package yelpInterview;

import java.util.Arrays;

public class _Array08RotateArray {
	public static void main(String a[]){
		int[] inputArray = new int[]{1, 2, 3, 4, 5, 6,7};
		System.out.println(Arrays.toString(inputArray));
		inputArray=rotateArray(inputArray,6);
		System.out.println(Arrays.toString(inputArray));
	}

	private static int[] rotateArray(int[] inputArray, int count) {
		for (int i = 0; i < count; i++) {
			inputArray=rotate(inputArray);
		}
		return inputArray;
	}

	private static int[] rotate(int[] inputArray) {
		int temp=inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			inputArray[i]=temp^inputArray[i];
			temp=temp^inputArray[i];
			inputArray[i]=temp^inputArray[i];
		}
		inputArray[0]=temp;
		return inputArray;
	}
}