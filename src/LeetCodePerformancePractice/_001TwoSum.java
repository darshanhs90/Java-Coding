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

	private static int[] twoSum(int[] inputArray, int target) {
		HashMap<Integer, Integer> map=new HashMap<>();
		for (int i = 0; i < inputArray.length; i++) {
			map.put(inputArray[i], i);
		}
		for (int i = 0; i < inputArray.length; i++) {
			if(map.containsKey(target-inputArray[i]) && map.get(target-inputArray[i])!=i)
			{
				return new int[]{i,map.get(target-inputArray[i])};
			}
		}
		return null;
	}




}
