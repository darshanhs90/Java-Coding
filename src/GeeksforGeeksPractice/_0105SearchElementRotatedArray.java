package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class _0105SearchElementRotatedArray {
	public static void main(String[] args) {
		int inputArray[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		System.out.println(search(inputArray,3));
	}

	private static boolean search(int[] inputArray, int element) {
		int pivot=inputArray.length/2;
		if(element==inputArray[pivot])
			return true;
		else if(element>inputArray[0])
			return Arrays.binarySearch(Arrays.copyOfRange(inputArray, 0, pivot-1), element)==-1?false:true;
		else
			return Arrays.binarySearch(Arrays.copyOfRange(inputArray, pivot+1, inputArray.length), element)==-1?false:true;
	}



}
