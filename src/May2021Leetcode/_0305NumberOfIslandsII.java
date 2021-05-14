package May2021Leetcode;

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
		HashMap<Integer, List<int[]>> islandPointsMap = new HashMap<Integer, List<int[]>>();
		HashMap<String, Integer> pointIslandMap = new HashMap<String, Integer>();
		int islandNum = 1;
		List<Integer> output = new ArrayList<Integer>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		for (int i = 0; i < positions.length; i++) {
			int[] arr = positions[i];
			int x = arr[0];
			int y = arr[1];

			if (pointIslandMap.containsKey(x + "/" + y)) {
				output.add(islandPointsMap.size());
				continue;
			}

			HashSet<Integer> overLappingIslands = new HashSet<Integer>();

			for (int j = 0; j < dirs.length; j++) {
				int newX = x + dirs[j][0];
				int newY = y + dirs[j][1];
				if (newX < 0 || newY < 0 || newX >= m || newY >= n)
					continue;
				if (!pointIslandMap.containsKey(newX + "/" + newY))
					continue;
				overLappingIslands.add(pointIslandMap.get(newX + "/" + newY));
			}

			Iterator<Integer> iter = overLappingIslands.iterator();
			if (overLappingIslands.size() == 0) {
				islandPointsMap.put(islandNum, new ArrayList<int[]>());
				islandPointsMap.get(islandNum).add(arr);
				pointIslandMap.put(x + "/" + y, islandNum);
				islandNum++;
			} else if (overLappingIslands.size() == 1) {
				int baseIslandNum = iter.next();
				islandPointsMap.get(baseIslandNum).add(arr);
				pointIslandMap.put(x + "/" + y, baseIslandNum);
			} else {
				int baseIslandNum = iter.next();

				while (iter.hasNext()) {
					int currNum = iter.next();
					List<int[]> points = islandPointsMap.get(currNum);
					for (int[] point : points) {
						int currX = point[0];
						int currY = point[1];
						islandPointsMap.get(baseIslandNum).add(point);
						pointIslandMap.put(currX + "/" + currY, baseIslandNum);
					}
					islandPointsMap.remove(currNum);
				}
				islandPointsMap.get(baseIslandNum).add(arr);
				pointIslandMap.put(x + "/" + y, baseIslandNum);
			}
			output.add(islandPointsMap.size());
		}
		return output;
	}

}
