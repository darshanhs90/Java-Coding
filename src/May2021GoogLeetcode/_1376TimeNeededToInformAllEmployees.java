package May2021GoogLeetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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

		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i <= n; i++) {
			map.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < manager.length; i++) {
			int currEmp = i;
			int empManager = manager[i];
			if (empManager != -1)
				map.get(empManager).add(currEmp);
		}

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { headID, 0 });
		int ans = 0;
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int emp = arr[0];
			int time = arr[1];
			ans = Math.max(time, ans);
			for (int v : map.get(emp)) {
				q.offer(new int[] { v, time + informTime[emp] });
			}

		}
		return ans;
	}

}
