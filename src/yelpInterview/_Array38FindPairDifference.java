package yelpInterview;

import java.util.Arrays;

public class _Array38FindPairDifference {

	public static void main(String a[]){
		int inputArray[]={5, 20, 3, 2, 50, 80};
		int n = 78;
		System.out.println(findPairDifference(inputArray,n));
	}

	private static boolean findPairDifference(int[] inputArray, int n) {
		Arrays.sort(inputArray);
		int low=0,high=inputArray.length-1;
		while(low<=high)
		{
			int diff=inputArray[high]-inputArray[low];
			if(diff==n)
				return true;
			if(diff>n)
				high--;
			else
				low++;
		}
		return false;
	}



}