package Feb2021Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int source = prerequisites[i][0];
			int destn = prerequisites[i][1];
			map.get(destn).add(source);
		}

		int[] out = new int[numCourses];
		int index = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 0) {
				q.offer(entry.getKey());
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer course = q.poll();
				out[index++] = course;
				visited.add(course);
				for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
					if (entry.getValue().contains(course)) {
						entry.getValue().remove(course);
					}
				}
			}
			for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
				if (entry.getValue().size() == 0 && !visited.contains(entry.getKey())) {
					q.offer(entry.getKey());
				}
			}
		}

		if (index != numCourses) {
			return new int[] {};
		}
		reverseArr(out);
		return out;
	}

	public static void reverseArr(int[] arr) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

}
