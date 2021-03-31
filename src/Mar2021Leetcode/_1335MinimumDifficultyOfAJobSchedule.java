package Mar2021Leetcode;

public class _1335MinimumDifficultyOfAJobSchedule {
	public static void main(String[] args) {
		System.out.println(minDifficulty(new int[] { 6, 5, 4, 3, 2, 1 }, 2));
		System.out.println(minDifficulty(new int[] { 9, 9, 9 }, 3));
		System.out.println(minDifficulty(new int[] { 1, 1, 1 }, 3));
		System.out.println(minDifficulty(new int[] { 7, 1, 7, 1, 7, 1 }, 3));
		System.out.println(minDifficulty(new int[] { 11, 111, 22, 222, 33, 333, 44, 444 }, 6));
	}

	static long min;

	public static int minDifficulty(int[] jobDifficulty, int d) {
		if (jobDifficulty.length < d)
			return -1;
		min = Long.MAX_VALUE;
		dfs(0, 0, jobDifficulty, d);
		return (int) min;
	}

	public static void dfs(int index, int currSum, int[] jobDifficulty, int d) {
		if (index == jobDifficulty.length && d == 0) {
			min = Math.min(min, currSum);
			return;
		}

		if (index >= jobDifficulty.length || d < 0)
			return;
		int sum = 0;
		for (int i = index; i < jobDifficulty.length; i++) {
			sum = Math.max(jobDifficulty[i], sum);
			dfs(i + 1, currSum + sum, jobDifficulty, d - 1);
		}
	}

}
