package leetCode;

import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

public class _026RemoveDuplicatesSortedArray {
	public static int removeDuplicates(int[] nums) {
		int index=0;
		HashMap<Integer, Integer> elementMap=new HashMap<>();
		int length=nums.length;
		for (int i = 0; i < nums.length; i++) {
			int element=nums[i];
			if(elementMap.containsKey(element))
			{
				length--;
			}
			else{
				nums[index]=nums[i];
				index++;
				elementMap.put(element,1);
			}
		}
		return length;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,2}));
	}
}