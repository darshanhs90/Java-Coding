package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link: http://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
 */
public class _0122SegregateEvenOddNumbersArray {
	public static void main(String[] args) {
		int arr[] =   {12, 34, 45, 9, 8, 90, 3};
		segregateNumbers(arr);
	}

	private static void segregateNumbers(int[] arr) {
		int left=0,right=arr.length-1;
		while(left<right)
		{
			while(arr[left]%2==0)
			{
				left++;
			}
			while(arr[right]%2!=0)
			{
				right--;
			}
			if(left>=right)
				break;
			arr[left]=arr[left]^arr[right];
			arr[right]=arr[left]^arr[right];
			arr[left]=arr[left]^arr[right];
		}
		System.out.println(Arrays.toString(arr));
	}

	
}
