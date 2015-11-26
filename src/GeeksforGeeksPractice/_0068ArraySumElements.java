package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 */
public class _0068ArraySumElements {

	public static void main(String[] args) {
		int inputArray[]=new int[] {1, 4, 45, 6, 10, -8};
		System.out.println(findElementsSum(inputArray,16));
	}

	private static boolean findElementsSum(int[] inputArray, int sum) {
		int l=0,r=inputArray.length-1;
		Arrays.sort(inputArray);
		while(l<r)
		{
			if(inputArray[l]+inputArray[r]==sum)
				return true;
			else if(inputArray[l]+inputArray[r]>sum)
				r--;
			else if(inputArray[l]+inputArray[r]<sum)
				l++;
		}	
		return false;
	}



}
