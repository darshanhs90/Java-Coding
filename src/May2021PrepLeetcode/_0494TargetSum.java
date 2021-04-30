package May2021PrepLeetcode;

public class _0494TargetSum {

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

	public static int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0)
			return 0;
		return dfs(0, 0, nums, S);
	}

	public static int dfs(int index, int currSum, int[] nums, int S) {
		if (index == nums.length) {
			if (currSum == S)
				return 1;
			return 0;
		}

		return dfs(index + 1, currSum + nums[index], nums, S) + dfs(index + 1, currSum - nums[index], nums, S);
	}

}
