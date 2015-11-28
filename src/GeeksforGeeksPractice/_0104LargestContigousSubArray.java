package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 */
public class _0104LargestContigousSubArray {
	public static void main(String[] args) {
		int inputArray[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(findLargestSubArray(inputArray));
	}

	private static int findLargestSubArray(int[] inputArray) {
		int maxSoFAr=0,maxEndingHere=0;
		for (int i = 0; i < inputArray.length; i++) {
			maxEndingHere=maxEndingHere+inputArray[i];
			if(maxEndingHere<0)
				maxEndingHere=0;
			maxSoFAr=Math.max(maxSoFAr, maxEndingHere);
		}
		return maxSoFAr;
	}




}
