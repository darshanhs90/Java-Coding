package GeeksforGeeksPractice;

/*
 * Link: http://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 */
public class _0116MaxAndMinOfArray {
	public static void main(String[] args) {
		int arr[] = {1000, 11, 445, 1, 330, 3000};
		findMaxMin(arr);
	}

	private static void findMaxMin(int[] arr) {
		int max=arr[0],min=arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>max)
				max=arr[i];
			if(arr[i]<min)
				min=arr[i];
		}
		System.out.println(min+"/"+max);
	}



}
