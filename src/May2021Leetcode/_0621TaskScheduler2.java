package May2021Leetcode;

import java.util.HashMap;

public class _0621TaskScheduler2 {
// https://leetcode.com/discuss/interview-question/432086/Facebook-or-Phone-Screen-or-Task-Scheduler/394783
	public static void main(String[] args) {
		System.out.println(leastInterval(new int[] { 1, 1, 2, 1 }, 2));
	}

	public static int leastInterval(int[] tasks, int n) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < tasks.length; i++) {
			int task = tasks[i];
			if (!map.containsKey(task)) {
				map.put(task, count + 1);
			} else {
				map.put(task, Math.max(count, map.get(task) + n + 1));
			}
			count = map.get(task);
		}
		return count;
	}
}
