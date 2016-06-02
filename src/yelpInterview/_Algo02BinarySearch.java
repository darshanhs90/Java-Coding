package yelpInterview;

public class _Algo02BinarySearch {

	public static void main(String a[]){
		System.out.println(binSearch(new int[]{2, 3, 4, 10, 40},10));
		System.out.println(binSearch(new int[]{2, 3, 4, 10, 40},11));		
	}

	private static int binSearch(int[] inputArray, int key) {
		int low=0,high=inputArray.length-1;
		while(low<high)
		{
			int mid=(low+high)/2;
			if(inputArray[mid]==key)
			{
				return mid;
			}
			else if(inputArray[mid]>key)
			{
				high=mid-1;
			}else if(inputArray[mid]<key)
			{
				low=mid+1;
			}
		}
		return -1;
	}



}

