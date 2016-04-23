package yelpInterview;

import java.util.Arrays;

public class _Array16FindDuplicates {
	public static void main(String a[]){
		int inputArray[] = {1, 2, 3, 1, 3, 6, 6};
		findDuplicates(inputArray);
	}

	private static void findDuplicates(int[] inputArray) {
		int[] signArray=Arrays.copyOf(inputArray, inputArray.length);
		for (int i = 0; i < signArray.length; i++) {
			if(signArray[inputArray[i]]<0)
				System.out.println(inputArray[i]);
			else
				signArray[inputArray[i]]=-1*inputArray[i];
		}
	}

}