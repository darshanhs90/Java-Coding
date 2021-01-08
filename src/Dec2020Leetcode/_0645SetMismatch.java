package Dec2020Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class _0645SetMismatch {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[] { 1, 2, 2, 4 })));
		System.out.println(Arrays.toString(findErrorNums(new int[] { 1, 1 })));
		System.out.println(Arrays.toString(findErrorNums(new int[] { 2, 2 })));
	}

	public static int[] findErrorNums(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		int dup = -1;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				dup = nums[i];
			} else {
				set.add(nums[i]);
			}
		}

		for (int i = 1; i <= nums.length; i++) {
			if (!set.contains(i))
				return new int[] { dup, i };
		}
		return new int[] {};
	}
}
