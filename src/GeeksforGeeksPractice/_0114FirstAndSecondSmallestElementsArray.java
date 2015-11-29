package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link:http://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
 */
public class _0114FirstAndSecondSmallestElementsArray {
	public static void main(String[] args) {
		int arr[] = {12, 13, 1, 10, 34, 1};
		System.out.println(findMinElements(arr));
	}

	private static String findMinElements(int[] arr) {
		int firstMin=Integer.MAX_VALUE,secondMin=Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]<firstMin)
			{
				secondMin=firstMin;
				firstMin=arr[i];
			}
			else if(arr[i]<secondMin && arr[i]!=firstMin){
				secondMin=arr[i];
			}
		}
		return firstMin+"/"+secondMin;
	}


}
