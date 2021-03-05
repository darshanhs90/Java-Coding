package FacebookPrep;

public class _0494TargetSum {

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

	static int count;

	public static int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0)
			return 0;
		count = 0;
		dfs(nums[0], 1, nums, S);
		dfs(-nums[0], 1, nums, S);
		return count;
	}

	public static void dfs(int currVal, int index, int[] nums, int S) {
		if (index == nums.length) {
			if (currVal == S)
				count++;
			return;
		}

		dfs(currVal + nums[index], index + 1, nums, S);
		dfs(currVal - nums[index], index + 1, nums, S);
	}

}
