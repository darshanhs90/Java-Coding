package geeksforgeeks;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-36/
 * Given an array of positive numbers, find the maximum sum
 * of a subsequence with the constraint that no 2 numbers in
 * the sequence should be adjacent in the array.
 * So 3 2 7 10 should return 13 (sum of 3 and 10) or
 * 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 */;
 public class _01AmazonInterview_36_01 {
	 public static void main(String[] args) {
		int inputArray[]={3,2,7,10};
		System.out.println(findMaxSum(inputArray));
	 }

	private static int findMaxSum(int[] inputArray) {
		int incl=inputArray[0];
		int excl=0;
		for (int i = 1; i < inputArray.length; i++) {
			int temp=(incl>excl)?incl:excl;
			incl=excl+inputArray[i];
			excl=temp;
		}
		return (incl>excl)?incl:excl;
	}
 }