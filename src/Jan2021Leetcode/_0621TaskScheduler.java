package Jan2021Leetcode;

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
		int freqMax = frequencies[25];
		int idletime = (freqMax - 1) * n;

		for (int i = frequencies.length - 2; i >= 0 && idletime > 0; i--) {
			idletime -= Math.min(freqMax - 1, frequencies[i]);
		}
		idletime = Math.max(0, idletime);
		return idletime + tasks.length;
	}
}
