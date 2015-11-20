package careerCup;

import java.util.Arrays;

/*
 * Link: http://www.careercup.com/question?id=245697
 * Given an array of n elements, find if there is a subset of 3 elements sum up to value T with time complexity O(nlgn).
 */
public class _22googleCareerCup {
	public static void main(String[] args) {
		int inputArray[]=new int[]{12, 3, 4, 1, 6, 9};
		System.out.println(findTripletsSum(inputArray,204));
	}

	private static boolean findTripletsSum(int[] inputArray, int sum) {
		Arrays.sort(inputArray);
		for (int i = 0; i < inputArray.length; i++) {
			int l=i+1;
			int r=inputArray.length-1;
			while(l<r)
			{
				if(inputArray[i]+inputArray[l]+inputArray[r]==sum)
				{
					return true;
				}
				else if(inputArray[i]+inputArray[l]+inputArray[r]>sum)
				{
					r--;
				}
				else
					l++;
			}
		}
		return false;
	}

}
