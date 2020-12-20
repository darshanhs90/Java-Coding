package Nov2020_UberPrep;

import java.util.Arrays;
import java.util.HashMap;

public class _001TwoSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 3 }, 6)));
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int newNum = target - num;
			if (map.containsKey(newNum)) {
				return new int[] { map.get(newNum), i };
			}
			map.put(num, i);
		}
		return new int[] { -1, -1 };
	}
}
