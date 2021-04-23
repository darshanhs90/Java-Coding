package April2021PrepLeetcode;

public class _0494TargetSum {

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

	public static int findTargetSumWays(int[] nums, int S) {
		return dfs(0, nums, 0, S);
	}

	public static int dfs(int index, int[] nums, int currSum, int S) {
		if (index == nums.length) {
			if (currSum == S) {
				return 1;
			}
			return 0;
		}

		int count = 0;
		count += dfs(index + 1, nums, currSum + nums[index], S);
		count += dfs(index + 1, nums, currSum - nums[index], S);
		return count;
	}

}
