package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0310MinimumHeightTrees {

	public static void main(String[] args) {
		System.out.println(
				findMinHeightTrees(4, new int[][] { new int[] { 1, 0 }, new int[] { 1, 2 }, new int[] { 1, 3 } }));
		System.out.println(findMinHeightTrees(6, new int[][] { new int[] { 3, 0 }, new int[] { 3, 1 },
				new int[] { 3, 2 }, new int[] { 3, 4 }, new int[] { 5, 4 } }));
		System.out.println(findMinHeightTrees(1, new int[][] {}));
		System.out.println(findMinHeightTrees(2, new int[][] { new int[] { 0, 1 } }));
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> leaves = new ArrayList<Integer>();
		if (n == 0)
			return leaves;
		else if (n == 1) {
			leaves.add(0);
			return leaves;
		}
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		int[] degree = new int[n];
		for (int i = 0; i < degree.length; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			degree[x]++;
			degree[y]++;
			adjList.get(x).add(y);
			adjList.get(y).add(x);
		}

		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 1) {
				leaves.add(i);
			}
		}

		while (n > 2) {
			n = n - leaves.size();
			List<Integer> newLeaves = new ArrayList<Integer>();
			for (Integer leafNode : leaves) {
				Integer adjNodesOfLeaf = adjList.get(leafNode).get(0);
				degree[adjNodesOfLeaf]--;
				if (degree[adjNodesOfLeaf] == 1)
					newLeaves.add(adjNodesOfLeaf);
			}
			leaves = newLeaves;
		}

		return leaves;
	}
}
