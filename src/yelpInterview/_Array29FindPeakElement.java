package yelpInterview;

public class _Array29FindPeakElement {
	public static void main(String a[]){
		int arr[] = {1, 3, 20, 4, 1, 0};
		System.out.println(findPeakElement(arr));
	}

	private static int findPeakElement(int[] arr) {
		int output=-1;
		for (int i = 1; i < arr.length-2; i++) {
			if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
				return arr[i];
		}
		return output;
	}


}