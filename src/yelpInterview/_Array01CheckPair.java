package yelpInterview;

import java.util.Arrays;

public class _Array01CheckPair {
	public static void main(String a[]){
		int inputArray[] = {1, 4, 45, 6, 10, -8};
		findPair(inputArray,10);
	}

	private static void findPair(int[] inputArray, int sum) {
		Arrays.sort(inputArray);
		int left=0;
		int right=inputArray.length-1;
		while(left<=right)
		{
			if(inputArray[left]+inputArray[right]==sum){
				System.out.println(inputArray[left]+"/"+inputArray[right]);
				break;
			}
			else if(inputArray[left]+inputArray[right]>sum)
				right--;
			else
				left++;
		}
	}
}

