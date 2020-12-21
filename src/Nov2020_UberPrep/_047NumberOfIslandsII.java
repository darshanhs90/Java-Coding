package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _047NumberOfIslandsII {

	public static void main(String[] args) {
		System.out.println(numIslands2(3, 3,
				new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 1 } }));

		System.out.println(numIslands2(3, 3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 1 },
				new int[] { 1, 0 }, new int[] { 0, 2 }, new int[] { 0, 0 }, new int[] { 1, 1 } }));
	}

	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
		HashMap<Integer, Integer> pointsToIslandIdMap = new HashMap<Integer, Integer>();
		int noOfIslands = 0;
		int islandId = 0;
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < positions.length; i++) {
			int x = positions[i][0];
			int y = positions[i][1];

			if (pointsToIslandIdMap.containsKey(x * n + y)) {
				output.add(noOfIslands);
				continue;
			}

			HashSet<Integer> islands = new HashSet<Integer>();
			if (x - 1 >= 0 && pointsToIslandIdMap.containsKey((x - 1) * n + y)) {
				islands.add(pointsToIslandIdMap.get((x - 1) * n + y));
			}

			if (x + 1 < m && pointsToIslandIdMap.containsKey((x + 1) * n + y)) {
				islands.add(pointsToIslandIdMap.get((x + 1) * n + y));
			}

			if (y - 1 >= 0 && pointsToIslandIdMap.containsKey((x) * n + y - 1)) {
				islands.add(pointsToIslandIdMap.get((x) * n + y - 1));
			}

			if (y + 1 < n && pointsToIslandIdMap.containsKey((x) * n + y + 1)) {
				islands.add(pointsToIslandIdMap.get((x) * n + y + 1));
			}

			if (islands.size() == 0) {
				pointsToIslandIdMap.put(x * n + y, islandId);
				islandId++;
				noOfIslands++;
			} else if (islands.size() == 1) {
				pointsToIslandIdMap.put(x * n + y, islands.iterator().next());
			} else {
				int mainIslandId = islands.iterator().next();

				for (Map.Entry<Integer, Integer> entry : pointsToIslandIdMap.entrySet()) {
					if (islands.contains(entry.getValue())) {
						pointsToIslandIdMap.put(entry.getKey(), mainIslandId);
					}
				}
				pointsToIslandIdMap.put(x * n + y, mainIslandId);
				noOfIslands = noOfIslands - (islands.size() - 1);
			}
			output.add(noOfIslands);
		}
		return output;
	}

}
