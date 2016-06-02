package yelpInterview;

import java.util.Arrays;

public class _Algo05ClosestPairSortedArrays {

	public static void main(String a[]){
		int arr1[] = {1, 4, 5, 7};
		int arr2[] = {10, 20, 30, 40};
		System.out.println(findClosestPair(arr1,arr2,32));

	}

	private static int findClosestPair(int[] arr1, int[] arr2,int value) {

		int mergedArray[]=new int[arr1.length+arr2.length];
		int arr2Index=0;
		for (int i = 0; i < mergedArray.length; i++) {
			if(i<arr1.length)
			{
				mergedArray[i]=arr1[i];
			}
			else{
				mergedArray[i]=arr2[arr2Index];
				arr2Index++;
			}
		}
		Arrays.sort(mergedArray);
		int low=0,high=mergedArray.length-1;
		while(low<high)
		{
			int sum=mergedArray[low]+mergedArray[high];
			if(sum==value)
				return sum;
			else if(sum>value)
				high--;
			else
				low++;	
		}
		return mergedArray[low]+mergedArray[high];
	}


}

