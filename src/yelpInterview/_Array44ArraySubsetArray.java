package yelpInterview;

import java.util.HashSet;

public class _Array44ArraySubsetArray {
	public static void main(String a[]){
		int arr1[] = {11, 1, 13, 21, 3, 7};
		int arr2[] = {11, 3, 7, 1};
		System.out.println(isSubArray(arr1,arr2));
		arr1 = new int[]{1, 2, 3, 4, 5, 6};
		arr2 = new int[]{1, 2, 4};
		System.out.println(isSubArray(arr1,arr2));
		arr1 = new int[]{10, 5, 2, 23, 19};
		arr2 = new int[]{19, 5, 3};
		System.out.println(isSubArray(arr1,arr2));
	}

	private static boolean isSubArray(int[] arr1, int[] arr2) {
		HashSet<Integer> elementCount=new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			elementCount.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			if(!elementCount.contains(arr2[i]))
				return false;
		}
		return true;
	}


}