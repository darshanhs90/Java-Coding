package April2021Leetcode;

public class _0494TargetSum {

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

	static int count;

	public static int findTargetSumWays(int[] nums, int S) {
		count = 0;
		numOfWays(0, 0, nums, S);
		return count;
	}

	public static void numOfWays(int index, int currSum, int[] nums, int S) {
		if (index == nums.length && currSum == S) {
			count++;
			return;
		}
		if (index >= nums.length)
			return;

		numOfWays(index + 1, currSum + nums[index], nums, S);
		numOfWays(index + 1, currSum - nums[index], nums, S);
	}

}
