package GeeksforGeeksPractice;

/*
 * Link: http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 */
public class _0123FindRepeatingElementsArray {
	public static void main(String[] args) {
		int arr[] =    {4, 2, 4, 5, 2, 3, 1};
		findRepeatingElements(arr);
		
		
		
	}

	private static void findRepeatingElements(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[Math.abs(arr[i])]>0)
				arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
			else
				System.out.println(arr[i]);
		}
		
	}

	
}
