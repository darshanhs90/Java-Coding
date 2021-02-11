package Jan2021Leetcode;

public class _0136SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 2, 1 }));
		System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));
		System.out.println(singleNumber(new int[] { 1 }));
	}

	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int val = nums[0];
		for (int i = 1; i < nums.length; i++) {
			val = val ^ nums[i];
		}
		return val;
	}
}
