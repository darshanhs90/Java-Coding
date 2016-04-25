package yelpInterview;

import java.util.Arrays;

public class _Array26MedianOfTwoSortedArrays {
	public static void main(String a[]){
		int arr1[] = {1, 12, 15, 26, 38};
		int arr2[] = {2, 13, 17, 30, 45};
		System.out.println(findMedian(arr1,arr2));
	}

	private static int findMedian(int[] arr1, int[] arr2) {

		if(arr1.length==1)
		{
			return (arr1[0]+arr2[0])/2;
		}
		else if(arr1.length==2)
		{
			return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1]))/2;
		}
		int median1=arr1.length%2==0?arr1[arr1.length/2]:(arr1[arr1.length/2]+arr1[arr1.length/2-1])/2;
		int median2=arr2.length%2==0?arr1[arr1.length/2]:(arr2[arr2.length/2]+arr2[arr1.length/2-1])/2;
		if(median1==median2)
			return median1;
		else if(median1>median2)
		{	if(arr1.length%2!=0)
			return findMedian(Arrays.copyOf(arr1, arr1.length/2), Arrays.copyOfRange(arr2, arr2.length/2,arr2.length));
		return findMedian(Arrays.copyOf(arr1, (arr1.length/2)-1), Arrays.copyOfRange(arr2, (arr2.length/2)-1,arr2.length));
		}else{
			if(arr1.length%2!=0)
				return findMedian(Arrays.copyOf(arr1, arr1.length/2), Arrays.copyOfRange(arr2, arr2.length/2,arr2.length));
			return findMedian(Arrays.copyOf(arr2, (arr2.length/2)-1), Arrays.copyOfRange(arr1, (arr1.length/2)-1,arr1.length));
		}
	}






}