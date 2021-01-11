package Dec2020Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _0997FindTheTownJudge {
	public static void main(String[] args) {
		System.out.println(findJudge(2, new int[][] { new int[] { 1, 2 } }));
		System.out.println(findJudge(3, new int[][] { new int[] { 1, 3 }, new int[] { 2, 3 } }));
		System.out.println(findJudge(3, new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 1 } }));
		System.out.println(findJudge(3, new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 } }));
		System.out.println(findJudge(4, new int[][] { new int[] { 1, 3 }, new int[] { 1, 4 }, new int[] { 2, 3 },
				new int[] { 2, 4 }, new int[] { 4, 3 } }));
	}

	public static int findJudge(int N, int[][] trust) {
		HashMap<Integer, HashSet<Integer>> relation = new HashMap<Integer, HashSet<Integer>>();

		for (int i = 0; i < trust.length; i++) {
			int src = trust[i][0];
			int dest = trust[i][1];
			if (relation.containsKey(src)) {
				relation.get(src).add(dest);
			} else {
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(dest);
				relation.put(src, set);
			}
		}

		int noOfJudges = 0;
		Integer judgeId = null;
		for (int i = 1; i <= N; i++) {
			if (!relation.containsKey(i)) {
				noOfJudges++;
				judgeId = i;
			}
		}

		if (noOfJudges != 1)
			return -1;
		for (int i = 1; i <= N; i++) {
			if (i != judgeId) {
				if (!relation.get(i).contains(judgeId))
					return -1;
			}
		}
		return judgeId;
	}
}
