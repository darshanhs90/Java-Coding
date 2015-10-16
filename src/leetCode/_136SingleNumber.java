package leetCode;

import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/pascals-triangle-ii/
 */

public class _136SingleNumber {
	public static int singleNumberExtraMemory(int[] nums) {
		HashMap<Integer,Integer> elementMap=new HashMap<>();
		int sum=0;
		for (int i = 0; i < nums.length; i++) {
			if(!elementMap.containsKey(nums[i]))
			{
				sum+=nums[i];
				elementMap.put(nums[i],1);
			}
			else
			{
				sum-=nums[i];
			}
		}

		return sum;
	}
	public static int singleNumber(int[] nums) {
		
		int sum=0;
		for (int i = 0; i < nums.length; i++) {
			sum=sum^nums[i];
		}

		return sum;
	}
		
	public static void main(String[] args) {
		System.out.println(singleNumberExtraMemory(new int[]{1,3,5,9,11,9,11,3,1}));
		System.out.println(singleNumber(new int[]{1,3,5,9,11,9,11,3,1}));
		
	}
}