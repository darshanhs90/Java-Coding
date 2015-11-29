package GeeksforGeeksPractice;

/*
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */
public class _0110MaxSumAdjacentElementsArray {
	public static void main(String[] args) {
		int arr[] = {3,2,7,10};
		System.out.println(findMaxSum(arr));
	}

	private static int findMaxSum(int[] arr) {
		int incl=arr[0],excl=0;
		for (int i = 1; i < arr.length; i++) {
			int excl_new= excl>incl?excl:incl;
			incl=excl+arr[i];
			excl=excl_new;
		}
		return excl>incl?excl:incl;
	}

	
}
