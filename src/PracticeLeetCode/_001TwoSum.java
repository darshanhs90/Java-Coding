package PracticeLeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 * Link :https://leetcode.com/problems/two-sum/
 */	


//https://www.careercup.com/page?pid=microsoft-interview-questions
public class _001TwoSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
	}

	private static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> set=new HashMap();
		for (int i = 0; i < nums.length; i++) {
			set.put(nums[i],i);
		}
		for (int i = 0; i < nums.length; i++) {
			if(set.containsKey(target-nums[i]) && set.get(target-nums[i])!=i)
			{
				return new int[]{i,set.get(target-nums[i])};
			}
		}
		return new int[]{};
	}






}
