package May2021GoogLeetcode;

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
		int totalSum = 0;
		int[] w;

		public Solution(int[] w) {
			for (int i = 0; i < w.length; i++) {
				totalSum += w[i];
				w[i] = totalSum;
			}
			this.w = w;
		}

		public int pickIndex() {
			int i = 0;
			double random = Math.random() * totalSum;
			for (i = 0; i < w.length; i++) {
				if (w[i] > random)
					return i;
			}
			return w.length - 1;
		}
	}

}
