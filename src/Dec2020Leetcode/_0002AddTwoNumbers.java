package Dec2020Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0002AddTwoNumbers {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 3 }, 6)));
	}

	public static int[] twoSum(int[] nums, int target) {
		if (nums.length <= 1)
			return new int[] { -1, -1 };
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				return new int[] { map.get(diff), i };
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[] { -1, -1 };
	}
}
