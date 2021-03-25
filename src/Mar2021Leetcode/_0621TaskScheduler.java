package Mar2021Leetcode;

import java.util.Arrays;

public class _0621TaskScheduler {

	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
	}

	public static int leastInterval(char[] tasks, int n) {
		int[] arr = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			arr[tasks[i] - 'A']++;
		}

		Arrays.sort(arr);
		int freqMax = arr[arr.length - 1];
		int idleTime = (freqMax - 1) * n;
		for (int i = arr.length - 2; i >= 0 && idleTime > 0; i--) {
			idleTime -= Math.min(freqMax-1, arr[i]);
		}
		idleTime = Math.max(idleTime, 0);
		return idleTime + tasks.length;
	}
}
