package LeetCodePerformancePractice;

import java.util.Arrays;
import java.util.HashMap;
/*
 * Link :https://leetcode.com/problems/two-sum/
 */	
public class _001TwoSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
	}
/*	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if(j!=i && nums[i]+nums[j]==target)
				{
					return new int[]{i,j};
				}
			}
		}
		return null;
	}*/

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i)
				return (new int[]{i,map.get(target-nums[i])});
		}
		return null;
	}
}
