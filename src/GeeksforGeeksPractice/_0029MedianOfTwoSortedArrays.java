package GeeksforGeeksPractice;

public class _0029MedianOfTwoSortedArrays {

	public static void main(String[] args) {

		int arr1[] = {1, 12, 15, 26, 38};
		int arr2[] = {2, 13, 17, 30, 45};
		System.out.println(findMedian(arr1,arr2,0,arr1.length-1,arr1.length));//17 


	}

	private static int findMedian(int[] arr1, int[] arr2,int left,int right,int n) {
		if(left>right)
			return findMedian(arr2, arr1, left, right, n);
		int i=(left+right)/2,j=n-i-1;
		if (arr1[i] > arr2[j] && (j == n-1 || arr1[i] <= arr2[j+1]))
		{
			if (i == 0 || arr2[j] > arr1[i-1])
				return (arr1[i] + arr2[j])/2;
			else
				return (arr1[i] + arr1[i-1])/2;
		}
		else if (arr1[i] > arr2[j] && j != n-1 && arr1[i] > arr2[j+1])
			return findMedian(arr1, arr2, left, i-1, n);
		else 
			return findMedian(arr1, arr2, i+1, right, n);
	}
}
