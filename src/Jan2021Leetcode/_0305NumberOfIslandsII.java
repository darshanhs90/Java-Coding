package Jan2021Leetcode;

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

	static int islandNum;

	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
		islandNum = 0;
		HashMap<Integer, List<int[]>> islandMap = new HashMap<Integer, List<int[]>>();
		HashMap<String, Integer> pointToIslandMap = new HashMap<String, Integer>();
		List<Integer> out = new ArrayList<Integer>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		for (int i = 0; i < positions.length; i++) {
			int x = positions[i][0];
			int y = positions[i][1];

			if (pointToIslandMap.containsKey(x + "," + y)) {
				out.add(islandMap.size());
				continue;
			}

			HashSet<Integer> overLapIslandNumbers = new HashSet<Integer>();
			for (int j = 0; j < dirs.length; j++) {
				int newX = x + dirs[j][0];
				int newY = y + dirs[j][1];
				if (newX < 0 || newY < 0 || newX >= m || newY >= n || !pointToIslandMap.containsKey(newX + "," + newY))
					continue;
				overLapIslandNumbers.add(pointToIslandMap.get(newX + "," + newY));
			}

			if (overLapIslandNumbers.size() == 0) {
				pointToIslandMap.put(x + "," + y, islandNum);
				islandMap.put(islandNum, new ArrayList<int[]>());
				islandMap.get(islandNum).add(new int[] { x, y });
				islandNum++;
			} else if (overLapIslandNumbers.size() == 1) {
				Integer overLapIslandNum = overLapIslandNumbers.iterator().next();
				pointToIslandMap.put(x + "," + y, overLapIslandNum);
				islandMap.get(overLapIslandNum).add(new int[] { x, y });
			} else {
				// merge
				Iterator<Integer> iter = overLapIslandNumbers.iterator();
				Integer mainIslandNum = iter.next();
				List<int[]> list = islandMap.get(mainIslandNum);
				pointToIslandMap.put(x + "," + y, mainIslandNum);
				list.add(new int[] { x, y });
				while (iter.hasNext()) {
					Integer currIsland = iter.next();
					list.addAll(islandMap.get(currIsland));
					islandMap.remove(currIsland);
				}

				islandMap.put(mainIslandNum, list);

				for (int j = 0; j < list.size(); j++) {
					int currX = list.get(j)[0];
					int currY = list.get(j)[1];
					pointToIslandMap.put(currX + "," + currY, mainIslandNum);
				}
			}

			out.add(islandMap.size());
		}
		return out;
	}

}
