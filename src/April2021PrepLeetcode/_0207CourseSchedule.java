package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _0207CourseSchedule {
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] { new int[] { 1, 0 } }));
		System.out.println(canFinish(2, new int[][] { new int[] { 1, 0 }, new int[] { 0, 1 } }));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int src = prerequisites[i][0];
			int dst = prerequisites[i][1];
			map.get(src).add(dst);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		int[] out = new int[numCourses];
		int index = 0;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 0) {
				q.offer(entry.getKey());
				visited.add(entry.getKey());
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int course = q.poll();
				out[index++] = course;
				for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
					if (entry.getValue().contains(course)) {
						entry.getValue().remove(Integer.valueOf(course));

						if (entry.getValue().size() == 0 && !visited.contains(entry.getKey())) {
							q.offer(entry.getKey());
							visited.add(entry.getKey());
						}
					}

				}
			}
		}
		return index == out.length;
	}
}
