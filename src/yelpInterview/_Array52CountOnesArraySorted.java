package yelpInterview;

public class _Array52CountOnesArraySorted {
	public static void main(String a[]){
		int arr[] ={1, 1, 0, 0, 0, 0, 0};
		System.out.println(countOnes(arr));
		arr = new int[]{1, 1, 1, 1, 1, 1, 1};
		System.out.println(countOnes(arr));
		arr = new int[]{0, 0, 0, 0, 0, 0, 0};
		System.out.println(countOnes(arr));
	}

	private static int countOnes(int[] arr) {
		return countOnesUtil(arr,0,arr.length-1)+1;
	}

	private static int countOnesUtil(int[] arr, int low, int high) {
		if(low<=high)
		{
			int mid=(low+high)/2;
			if((mid==arr.length-1 || arr[mid+1]<1) && arr[mid]==1)
				return mid;
			if(arr[mid]<1)
			{
				return countOnesUtil(arr,low,mid-1);
			}
			else
				return countOnesUtil(arr,mid+1,high);
		}
		return -1;
	}



}