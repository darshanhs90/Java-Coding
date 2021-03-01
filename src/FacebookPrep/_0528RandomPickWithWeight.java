package FacebookPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		List<Integer> list;
		Random rand;

		public Solution(int[] w) {
			rand = new Random();
			list = new ArrayList<Integer>();
			for (int i = 0; i < w.length; i++) {
				for (int j = 0; j < w[i]; j++) {
					list.add(i);
				}
			}
		}

		public int pickIndex() {
			return list.get(rand.nextInt(list.size()));
		}
	}

}
