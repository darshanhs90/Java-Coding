package June2021GoogLeetcode;

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

		for (int[] prereqs : prerequisites) {
			int src = prereqs[0];
			int dst = prereqs[1];
			map.get(src).add(dst);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> out = new ArrayList<Integer>();
		for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 0) {
				q.offer(entry.getKey());
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer currCourse = q.poll();
				out.add(currCourse);
				for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
					if (entry.getValue().contains(currCourse)) {
						entry.getValue().remove(currCourse);
						if (entry.getValue().size() == 0)
							q.offer(entry.getKey());
					}
				}
			}

		}

		if (out.size() != numCourses)
			return new int[] {};
		int[] output = new int[out.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = out.get(i);
		}
		return output;
	}
}
