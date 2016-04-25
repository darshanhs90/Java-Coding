package yelpInterview;

import java.util.Arrays;

public class _Array49ConstructArrayPairSum {
	public static void main(String a[]){
		int arr[] = {15, 13, 11, 10, 12, 10, 9, 8, 7, 5};
		System.out.println(Arrays.toString(findArrayPairSum(arr,5)));
	}

	private static int[] findArrayPairSum(int[] pair,int n) {
		int arr[]=new int[n];
		arr[0] = (pair[0]+pair[1]-pair[n-1]) / 2;
		for (int i=1; i<n; i++)
			arr[i] = pair[i-1]-arr[0];
		return arr;
	}




}