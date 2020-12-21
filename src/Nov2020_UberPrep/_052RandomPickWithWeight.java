package Nov2020_UberPrep;

import java.util.Random;

public class _052RandomPickWithWeight {

	public static void main(String[] args) {
		Solution solution = new Solution(new int[] { 1 });
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());

		solution = new Solution(new int[] { 1, 3 });
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());

		solution = new Solution(new int[] { 1, 9, 11 });
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());
		System.out.println(solution.pickIndex());

	}

	static class Solution {
		int totalSum;
		int prefixSum[];
		Random rand;

		public Solution(int[] w) {
			this.prefixSum = new int[w.length];
			int sum = 0;
			for (int i = 0; i < w.length; i++) {
				sum += w[i];
				this.prefixSum[i] = sum;
			}
			this.totalSum = sum;
			rand = new Random();
		}

		public int pickIndex() {
			int val = rand.nextInt(totalSum);
			for (int i = 0; i < prefixSum.length; i++) {
				if (prefixSum[i] > val)
					return i;
			}
			return -1;
		}
	}

}
