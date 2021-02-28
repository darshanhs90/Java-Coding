package FacebookPrep;

import java.util.Arrays;

public class _0621TaskScheduler {

	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
	}

	public static int leastInterval(char[] tasks, int n) {
		if (tasks == null || tasks.length == 0)
			return 0;
		else if (n == 0)
			return tasks.length;
		int[] arr = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			char c = tasks[i];
			arr[c - 'A']++;
		}
		Arrays.sort(arr);
		int maxFreq = arr[arr.length - 1];
		int idleTime = (maxFreq - 1) * n;

		for (int i = arr.length - 2; i >= 0 && idleTime > 0; i--) {
			idleTime -= Math.min(maxFreq - 1, arr[i]);
		}
		idleTime = Math.max(0, idleTime);
		return idleTime + tasks.length;
	}
}
