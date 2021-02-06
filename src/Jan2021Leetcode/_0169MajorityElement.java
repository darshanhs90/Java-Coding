package Jan2021Leetcode;

import java.util.HashMap;

public class _0169MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
			if (map.get(nums[i]) > nums.length / 2)
				return nums[i];
		}
		return 0;
	}

}
