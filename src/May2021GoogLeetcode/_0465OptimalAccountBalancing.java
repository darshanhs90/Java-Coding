package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0465OptimalAccountBalancing {

	public static void main(String[] args) {
		System.out.println(minTransfers(new int[][] { new int[] { 0, 1, 10 }, new int[] { 2, 0, 5 } }));
		System.out.println(minTransfers(new int[][] { new int[] { 0, 1, 10 }, new int[] { 1, 0, 1 },
				new int[] { 1, 2, 5 }, new int[] { 2, 0, 5 } }));
	}

	public static int minTransfers(int[][] transactions) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int[] transaction : transactions) {
			int src = transaction[0];
			int dst = transaction[1];
			int val = transaction[2];

			if (!map.containsKey(src))
				map.put(src, 0);
			if (!map.containsKey(dst))
				map.put(dst, 0);

			map.put(src, map.get(src) - val);
			map.put(dst, map.get(dst) + val);
		}

		return settle(0, new ArrayList<Integer>(map.values()));
	}

	public static int settle(int index, List<Integer> debt) {
		while (index < debt.size() && debt.get(index) == 0)
			index++;
		if (index == debt.size())
			return 0;

		int res = Integer.MAX_VALUE;
		for (int i = index + 1; i < debt.size(); i++) {
			if (debt.get(index) * debt.get(i) < 0) {
				debt.set(i, debt.get(i) + debt.get(index));
				res = Math.min(res, 1 + settle(index + 1, debt));
				debt.set(i, debt.get(i) - debt.get(index));
			}
		}
		return res;
	}

}
