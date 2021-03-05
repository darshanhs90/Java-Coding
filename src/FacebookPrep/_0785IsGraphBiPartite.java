package FacebookPrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class _0785IsGraphBiPartite {
	public static void main(String[] args) {
		System.out.println(isBipartite(
				new int[][] { new int[] { 1, 2, 3 }, new int[] { 0, 2 }, new int[] { 0, 1, 3 }, new int[] { 0, 2 } }));

		System.out.println(isBipartite(
				new int[][] { new int[] { 1, 3 }, new int[] { 0, 2 }, new int[] { 1, 3 }, new int[] { 0, 2 } }));
	}

	public static boolean isBipartite(int[][] graph) {
		HashMap<Integer, HashSet<Integer>> adjList = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < graph.length; i++) {
			adjList.put(i, new HashSet<Integer>());
			for (int j = 0; j < graph[i].length; j++) {
				adjList.get(i).add(graph[i][j]);
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		int[] color = new int[graph.length];
		Arrays.fill(color, -1);
		q.offer(0);
		int currColor = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int node = q.poll();

				if (color[node] == -1 || color[node] == currColor) {
					color[node] = currColor;
				} else {
					return false;
				}

				Iterator<Integer> iter = adjList.get(node).iterator();

				while (iter.hasNext()) {
					int neighborNode = iter.next();
					if (color[neighborNode] == -1) {
						q.offer(neighborNode);
					} else if (color[neighborNode] == currColor) {
						return false;
					}
				}
			}
			currColor = currColor == 1 ? 2 : 1;
		}
		return true;
	}

}
