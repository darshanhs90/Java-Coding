package Leetcode2020Nov;

import java.util.HashMap;

public class _0169MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.computeIfPresent(nums[i], (key, val) -> val + 1);
				if (map.get(nums[i]) > nums.length / 2)
					return nums[i];
			} else {
				map.put(nums[i], 1);
			}
		}
		return nums[0];
	}
}
