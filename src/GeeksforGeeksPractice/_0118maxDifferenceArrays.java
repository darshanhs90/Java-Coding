package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link: http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 */
public class _0118maxDifferenceArrays {
	public static void main(String[] args) {
		int arr[] ={2, 3, 10, 6, 4, 8, 1};
		System.out.println(findMaxDifference(arr));
	}

	private static int findMaxDifference(int[] arr) {
		int maxDifference=arr[1]-arr[0];
		int minElement=arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]-minElement>maxDifference)
				maxDifference=arr[i]-minElement;
			if(arr[i]<minElement)
				minElement=arr[i];
		}
		return maxDifference;
	}







}
