package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link: http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 */
public class _0117SegregateZerosOnesArray {
	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		System.out.println(Arrays.toString(arr));
		segregateZeros(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void segregateZeros(int[] arr) {
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==1)sum++;
		}
		Arrays.fill(arr, 0);
		for (int i = arr.length-1; i >=0; i--) {
			if(sum>0)
				arr[i]=1;
			sum--;
		}
	}

	



}
