package Oct2023Leetcode;

import java.util.HashSet;

public class _0217ContainsDuplicate {

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
		System.out.println(containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
	}

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
