package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 */
public class _0108ReverseArray {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6,7};
		System.out.println(Arrays.toString(arr));
		reverseArray(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void reverseArray(int[] arr)
	{
		int i=0,j=arr.length-1;
		while(i<j)
		{
			arr[i]=arr[i]^arr[j];
			arr[j]=arr[i]^arr[j];
			arr[i]=arr[i]^arr[j];
			i++;
			j--;
		}
	}

}
