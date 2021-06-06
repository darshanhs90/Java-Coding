package June2021GoogLeetcode;

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
		int islandNum = 1;
		List<Integer> out = new ArrayList<Integer>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		for (int i = 0; i < positions.length; i++) {
			int x = positions[i][0];
			int y = positions[i][1];

			if (pointToIslandMap.containsKey(x + "/" + y)) {
				out.add(islandToPointsMap.size());
				continue;
			}

			HashSet<Integer> islands = new HashSet<Integer>();
			for (int j = 0; j < dirs.length; j++) {
				int newX = x + dirs[j][0];
				int newY = y + dirs[j][1];

				if (newX < 0 || newY < 0 || newX >= m || newY >= n)
					continue;
				if (!pointToIslandMap.containsKey(newX + "/" + newY))
					continue;
				islands.add(pointToIslandMap.get(newX + "/" + newY));
			}

			Iterator<Integer> iter = islands.iterator();
			if (islands.size() == 0) {
				pointToIslandMap.put(x + "/" + y, islandNum);
				islandToPointsMap.put(islandNum, new ArrayList<int[]>());
				islandToPointsMap.get(islandNum).add(new int[] { x, y });
				islandNum++;
			} else if (islands.size() == 1) {
				int baseIslandNum = iter.next();
				pointToIslandMap.put(x + "/" + y, baseIslandNum);
				islandToPointsMap.get(baseIslandNum).add(new int[] { x, y });
			} else {
				int baseIslandNum = iter.next();
				pointToIslandMap.put(x + "/" + y, baseIslandNum);
				islandToPointsMap.get(baseIslandNum).add(new int[] { x, y });

				while (iter.hasNext()) {
					int currIslandNum = iter.next();
					List<int[]> list = islandToPointsMap.get(currIslandNum);

					for (int[] arr : list) {
						x = arr[0];
						y = arr[1];
						pointToIslandMap.put(x + "/" + y, baseIslandNum);
						islandToPointsMap.get(baseIslandNum).add(new int[] { x, y });
					}
					islandToPointsMap.remove(currIslandNum);
				}
			}
			out.add(islandToPointsMap.size());
		}
		return out;
	}

}
