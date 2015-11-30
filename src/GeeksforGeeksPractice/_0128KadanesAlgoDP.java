package GeeksforGeeksPractice;

/*
 * Link: http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class _0128KadanesAlgoDP {
	public static void main(String[] args) {
		int arr[]= {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(findLCS(arr));
	}

	private static int findLCS(int[] arr) {
		int maxSoFar=0,maxEndingHere=0;
		for (int i = 0; i < arr.length; i++) {
			maxEndingHere+=arr[i];
			if(maxEndingHere<0)
				maxEndingHere=0;
			maxSoFar=Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}



}
