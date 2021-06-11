package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1376TimeNeededToInformAllEmployees {
	public static void main(String[] args) {
		System.out.println(numOfMinutes(1, 0, new int[] { -1 }, new int[] { 0 }));
		System.out.println(numOfMinutes(6, 2, new int[] { 2, 2, -1, 2, 2, 2 }, new int[] { 0, 0, 1, 0, 0, 0 }));
		System.out.println(numOfMinutes(7, 6, new int[] { 1, 2, 3, 4, 5, 6, -1 }, new int[] { 0, 6, 5, 4, 3, 2, 1 }));
		System.out.println(numOfMinutes(15, 0, new int[] { -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 },
				new int[] { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }));

		System.out.println(numOfMinutes(4, 2, new int[] { 3, 3, -1, 2 }, new int[] { 0, 0, 162, 914 }));
	}

	public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		HashMap<Integer, List<Integer>> childMap = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < n; i++) {
			childMap.put(i, new ArrayList<Integer>());
		}

		for (int j = 0; j < manager.length; j++) {
			if (manager[j] != -1)
				childMap.get(manager[j]).add(j);
		}

		int max = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { headID, 0 });
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int currNode = arr[0];
				int time = arr[1];

				max = Math.max(max, time);

				List<Integer> childNodes = childMap.get(currNode);
				for (Integer child : childNodes) {
					q.offer(new int[] { child, time + informTime[currNode] });
				}
			}
		}
		return max;
	}

}
