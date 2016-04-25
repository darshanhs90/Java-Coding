package yelpInterview;

public class _Array30MaxRepeatingNumber {
	public static void main(String a[]){
		int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
		int n = arr.length;
		int k = 8;
		System.out.println(findMaxRepeatingNumber(arr,k));
	}

	private static int findMaxRepeatingNumber(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			arr[arr[i]%k]+=k;
		}

		int max=arr[0],index=0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>max)
			{
				max=arr[i];
				index=i;
			}
		}
		return index;
	}



}