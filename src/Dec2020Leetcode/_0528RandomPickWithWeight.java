package Dec2020Leetcode;

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
		List<Integer> list = new ArrayList<Integer>();
		Random rand;

		public Solution(int[] w) {
			for (int i = 0; i < w.length; i++) {
				int val = w[i];
				for (int j = 0; j < val; j++) {
					list.add(i);
				}
			}
			rand = new Random();
		}

		public int pickIndex() {
			return list.get(rand.nextInt(list.size()));
		}
	}

}
