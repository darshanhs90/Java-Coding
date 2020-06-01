package PracticeLeetCode;

import java.util.Arrays;
import java.util.HashMap;

//https://www.careercup.com/page?pid=microsoft-interview-questions
public class _001TwoSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] {3,2,3}, 6)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i]) && map.containsKey(target - nums[i]) && map.get(target- nums[i])!=i )
			{
				return new int[] {i, map.get(target-nums[i])};
			}
		}
		return new int[] {0,1};
	}

}
