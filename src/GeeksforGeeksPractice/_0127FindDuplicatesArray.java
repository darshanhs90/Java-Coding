package GeeksforGeeksPractice;

/*
 * Link: http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 */
public class _0127FindDuplicatesArray {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 1, 3, 6, 6};
		findDuplicates(arr);
	}

	private static void findDuplicates(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[Math.abs(arr[i])]>0)
				arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
			else
				System.out.println(arr[i]);
		}
		
	}

	
}
