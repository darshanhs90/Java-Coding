package DropboxPrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _1001GridIllumination {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(gridIllumination(5, new int[][] { new int[] { 0, 0 }, new int[] { 4, 4 } },
				new int[][] { new int[] { 1, 1 }, new int[] { 1, 0 } })));
	}

	public static int[] gridIllumination(int N, int[][] lamps, int[][] queries) {

		HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> colMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> diagFwMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> diagBwMap = new HashMap<Integer, Integer>();
		HashSet<String> lampsSet = new HashSet<String>();
		for (int i = 0; i < lamps.length; i++) {
			int[] lamp = lamps[i];
			int x = lamp[0];
			int y = lamp[1];
			if (lampsSet.contains(x + "/" + y))
				continue;
			lampsSet.add(x + "/" + y);
			rowMap.compute(x, (k, v) -> v == null ? 1 : v + 1);
			colMap.compute(y, (k, v) -> v == null ? 1 : v + 1);
			diagFwMap.compute(x - y, (k, v) -> v == null ? 1 : v + 1);
			diagBwMap.compute(x + y, (k, v) -> v == null ? 1 : v + 1);
		}
		int[] out = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			out[i] = isIlluminated(queries[i], rowMap, colMap, diagFwMap, diagBwMap);
			turnOffNeighbors(queries[i], rowMap, colMap, diagFwMap, diagBwMap, lampsSet);
		}
		return out;
	}

	public static void turnOffNeighbors(int[] query, HashMap<Integer, Integer> rowMap, HashMap<Integer, Integer> colMap,
			HashMap<Integer, Integer> diagFwMap, HashMap<Integer, Integer> diagBwMap, HashSet<String> lampsSet) {

		int[][] dirs = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, 1 },
				new int[] { 0, -1 }, new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, -1 }, new int[] { 1, 0 },
				new int[] { 1, 1 }, };
		int x = query[0];
		int y = query[1];

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];
			if (!lampsSet.contains(newX + "/" + newY))
				continue;
			lampsSet.remove(newX + "/" + newY);
			rowMap.put(newX, rowMap.get(newX) - 1);
			colMap.put(newY, colMap.get(newY) - 1);
			diagFwMap.put(newX - newY, diagFwMap.get(newX - newY) - 1);
			diagBwMap.put(newX + newY, diagBwMap.get(newX + newY) - 1);
		}
	}

	public static int isIlluminated(int[] query, HashMap<Integer, Integer> rowMap, HashMap<Integer, Integer> colMap,
			HashMap<Integer, Integer> diagFwMap, HashMap<Integer, Integer> diagBwMap) {

		int x = query[0];
		int y = query[1];

		if (rowMap.containsKey(x) && rowMap.get(x) > 0)
			return 1;

		if (colMap.containsKey(y) && colMap.get(y) > 0)
			return 1;

		if (diagFwMap.containsKey(x - y) && diagFwMap.get(x - y) > 0)
			return 1;

		if (diagBwMap.containsKey(x + y) && diagBwMap.get(x + y) > 0)
			return 1;

		return 0;
	}
}
