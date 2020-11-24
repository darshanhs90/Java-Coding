package Nov2020Leetcode;

import java.util.Arrays;

public class _0287FindTheDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
		System.out.println(findDuplicate(new int[] { 1, 1 }));
		System.out.println(findDuplicate(new int[] { 1, 1, 2 }));

	}

	public static int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		int val = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (val == nums[i])
				return val;
			val = nums[i];
		}
		return 0;
	}

}
