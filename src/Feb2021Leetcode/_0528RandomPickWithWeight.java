package Feb2021Leetcode;

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
		int[] sumArr;
		int totalSum = 0;

		public Solution(int[] w) {
			sumArr = new int[w.length];
			for (int i = 0; i < w.length; i++) {
				totalSum += w[i];
				sumArr[i] = totalSum;
			}
		}

		public int pickIndex() {
			double target = Math.random() * totalSum;
			int i = 0;
			for (i = 0; i < sumArr.length; i++) {
				if (sumArr[i] > target)
					return i;
			}
			return i - 1;
		}
	}

}
