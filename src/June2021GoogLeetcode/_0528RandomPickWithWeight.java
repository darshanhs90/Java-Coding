package June2021GoogLeetcode;

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
		int[] w;
		int total;

		public Solution(int[] w) {
			total = 0;
			for (int i = 0; i < w.length; i++) {
				total += w[i];
				w[i] = total;
			}
			this.w = w;
		}

		public int pickIndex() {
			double val = Math.random() * total;
			int i = 0;
			for (i = 0; i < w.length; i++) {

				if (w[i] > val)
					return i;
			}
			return i - 1;
		}
	}

}
