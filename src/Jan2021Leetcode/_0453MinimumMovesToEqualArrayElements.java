package Jan2021Leetcode;

public class _0453MinimumMovesToEqualArrayElements {

	public static void main(String[] args) {
		System.out.println(minMoves(new int[] { 1, 2, 3 }));
	}

	public static int minMoves(int[] nums) {
		int count = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			count += nums[i] - min;
		}

		return count;
	}
}
