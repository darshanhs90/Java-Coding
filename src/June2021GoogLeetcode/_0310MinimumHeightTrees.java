package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
		if (n == 1)
			return new ArrayList<Integer>(Arrays.asList(0));
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < n; i++) {
			map.put(i, new HashSet<Integer>());
		}

		for (int[] arr : edges) {
			int src = arr[0];
			int dst = arr[1];
			map.get(src).add(dst);
			map.get(dst).add(src);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 1) {
				q.offer(entry.getKey());
			}
		}

		while (n > 2) {
			n -= q.size();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int node = q.poll();
				for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
					if (entry.getValue().contains(node)) {
						entry.getValue().remove(node);
						if (entry.getValue().size() == 1) {
							q.offer(entry.getKey());
						}
					}
				}
			}
		}

		return (List<Integer>) q;
	}
}
