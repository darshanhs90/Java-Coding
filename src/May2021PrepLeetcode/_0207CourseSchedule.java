package May2021PrepLeetcode;

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
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int src = prerequisites[i][0];
			int dst = prerequisites[i][1];
			map.get(src).add(dst);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> out = new HashSet<Integer>();
		for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 0) {
				q.offer(entry.getKey());
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int course = q.poll();

				out.add(course);
				for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
					if (entry.getValue().contains(course)) {
						entry.getValue().remove(course);
						if (entry.getValue().size() == 0) {
							q.offer(entry.getKey());
						}
					}
				}
			}
		}

		return out.size() == numCourses;
	}
}
