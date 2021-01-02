package Dec2020Leetcode;

import java.util.HashSet;

public class _0287FindTheDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
		System.out.println(findDuplicate(new int[] { 1, 1 }));
		System.out.println(findDuplicate(new int[] { 1, 1, 2 }));
	}

	public static int findDuplicate(int[] nums) {

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return nums[i];
			set.add(nums[i]);
		}
		return -1;
	}
}
