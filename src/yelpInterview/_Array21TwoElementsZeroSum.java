package yelpInterview;

import java.util.Arrays;

public class _Array21TwoElementsZeroSum {

	public static void main(String a[]){
		int inputArray[] ={1, 60, -10, 70, -80, 85};
		findPair(inputArray);
	}

	private static void findPair(int[] inputArray) {
		Arrays.sort(inputArray);
		int left=0;
		int right=inputArray.length-1;
		int sum=0;
		int minSum=Integer.MAX_VALUE;
		while(left<right)
		{
			sum=inputArray[left]+inputArray[right];
			minSum=Math.min(Math.abs(sum), minSum);
			if(sum>0)
			{
				right--;
			}
			else{
				left++;
			}
		}
		System.out.println(minSum);

	}



}