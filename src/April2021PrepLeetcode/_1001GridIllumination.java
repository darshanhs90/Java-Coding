package April2021PrepLeetcode;

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
		HashMap<Integer, Integer> fowMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> bowMap = new HashMap<Integer, Integer>();
		HashSet<String> lampSet = new HashSet<String>();
		for (int i = 0; i < lamps.length; i++) {
			int x = lamps[i][0];
			int y = lamps[i][1];

			if (lampSet.contains(x + "/" + y))
				continue;
			lampSet.add(x + "/" + y);
			rowMap.compute(x, (k, v) -> v == null ? 1 : v + 1);
			colMap.compute(y, (k, v) -> v == null ? 1 : v + 1);
			fowMap.compute(x + y, (k, v) -> v == null ? 1 : v + 1);
			bowMap.compute(x - y, (k, v) -> v == null ? 1 : v + 1);
		}
		int[] out = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0];
			int y = queries[i][1];
			out[i] = isIlluminated(x, y, rowMap, colMap, fowMap, bowMap);
			turnOffNeighbors(x, y, rowMap, colMap, fowMap, bowMap, lampSet);
		}
		return out;
	}

	public static int isIlluminated(int x, int y, HashMap<Integer, Integer> rowMap, HashMap<Integer, Integer> colMap,
			HashMap<Integer, Integer> fowMap, HashMap<Integer, Integer> bowMap) {
		if (rowMap.containsKey(x) && rowMap.get(x) > 0)
			return 1;
		if (colMap.containsKey(y) && colMap.get(y) > 0)
			return 1;
		if (fowMap.containsKey(x + y) && fowMap.get(x + y) > 0)
			return 1;
		if (bowMap.containsKey(x - y) && bowMap.get(x - y) > 0)
			return 1;
		return 0;
	}

	public static void turnOffNeighbors(int x, int y, HashMap<Integer, Integer> rowMap,
			HashMap<Integer, Integer> colMap, HashMap<Integer, Integer> fowMap, HashMap<Integer, Integer> bowMap,
			HashSet<String> lampSet) {
		int[][] dirs = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, 1 },
				new int[] { 0, -1 }, new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, -1 }, new int[] { 1, 0 },
				new int[] { 1, 1 }, };

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (!lampSet.contains(newX + "/" + newY))
				continue;
			lampSet.remove(newX + "/" + newY);
			rowMap.put(newX, rowMap.get(newX) - 1);
			colMap.put(newY, colMap.get(newY) - 1);
			fowMap.put(newX + newY, fowMap.get(newX + newY) - 1);
			bowMap.put(newX - newY, bowMap.get(newX - newY) - 1);
		}
	}

}
