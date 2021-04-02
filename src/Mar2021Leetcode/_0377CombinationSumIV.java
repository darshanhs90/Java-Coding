package Mar2021Leetcode;

public class _0377CombinationSumIV {

	public static void main(String[] args) {
		System.out.println(combinationSum4(new int[] { 1, 2, 3 }, 4));
		System.out.println(combinationSum4(new int[] { 9 }, 3));
	}

	static int count;

	public static int combinationSum4(int[] nums, int target) {
		count = 0;
		dfs(0, nums, target);
		return count;
	}

	public static void dfs(int sum, int[] nums, int target) {
		if (sum == target) {
			count++;
			return;
		}
		if (sum > target)
			return;

		for (int i = 0; i < nums.length; i++) {
			dfs(sum + nums[i], nums, target);
		}
	}

}
