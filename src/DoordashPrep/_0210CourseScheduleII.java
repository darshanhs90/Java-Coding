package DoordashPrep;

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
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			adjList.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			Integer source = prerequisites[i][0];
			Integer destination = prerequisites[i][1];
			adjList.get(source).add(destination);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		List<Integer> out = new ArrayList<Integer>();
		for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			if (entry.getValue().size() == 0) {
				q.offer(entry.getKey());
				visited.add(entry.getKey());
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer course = q.poll();
				out.add(course);
				for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
					if (entry.getValue().contains(course)) {
						entry.getValue().remove(Integer.valueOf(course));
					}

					if (entry.getValue().size() == 0 && !visited.contains(entry.getKey())) {
						q.offer(entry.getKey());
						visited.add(entry.getKey());
					}
				}
			}
		}

		if (out.size() != numCourses)
			return new int[] {};
		int[] outArr = new int[out.size()];
		for (int i = 0; i < outArr.length; i++) {
			outArr[i] = out.get(i);
		}
		return outArr;
	}

}
