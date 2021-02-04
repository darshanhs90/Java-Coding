package Jan2021Leetcode;

public class _1335MinimumDifficultyOfAJobSchedule {
	public static void main(String[] args) {
		System.out.println(minDifficulty(new int[] { 6, 5, 4, 3, 2, 1 }, 2));
		System.out.println(minDifficulty(new int[] { 9, 9, 9 }, 3));
		System.out.println(minDifficulty(new int[] { 1, 1, 1 }, 3));
		System.out.println(minDifficulty(new int[] { 7, 1, 7, 1, 7, 1 }, 3));
		System.out.println(minDifficulty(new int[] { 11, 111, 22, 222, 33, 333, 44, 444 }, 6));
	}

	static int minSum;

	public static int minDifficulty(int[] jobDifficulty, int d) {
		if (d > jobDifficulty.length)
			return -1;
		minSum = Integer.MAX_VALUE;
		dfs(0, jobDifficulty, d, 0);
		return minSum;
	}

	public static void dfs(int index, int[] jobDifficulty, int d, int currSum) {
		if (index == jobDifficulty.length && d == 0) {
			minSum = Math.min(minSum, currSum);
			return;
		}

		if (index >= jobDifficulty.length || d < 0)
			return;

		Integer prevVal = null;
		for (int i = index; i < jobDifficulty.length; i++) {
			if (prevVal == null) {
				prevVal = jobDifficulty[i];
			} else {
				prevVal = Math.max(prevVal, jobDifficulty[i]);
			}
			dfs(i + 1, jobDifficulty, d - 1, currSum + prevVal);
		}
	}

}
