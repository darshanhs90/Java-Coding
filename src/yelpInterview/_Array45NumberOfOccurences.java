package yelpInterview;

public class _Array45NumberOfOccurences {
	public static void main(String a[]){
		int arr[] = {1, 1, 2, 2, 2, 2, 3,};
		int  x = 2;
		System.out.println(findNoOfOccurences(arr,x));
		arr = new int[]{1, 1, 2, 2, 2, 2, 3,};
		x = 3;
		System.out.println(findNoOfOccurences(arr,x));
		arr = new int[]{1, 1, 2, 2, 2, 2, 3,};
		x = 1;
		System.out.println(findNoOfOccurences(arr,x));
		arr = new int[]{1, 1, 2, 2, 2, 2, 3,};
		x = 4;
		System.out.println(findNoOfOccurences(arr,x));
	}

	private static int findNoOfOccurences(int[] arr, int x) {
		int first=findFirstIndex(arr,0,arr.length-1,x);
		if(first==-1)
			return -1;
		int last=findLastIndex(arr,first,arr.length-1,x);
		return last-first+1;
	}

	private static int findFirstIndex(int[] arr, int low, int high, int x) {
		if(low<=high)
		{
			int mid=(low+high)/2;
			if((mid==0||arr[mid-1]<x)&&arr[mid]==x)
				return mid;
			if(arr[mid]<x)
			{
				return findFirstIndex(arr, mid+1, high,  x);
			}else{
				return findFirstIndex( arr, low,mid-1,  x);
			}
		}
		return -1;
	}

	private static int findLastIndex(int[] arr, int low, int high, int x) {
		if(low<=high)
		{
			int mid=(low+high)/2;
			if((mid==arr.length-1||arr[mid+1]>x)&&arr[mid]==x)
				return mid;
			if(!(x < arr[mid]))
			{
				return findLastIndex(arr, mid+1, high,  x);
			}else{
				return findLastIndex( arr, low,mid-1,  x);
			}
		}
		return -1;
	}



}