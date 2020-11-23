package Nov2020Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0001TwoSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 3 }, 6)));

	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer val1 = map.get(nums[i]);
			Integer val2 = map.get(target - nums[i]);
			if (val1 != null && target - nums[i] == nums[i]) {
				return new int[] { val1, i };
			} else if (val2 != null) {
				return new int[] { val2, i };
			} else if (val1 == null) {
				map.put(nums[i], i);
			}
		}
		return null;
	}
}
