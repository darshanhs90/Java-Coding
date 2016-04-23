package yelpInterview;

public class _Array18MajorityElementCheck {
	public static void main(String a[]){
		int inputArray[] = {1, 2, 3, 3, 3, 3, 10};
		int x = 3;
		System.out.println(isMajority(inputArray,x));
	}

	private static boolean isMajority(int[] inputArray, int x) {
		int index=getFirstIndex(inputArray,0,inputArray.length-1,x);
		int n=inputArray.length-1;
		if (index == -1)
			return false;
		if (((index + n/2) <= (n -1)) && inputArray[index + n/2] == x)
			return true;
		else
			return false;
	}

	private static int getFirstIndex(int[] arr, int low,int high,int x) {
		if (low<=high)
		{
			int mid = (low + high)/2; 
			if ( (mid == 0 || x > arr[mid-1]) && (arr[mid] == x) )
				return mid;
			else if (x > arr[mid])
				return getFirstIndex(arr, (mid + 1), high, x);
			else
				return getFirstIndex(arr, low, (mid -1), x);
		}

		return -1;
	}

}