package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/array-rotation/
 */
public class _0109RotateArray {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		rotate(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

	private static void rotate(int[] arr, int times) {
		int temp[]=Arrays.copyOfRange(arr, 0, times);
		int count=times;
		for (int i = 0; i < arr.length-times; i++) {
			arr[i]=arr[i+times];
			count=i;
		}
		for (int i = 0; i < temp.length; i++) {
			arr[count+1]=temp[i];
			count++;
		}
	}

}
