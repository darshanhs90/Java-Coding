package Nov2020_GoogPrep;

import java.util.HashSet;

public class _044MostStonesRemovedWithSameRowOrColumn {

	public static void main(String[] args) {
		System.out.println(removeStones(new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, 0 },
				new int[] { 1, 2 }, new int[] { 2, 1 }, new int[] { 2, 2 } }));
		System.out.println(removeStones(new int[][] { new int[] { 0, 0 }, new int[] { 0, 2 }, new int[] { 1, 1 },
				new int[] { 2, 0 }, new int[] { 2, 2 } }));
		System.out.println(removeStones(new int[][] { new int[] { 0, 0 } }));
	}

	public static int removeStones(int[][] stones) {
		int noOfIslands = 0;
		HashSet<int[]> visited = new HashSet<int[]>();
		for (int i = 0; i < stones.length; i++) {
			if (!visited.contains(stones[i])) {
				dfs(stones[i], stones, visited);
				noOfIslands++;
			}
		}

		return stones.length - noOfIslands;
	}

	public static void dfs(int[] currStone, int[][] stones, HashSet<int[]> visited) {
		visited.add(currStone);
		for (int i = 0; i < stones.length; i++) {
			if (!visited.contains(stones[i])) {
				if (stones[i][0] == currStone[0] || stones[i][1] == currStone[1])
					dfs(stones[i], stones, visited);
			}
		}
	}
}
