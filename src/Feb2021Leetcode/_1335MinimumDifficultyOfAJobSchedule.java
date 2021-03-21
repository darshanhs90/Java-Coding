package Feb2021Leetcode;

public class _1335MinimumDifficultyOfAJobSchedule {
	public static void main(String[] args) {
		System.out.println(minDifficulty(new int[] { 6, 5, 4, 3, 2, 1 }, 2));
		System.out.println(minDifficulty(new int[] { 9, 9, 9 }, 4));
		System.out.println(minDifficulty(new int[] { 1, 1, 1 }, 3));
		System.out.println(minDifficulty(new int[] { 7, 1, 7, 1, 7, 1 }, 3));
		System.out.println(minDifficulty(new int[] { 11, 111, 22, 222, 33, 333, 44, 444 }, 6));
	}

	static long minDifficultyVal;

	public static int minDifficulty(int[] jobDifficulty, int d) {
		minDifficultyVal = Long.MAX_VALUE;
		if (jobDifficulty.length < d)
			return -1;
		dfs(0, jobDifficulty, d, 0);
		return (int) minDifficultyVal;
	}

	public static void dfs(int index, int[] jobDifficulty, int d, int currVal) {
		if (d == 0 && index == jobDifficulty.length) {
			minDifficultyVal = Math.min(minDifficultyVal, currVal);
		}

		if (d < 0 || index >= jobDifficulty.length)
			return;
		int minVal = Integer.MIN_VALUE;
		for (int i = index; i < jobDifficulty.length; i++) {
			minVal = Math.max(minVal, jobDifficulty[i]);
			dfs(i + 1, jobDifficulty, d - 1, currVal + minVal);
		}
	}

}
