package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link: http://www.geeksforgeeks.org/a-product-array-puzzle/
 */
public class _0121ProductArray {
	public static void main(String[] args) {
		int arr[] =  {10, 3, 5, 6, 2};
		constructProduct(arr);
	}

	private static void constructProduct(int[] arr) {
		int left[]=new int[arr.length],right[]=new int[arr.length],prod[]=new int[arr.length];
		
		left[0]=1;
		right[arr.length-1]=1;
		for (int i = 1; i < left.length; i++) {
			left[i]=left[i-1]*arr[i-1];
		}
		for (int i = right.length-2; i >=0; i--) {
			right[i]=right[i+1]*arr[i+1];
		}
		for (int i = 0; i < prod.length; i++) {
			prod[i]=left[i]*right[i];
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		System.out.println(Arrays.toString(prod));
	}

	


}
