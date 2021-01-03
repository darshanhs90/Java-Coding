package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
		HashMap<Integer, List<Pair>> islandMap = new HashMap<Integer, List<Pair>>();
		List<Integer> output = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0; i < positions.length; i++) {
			int x = positions[i][0];
			int y = positions[i][1];
			if (islandMap.size() == 0) {
				List<Pair> list = new ArrayList<Pair>();
				list.add(new Pair(x, y));
				islandMap.put(count, list);
				count++;
			} else {
				HashSet<Integer> overLapIslands = new HashSet<Integer>();

				int islandId = doesOverLap(x, y, islandMap);
				if (islandId != -1) {
					output.add(islandMap.size());
					continue;
				}

				if (x - 1 >= 0) {
					islandId = doesOverLap(x - 1, y, islandMap);
					if (islandId != -1)
						overLapIslands.add(islandId);
				}

				if (x + 1 < m) {
					islandId = doesOverLap(x + 1, y, islandMap);
					if (islandId != -1)
						overLapIslands.add(islandId);
				}

				if (y - 1 >= 0) {
					islandId = doesOverLap(x, y - 1, islandMap);
					if (islandId != -1)
						overLapIslands.add(islandId);
				}

				if (y + 1 < n) {
					islandId = doesOverLap(x, y + 1, islandMap);
					if (islandId != -1)
						overLapIslands.add(islandId);
				}

				if (overLapIslands.size() == 0) {
					islandMap.put(count, new ArrayList<Pair>(Arrays.asList(new Pair(x, y))));
					count++;
				} else if (overLapIslands.size() == 1) {
					islandMap.get(overLapIslands.iterator().next()).add(new Pair(x, y));
				} else {
					Iterator<Integer> iter = overLapIslands.iterator();
					int mainIsland = iter.next();
					while (iter.hasNext()) {
						islandId = iter.next();
						islandMap.get(mainIsland).addAll(islandMap.get(islandId));
						islandMap.remove(islandId);
					}
					islandMap.get(mainIsland).add(new Pair(x, y));
				}
			}
			output.add(islandMap.size());
		}
		return output;
	}

	public static int doesOverLap(int x, int y, HashMap<Integer, List<Pair>> islandMap) {
		int islandId = -1;
		for (Map.Entry<Integer, List<Pair>> entry : islandMap.entrySet()) {
			List<Pair> list = entry.getValue();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).x == x && list.get(i).y == y)
					return entry.getKey();
			}
		}
		return islandId;
	}

}
