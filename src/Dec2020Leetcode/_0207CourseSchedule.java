package Dec2020Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _0207CourseSchedule {
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] { new int[] { 1, 0 } }));
		System.out.println(canFinish(2, new int[][] { new int[] { 1, 0 }, new int[] { 0, 1 } }));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, HashSet<Integer>> adjList = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, Integer> adjListCount = new HashMap<Integer, Integer>();
		for (int i = 0; i < numCourses; i++) {
			adjList.put(i, new HashSet<Integer>());
			adjListCount.put(i, 0);
		}

		for (int[] prereq : prerequisites) {
			adjList.get(prereq[1]).add(prereq[0]);
			adjListCount.put(prereq[1], adjListCount.get(prereq[1]) + 1);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (Map.Entry<Integer, Integer> entry : adjListCount.entrySet()) {
			if (entry.getValue() == 0) {
				q.add(entry.getKey());
				adjListCount.put(entry.getKey(), -1);
			}
		}
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer node = q.poll();
				count++;
				// find all nodes with values of this node and remove adjlistcount
				for (Map.Entry<Integer, HashSet<Integer>> entry : adjList.entrySet()) {
					if (entry.getValue().contains(node)) {
						entry.getValue().remove(node);
						adjListCount.put(entry.getKey(), adjListCount.get(entry.getKey()) - 1);
					}

					if (adjListCount.get(entry.getKey()) == 0) {
						q.add(entry.getKey());
						adjListCount.put(entry.getKey(), -1);
					}
				}
			}

		}

		return count == numCourses;
	}
}
