package Dec2020Leetcode;

import java.util.Arrays;

public class _0621TaskScheduler {

	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
	}

	public static int leastInterval(char[] tasks, int n) {
		int[] frequencies = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			frequencies[tasks[i] - 'A']++;
		}

		Arrays.sort(frequencies);

		int fMax = frequencies[25];
		int idleTime = (fMax - 1) * n;

		for (int i = frequencies.length - 2; i >= 0 && idleTime > 0; i--) {
			idleTime -= Math.min(fMax - 1, frequencies[i]);
		}
		idleTime = Math.max(0, idleTime);
		return idleTime + tasks.length;
	}
}
