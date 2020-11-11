package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
		if (trust == null || (trust.length == 0 && N == 1)) {
			return N;
		}
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < trust.length; i++) {
			int trustX = trust[i][0];
			int trustY = trust[i][1];
			List<Integer> lst = new ArrayList<Integer>();
			if (map.containsKey(trustX)) {
				lst = map.get(trustX);
			}
			set.add(trustY);
			lst.add(trustY);
			map.put(trustX, lst);
		}

		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int possibleJudge = it.next();
			if (!map.containsKey(possibleJudge)) {
				boolean isValidJudge = true;
				for (int i = 1; i <= N; i++) {
					if (i != possibleJudge) {
						if (!map.containsKey(i)) {
							isValidJudge = false;
							break;
						} else {
							List<Integer> list = map.get(i);
							if (!list.contains(possibleJudge)) {
								isValidJudge = false;
								break;
							}
						}
					}
				}
				if (isValidJudge)
					return possibleJudge;
			}
		}
		return -1;
	}
}
