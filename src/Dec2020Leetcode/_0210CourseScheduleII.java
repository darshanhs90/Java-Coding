package Dec2020Leetcode;

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
		List<Integer> order = new ArrayList<Integer>();
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
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer node = q.poll();
				order.add(node);
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

		if (order.size() != numCourses)
			return new int[] {};
		else {

			int[] outputArr = new int[numCourses];
			for (int i = 0; i < outputArr.length; i++) {
				outputArr[i] = order.get(outputArr.length - i - 1);
			}
			return outputArr;
		}
	}
}
