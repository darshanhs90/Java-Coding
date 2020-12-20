package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _036CourseScheduleII {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOrder(2, new int[][] { new int[] { 1, 0 } })));
		System.out.println(Arrays.toString(findOrder(4,
				new int[][] { new int[] { 1, 0 }, new int[] { 2, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 } })));
		System.out.println(Arrays.toString(findOrder(1, new int[][] {})));

		System.out.println(Arrays
				.toString(findOrder(3, new int[][] { new int[] { 1, 0 }, new int[] { 1, 2 }, new int[] { 0, 1 } })));

		System.out.println(Arrays.toString(findOrder(4,
				new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 1, 3 }, new int[] { 3, 0 } })));

	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			adjList.put(i, new ArrayList<Integer>());
			q.add(i);
		}

		for (int i = 0; i < prerequisites.length; i++) {
			adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);

			if (adjList.get(prerequisites[i][1]).contains(prerequisites[i][0]))
				return new int[] {};

			if (q.contains(prerequisites[i][0])) {
				q.remove(prerequisites[i][0]);
			}
		}

		if (q.size() == 0)
			return new int[] {};

		int index = 0;
		int[] output = new int[numCourses];
		while (!q.isEmpty()) {
			int qSize = q.size();

			for (int i = 0; i < qSize; i++) {
				int currVal = q.poll();
				output[index] = currVal;
				index++;
				adjList.remove(currVal);
				for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
					if (entry.getValue().contains(currVal)) {
						entry.getValue().remove(Integer.valueOf(currVal));
						if (entry.getValue().size() == 0) {
							q.offer(entry.getKey());
						}
					}
				}
			}
		}

		return index == output.length ? output : new int[] {};
	}
}
