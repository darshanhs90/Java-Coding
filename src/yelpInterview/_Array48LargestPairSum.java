package yelpInterview;

public class _Array48LargestPairSum {
	public static void main(String a[]){
		int arr[] = {12, 34, 10, 6, 40};
		System.out.println(findMaxPairSum(arr));
	}

	private static int findMaxPairSum(int[] arr) {
		int firstMax=Integer.MIN_VALUE;
		int secondMax=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(firstMax==Integer.MIN_VALUE){
				firstMax=arr[i];
				continue;
			}
			if(secondMax==Integer.MIN_VALUE){
				secondMax=arr[i];
				continue;
			}
			if(arr[i]>firstMax)
			{
				firstMax=arr[i];
			}
			else if(arr[i]>secondMax){
				secondMax=arr[i];
			}
		}
		return firstMax+secondMax;
	}



}