package Jan2021Leetcode;

public class _0528RandomPickWithWeight {
	public static void main(String[] args) {
		Solution solution = new Solution(new int[] { 1 });
		System.out.println(solution.pickIndex()); // return 0. Since there is only one single element on the array the
													// only option is to return the first element.

		solution = new Solution(new int[] { 1, 3 });
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
	}

	static class Solution {
		int prefixSum[];
		int totalSum;

		public Solution(int[] w) {

			prefixSum = new int[w.length];
			totalSum = 0;
			for (int i = 0; i < w.length; i++) {
				totalSum += w[i];
				prefixSum[i] = totalSum;
			}
		}

		public int pickIndex() {
			double targetNum = (int) (Math.random() * totalSum);
			int left = 0, right = prefixSum.length;
			while (left < right) {
				int mid = (left + right) / 2;
				if (prefixSum[mid] < targetNum) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			return left;
		}
	}

}
