package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _0210CourseScheduleII {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOrder(2, new int[][] { new int[] { 1, 0 } })));
		System.out.println(Arrays.toString(findOrder(4,
				new int[][] { new int[] { 1, 0 }, new int[] { 2, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 } })));
		System.out.println(Arrays.toString(findOrder(1, new int[][] {})));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		HashMap<Integer, HashSet<Integer>> adjList = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			adjList.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int src = prerequisites[i][0];
			int dst = prerequisites[i][1];
			adjList.get(dst).add(src);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, HashSet<Integer>> entry : adjList.entrySet()) {
			if (entry.getValue().size() == 0) {
				q.offer(entry.getKey());
				visited.add(entry.getKey());
			}
		}
		List<Integer> output = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int course = q.poll();
				output.add(course);
				for (Map.Entry<Integer, HashSet<Integer>> entry : adjList.entrySet()) {
					if (entry.getValue().contains(course)) {
						entry.getValue().remove(Integer.valueOf(course));
					}
				}
			}

			for (Map.Entry<Integer, HashSet<Integer>> entry : adjList.entrySet()) {
				if (entry.getValue().size() == 0 && !visited.contains(entry.getKey())) {
					q.offer(entry.getKey());
					visited.add(entry.getKey());
				}
			}

		}

		if (visited.size() != numCourses)
			return new int[] {};
		int[] out = new int[numCourses];
		for (int i = 0; i < out.length; i++) {
			out[out.length - i - 1] = output.get(i);
		}

		return out;
	}
}
