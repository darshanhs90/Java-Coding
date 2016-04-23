package yelpInterview;

public class _Array04LargestContiguousSubArray {
	public static void main(String a[]){
		int inputArray[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(findMaxSum(inputArray));
	}

	private static int findMaxSum(int[] inputArray) {
		int maxSoFar=0,maxEndingHere=0;
		for (int i = 1; i < inputArray.length; i++) {
			maxEndingHere+=inputArray[i];
			if (maxEndingHere < 0)
				maxEndingHere = 0;
			maxSoFar=Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}


}

