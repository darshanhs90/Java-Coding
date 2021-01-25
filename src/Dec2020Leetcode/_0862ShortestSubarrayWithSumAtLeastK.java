package Dec2020Leetcode;

public class _0862ShortestSubarrayWithSumAtLeastK {

	public static void main(String[] args) {
		System.out.println(shortestSubarray(new int[] { 1 }, 1));
		System.out.println(shortestSubarray(new int[] { 1, 2 }, 4));
		System.out.println(shortestSubarray(new int[] { 2, -1, 2 }, 3));
	}

	public static int shortestSubarray(int[] A, int K) {
		int minLength = Integer.MAX_VALUE;
		int left = 0, right = 0;
		int sum = 0;
		while (right < A.length) {
			sum += A[right];
			if (sum >= K) {
				while (left < A.length && sum >= K) {
					minLength = Math.min(minLength, right - left + 1);
					sum -= A[left];
					left++;
				}
			}
			right++;
		}
		return minLength == Integer.MAX_VALUE ? -1 : minLength;
	}
}
