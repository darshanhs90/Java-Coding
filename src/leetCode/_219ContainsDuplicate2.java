package leetCode;

import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/contains-duplicate-ii/
 */

public class _219ContainsDuplicate2 {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> elementMap=new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(elementMap.containsKey(nums[i]))
			{
				if((-elementMap.get(nums[i])+i)<=k)
				{
					return true;
				}
			}
			elementMap.put(nums[i],i);
		}
		return false;
	}
	public static boolean containsNearbyDuplicateLong(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(i!=j && nums[i]==nums[j] && Math.abs(i-j)<=k)
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {

	}
}