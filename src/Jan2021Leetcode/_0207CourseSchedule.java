package Jan2021Leetcode;

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
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < numCourses; i++) {
			adjList.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int source = prerequisites[i][0];
			int destination = prerequisites[i][1];
			adjList.get(destination).add(source);
			if (adjList.get(source).contains(destination))
				return false;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			if (entry.getValue().size() == 0) {
				q.offer(entry.getKey());
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer currCourse = q.poll();
				visited.add(currCourse);
				for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
					if (!visited.contains(entry.getKey())) {

						if (entry.getValue().contains(currCourse)) {
							entry.getValue().remove(Integer.valueOf(currCourse));
							if (entry.getValue().size() == 0) {
								q.offer(entry.getKey());
							}
						}
					}
				}
			}
		}

		return visited.size() == numCourses;
	}
}
