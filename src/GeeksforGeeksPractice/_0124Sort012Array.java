package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link: http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class _0124Sort012Array {
	public static void main(String[] args) {
		int arr[] =   {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		System.out.println(Arrays.toString(arr));
		sortArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortArray(int[] arr) {
		int low=0,mid=0,high=arr.length-1;
		while(mid<=high)
		{
			if(arr[mid]==0)
			{
				arr[low]=arr[low]^arr[mid];
				arr[mid]=arr[low]^arr[mid];
				arr[low]=arr[low]^arr[mid];
				low++;
				mid++;
			}
			else if(arr[mid]==1)
				mid++;
			else
			{
				arr[mid]=arr[mid]^arr[high];
				arr[high]=arr[mid]^arr[high];
				arr[mid]=arr[mid]^arr[high];
				high--;
			}
		}
		
	}


}
