package May2021Leetcode;

import java.util.HashMap;

public class _0621TaskScheduler2 {
// https://leetcode.com/discuss/interview-question/432086/Facebook-or-Phone-Screen-or-Task-Scheduler/394783
	public static void main(String[] args) {
		System.out.println(leastInterval(new int[] { 1, 1, 2, 1 }, 2));
	}

	public static int leastInterval(int[] tasks, int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < tasks.length; i++) {
			if (!map.containsKey(tasks[i])) {
				map.put(tasks[i], count);
				count++;
			} else {
				count = Math.max(count, map.get(tasks[i]) + n + 1);
				map.put(tasks[i], count);
				count++;
			}
		}
		return count;
	}
}
