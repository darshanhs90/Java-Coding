package April2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0305NumberOfIslandsII {

	public static void main(String[] args) {
		System.out.println(numIslands2(3, 3,
				new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 1 } }));

		System.out.println(numIslands2(8, 6,
				new int[][] { new int[] { 0, 5 }, new int[] { 5, 4 }, new int[] { 5, 2 }, new int[] { 7, 3 },
						new int[] { 6, 0 }, new int[] { 5, 3 }, new int[] { 5, 1 }, new int[] { 1, 3 },
						new int[] { 4, 3 }, new int[] { 2, 3 }, new int[] { 3, 5 }, new int[] { 3, 2 },
						new int[] { 3, 0 }, new int[] { 2, 4 }, new int[] { 0, 1 } }));

	}

	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
		HashMap<Integer, List<int[]>> islandToPointMap = new HashMap<Integer, List<int[]>>();
		HashMap<String, Integer> pointToIslandMap = new HashMap<String, Integer>();

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		int islandNum = 0;
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < positions.length; i++) {
			int[] arr = positions[i];
			int x = arr[0];
			int y = arr[1];

			if (pointToIslandMap.containsKey(x + "/" + y)) {
				output.add(islandToPointMap.size());
				continue;
			}

			HashSet<Integer> overlappingIslands = new HashSet<Integer>();
			for (int j = 0; j < dirs.length; j++) {
				int newX = x + dirs[j][0];
				int newY = y + dirs[j][1];
				String str = newX + "/" + newY;
				if (newX < 0 || newY < 0 || newX >= m || newY >= n || !pointToIslandMap.containsKey(str))
					continue;

				overlappingIslands.add(pointToIslandMap.get(str));
			}

			if (overlappingIslands.size() == 0) {
				islandToPointMap.put(islandNum, new ArrayList<int[]>());
				islandToPointMap.get(islandNum).add(arr);
				pointToIslandMap.put(x + "/" + y, islandNum);
				islandNum++;
			} else if (overlappingIslands.size() == 1) {
				int baseIslandNum = overlappingIslands.iterator().next();
				islandToPointMap.get(baseIslandNum).add(arr);
				pointToIslandMap.put(x + "/" + y, baseIslandNum);
			} else {
				Iterator<Integer> iter = overlappingIslands.iterator();
				int baseIslandNum = iter.next();
				while (iter.hasNext()) {
					int newIsland = iter.next();
					List<int[]> list = islandToPointMap.get(newIsland);
					for (int j = 0; j < list.size(); j++) {
						int[] point = list.get(j);
						islandToPointMap.get(baseIslandNum).add(point);
						pointToIslandMap.put(point[0] + "/" + point[1], baseIslandNum);
					}

					islandToPointMap.remove(newIsland);
				}
				islandToPointMap.get(baseIslandNum).add(arr);
				pointToIslandMap.put(x + "/" + y, baseIslandNum);
			}
			output.add(islandToPointMap.size());
		}
		return output;
	}

}
