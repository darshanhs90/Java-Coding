package DoordashPrep;

public class _0795NumberOfSubarraysWithBoundedMaximum {
	public static void main(String[] args) {
		System.out.println(numSubarrayBoundedMax(new int[] { 2, 1, 4, 3 }, 2, 3));
	}

	public static int numSubarrayBoundedMax(int[] A, int L, int R) {
		return count(A, R) - count(A, L - 1);
	}

	public static int count(int[] A, int maxVal) {
		int count = 0, currCount = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= maxVal) {
				currCount++;
			} else {
				currCount = 0;
			}
			count += currCount;
		}
		return count;
	}

}
