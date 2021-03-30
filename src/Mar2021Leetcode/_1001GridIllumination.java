package Mar2021Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _1001GridIllumination {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(gridIllumination(5, new int[][] { new int[] { 0, 0 }, new int[] { 4, 4 } },
				new int[][] { new int[] { 1, 1 }, new int[] { 1, 0 } })));
	}

	public static int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
		int[] out = new int[queries.length];
		HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> colMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> fwDiagMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> bwDiagMap = new HashMap<Integer, Integer>();
		HashSet<String> lampSet = new HashSet<String>();

		for (int i = 0; i < lamps.length; i++) {
			int x = lamps[i][0];
			int y = lamps[i][1];

			if (lampSet.contains(x + "/" + y))
				continue;

			lampSet.add(x + "/" + y);
			rowMap.compute(x, (k, v) -> v == null ? 1 : v + 1);
			colMap.compute(y, (k, v) -> v == null ? 1 : v + 1);
			fwDiagMap.compute(x + y, (k, v) -> v == null ? 1 : v + 1);
			bwDiagMap.compute(x - y, (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < queries.length; i++) {
			out[i] = getCount(queries[i], rowMap, colMap, fwDiagMap, bwDiagMap);
			updateNeighbors(queries[i], rowMap, colMap, fwDiagMap, bwDiagMap, lampSet);
		}
		return out;
	}

	public static void updateNeighbors(int[] query, HashMap<Integer, Integer> rowMap, HashMap<Integer, Integer> colMap,
			HashMap<Integer, Integer> fwDiagMap, HashMap<Integer, Integer> bwDiagMap, HashSet<String> lampSet) {

		int[][] dirs = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, 1 },
				new int[] { 0, -1 }, new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, -1 }, new int[] { 1, 0 },
				new int[] { 1, 1 } };
		int x = query[0];
		int y = query[1];

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];
			if (!lampSet.contains(newX + "/" + newY))
				continue;

			rowMap.put(newX, rowMap.get(newX) - 1);
			colMap.put(newY, colMap.get(newY) - 1);
			fwDiagMap.put(newX + newY, fwDiagMap.get(newX + newY) - 1);
			bwDiagMap.put(newX - newY, bwDiagMap.get(newX - newY) - 1);
			lampSet.remove(newX + "/" + newY);
		}
	}

	public static int getCount(int[] query, HashMap<Integer, Integer> rowMap, HashMap<Integer, Integer> colMap,
			HashMap<Integer, Integer> fwDiagMap, HashMap<Integer, Integer> bwDiagMap) {
		int x = query[0];
		int y = query[1];

		if (rowMap.containsKey(x) && rowMap.get(x) > 0)
			return 1;

		if (colMap.containsKey(y) && colMap.get(y) > 0)
			return 1;

		if (fwDiagMap.containsKey(x + y) && fwDiagMap.get(x + y) > 0)
			return 1;

		if (bwDiagMap.containsKey(x - y) && bwDiagMap.get(x - y) > 0)
			return 1;
		return 0;
	}
}
