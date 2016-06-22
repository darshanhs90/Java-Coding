package LeetCodePractice;

import java.util.HashSet;

public class _217ContainsDuplicate{
	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set=new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[]{1,3,4,5,2}));
	}
}

