package Nov2020_UberPrep;

import java.util.Arrays;

public class _017TaskScheduler {

	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
	}

	public static int leastInterval(char[] tasks, int n) {
		if (n == 0 || tasks.length == 0)
			return tasks.length;
		int[] frequencies = new int[26];
		for (char c : tasks) {
			frequencies[c - 'A']++;
		}

		Arrays.sort(frequencies);
		int freqMax = frequencies[25];
		int idleTime = (freqMax - 1) * n;

		for (int i = frequencies.length - 2; i >= 0 && idleTime > 0; i--) {
			idleTime -= Math.min(freqMax - 1, frequencies[i]);
		}

		idleTime = Math.max(idleTime, 0);
		return idleTime + tasks.length;
	}

}
