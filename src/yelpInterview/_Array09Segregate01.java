package yelpInterview;

import java.util.Arrays;

public class _Array09Segregate01 {
	public static void main(String a[]){
		int[] inputArray = new int[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		System.out.println(Arrays.toString(inputArray));
		inputArray=segregate(inputArray);
		System.out.println(Arrays.toString(inputArray));
	}

	private static int[] segregate(int[] inputArray) {
		int noOfZeroes=0,noOfOnes=0;
		for (int i = 0; i < inputArray.length; i++) {
			if(inputArray[i]==0)
				noOfZeroes++;
			else
				noOfOnes++;
		}
		for (int i = 0; i < inputArray.length; i++) {
			if(noOfZeroes>0)
				inputArray[i]=0;
			else
				inputArray[i]=1;
			noOfZeroes--;
		}
		return inputArray;
	}


}