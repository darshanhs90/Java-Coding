package April2021PrepLeetcode;

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
		HashMap<Integer, List<int[]>> islandToPointsMap = new HashMap<Integer, List<int[]>>();
		HashMap<String, Integer> pointToIslandMap = new HashMap<String, Integer>();
		int currIslandNum = 0;
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < positions.length; i++) {
			int x = positions[i][0];
			int y = positions[i][1];

			if (pointToIslandMap.containsKey(x + "/" + y)) {
				output.add(islandToPointsMap.size());
				continue;
			}

			HashSet<Integer> overLappingIslands = new HashSet<Integer>();
			for (int j = 0; j < dirs.length; j++) {
				int newX = x + dirs[j][0];
				int newY = y + dirs[j][1];
				if (newX < 0 || newY < 0 || newX >= m || newY >= n)
					continue;
				if (!pointToIslandMap.containsKey(newX + "/" + newY))
					continue;
				overLappingIslands.add(pointToIslandMap.get(newX + "/" + newY));
			}

			if (overLappingIslands.size() == 0) {
				islandToPointsMap.put(currIslandNum, new ArrayList<int[]>());
				islandToPointsMap.get(currIslandNum).add(new int[] { x, y });
				pointToIslandMap.put(x + "/" + y, currIslandNum);
				currIslandNum++;
			} else if (overLappingIslands.size() == 1) {
				int baseIslandNum = overLappingIslands.iterator().next();
				islandToPointsMap.get(baseIslandNum).add(new int[] { x, y });
				pointToIslandMap.put(x + "/" + y, baseIslandNum);
			} else {
				Iterator<Integer> iter = overLappingIslands.iterator();
				int baseIslandNum = iter.next();

				while (iter.hasNext()) {
					int currIsland = iter.next();
					List<int[]> list = islandToPointsMap.get(currIsland);
					for (int[] arr : list) {
						pointToIslandMap.put(arr[0] + "/" + arr[1], baseIslandNum);
						islandToPointsMap.get(baseIslandNum).add(new int[] { arr[0], arr[1] });
					}
					islandToPointsMap.remove(currIsland);
				}
				islandToPointsMap.get(baseIslandNum).add(new int[] { x, y });
				pointToIslandMap.put(x + "/" + y, baseIslandNum);
			}
			output.add(islandToPointsMap.size());
		}
		return output;
	}

}
