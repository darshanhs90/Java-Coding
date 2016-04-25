package yelpInterview;

public class _Array47FindElementOccuringOnce {
	public static void main(String a[]){
		int arr[] = {7, 3, 5, 4, 5, 3, 4};
		System.out.println(findElementOccuringOnce(arr));
	}

	private static int findElementOccuringOnce(int[] arr) {
		int output=arr[0];
		for (int i = 1; i < arr.length; i++) {
			output^=arr[i];
		}
		return output;
	}

	

}