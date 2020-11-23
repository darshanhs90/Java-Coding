package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0207CourseSchedule {
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] { new int[] { 1, 0 } }));
		System.out.println(canFinish(2, new int[][] { new int[] { 1, 0 }, new int[] { 0, 1 } }));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] list = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			list[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		boolean visited[] = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, list, visited))
				return false;
		}
		return true;
	}

	public static boolean dfs(int index, ArrayList<Integer>[] list, boolean visited[]) {
		if (index > list.length || visited[index] == true)
			return false;

		visited[index] = true;
		List<Integer> children = list[index];
		for (int i = 0; i < children.size(); i++) {
			if (!dfs(children.get(i), list, visited))
				return false;
		}
		visited[index] = false;
		return true;
	}
}
