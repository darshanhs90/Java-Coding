package May2021GoogLeetcode;

import java.util.HashSet;

public class _0947MostStonesRemovedWithSameRowOrColumn {

	public static void main(String[] args) {
		System.out.println(removeStones(new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, 0 },
				new int[] { 1, 2 }, new int[] { 2, 1 }, new int[] { 2, 2 } }));

		System.out.println(removeStones(new int[][] { new int[] { 0, 0 }, new int[] { 0, 2 }, new int[] { 1, 1 },
				new int[] { 2, 0 }, new int[] { 2, 2 } }));

		System.out.println(removeStones(new int[][] { new int[] { 0, 0 } }));
	}

	public static int removeStones(int[][] stones) {
		HashSet<String> visited = new HashSet<String>();
		int noOfIslands = 0;
		for (int[] arr : stones) {
			int x = arr[0];
			int y = arr[1];
			if (!visited.contains(x + "/" + y)) {
				dfs(x, y, visited, stones);
				noOfIslands++;
			}
		}
		return stones.length - noOfIslands;
	}

	public static void dfs(int x, int y, HashSet<String> visited, int[][] stones) {
		visited.add(x + "/" + y);
		for (int[] arr : stones) {
			int x1 = arr[0];
			int y1 = arr[1];
			if (!visited.contains(x1 + "/" + y1)) {
				if (x == x1 || y == y1) {
					dfs(x1, y1, visited, stones);
				}
			}
		}
	}
}
