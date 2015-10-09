package leetCode;

import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/contains-duplicate/
 */

public class _217ContainsDuplicate {
		public boolean containsDuplicate(int[] nums) {
			HashMap<Integer,Integer> elementMap=new HashMap<Integer,Integer>();
			for (int i = 0; i < nums.length; i++) {
				if(elementMap.containsKey(nums[i]))
					return true;
				else
					elementMap.put(nums[i],nums[i]);
			}
			return false;
		}
}