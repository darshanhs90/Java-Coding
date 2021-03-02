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
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			Integer src = prerequisites[i][0];// 0
			Integer dst = prerequisites[i][1];// 1
			map.get(dst).add(src);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> output = new ArrayList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 0 && !visited.contains(entry.getKey())) {
				visited.add(entry.getKey());
				q.offer(entry.getKey());
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer course = q.poll();
				output.add(course);
				for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
					if (entry.getValue().contains(course)) {
						entry.getValue().remove(course);
					}
				}
			}

			for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
				if (entry.getValue().size() == 0 && !visited.contains(entry.getKey())) {
					visited.add(entry.getKey());
					q.offer(entry.getKey());
				}
			}
		}

		if (output.size() != numCourses)
			return new int[] {};

		int[] out = new int[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[output.size() - i - 1] = output.get(i);
		}
		return out;
	}

}
