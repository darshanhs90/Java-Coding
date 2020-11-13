package Leetcode2020Nov;

import java.util.HashMap;

public class _1128NumberOfEquivalentDominoPairs {
	public static void main(String[] args) {
		System.out.println(numEquivDominoPairs(
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 1 }, new int[] { 3, 4 }, new int[] { 5, 6 } }));

		System.out.println(numEquivDominoPairs(new int[][] { new int[] { 1, 2 }, new int[] { 1, 2 }, new int[] { 1, 1 },
				new int[] { 1, 2 }, new int[] { 2, 2 } }));

		System.out.println(numEquivDominoPairs(new int[][] { new int[] { 1, 1 }, new int[] { 2, 2 }, new int[] { 1, 1 },
				new int[] { 1, 2 }, new int[] { 1, 2 }, new int[] { 1, 1 } }));
	}

	public static int numEquivDominoPairs(int[][] dominoes) {
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < dominoes.length; i++) {
			int x = dominoes[i][0];
			int y = dominoes[i][1];
			int min = Math.min(x, y);
			int max = Math.max(x, y);
			int val = 10 * min + max;
			int currVal = 0;
			if (map.containsKey(val)) {
				currVal = map.get(val);
			} else {
				currVal = 0;
			}

			result += currVal;
			map.put(val, 1 + currVal);
		}
		return result;
	}
}
