package leetCode;

import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/single-number-ii/
 */

public class _137SingleNumber2 {
	public static int singleNumber(int[] nums) {
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
				if(elementMap.get(nums[i])==2)
					sum-=nums[i];
				else
					elementMap.put(nums[i],2);
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,3,5,9,11,9,11,3,1}));
	}
}