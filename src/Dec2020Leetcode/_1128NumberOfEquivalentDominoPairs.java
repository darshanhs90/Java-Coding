package Dec2020Leetcode;

import java.util.HashMap;
import java.util.Map;

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
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int count = 0;
		for (int i = 0; i < dominoes.length; i++) {
			int x = Math.min(dominoes[i][0], dominoes[i][1]);
			int y = Math.max(dominoes[i][0], dominoes[i][1]);
			map.compute(x + "," + y, (k, v) -> v == null ? 1 : v + 1);
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			count+=(entry.getValue() * (entry.getValue()-1))/2;
		}

		return count;
	}

}
