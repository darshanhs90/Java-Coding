package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link:http://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
 */
public class _011ElementsZeroSumArray {
	public static void main(String[] args) {
		int arr[] = {1, 60, -10, 70, -80, 85};
		System.out.println(findElementsSum(arr));
	}

	private static int findElementsSum(int[] arr) {
		int l=0,r=arr.length-1;
		Arrays.sort(arr);
		int minSum=Integer.MAX_VALUE,sum=Integer.MAX_VALUE;
		System.out.println(Arrays.toString(arr));
		while(l<r)
		{
			sum=arr[l]+arr[r];
			if(Math.abs(sum)<Math.abs(minSum))
				minSum=sum;
			if(arr[l]+arr[r]==0)
				return 0;
			else if(arr[l]+arr[r]>0)
				r--;
			else
				l++;
		}
		return minSum;
	}	
}
