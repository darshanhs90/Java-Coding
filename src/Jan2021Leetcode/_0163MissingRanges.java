package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0163MissingRanges {

	public static void main(String[] args) {
		System.out.println(findMissingRanges(new int[] { 0, 1, 3, 50, 75 }, 0, 99));
		System.out.println(findMissingRanges(new int[] {}, 1, 1));
		System.out.println(findMissingRanges(new int[] {}, -3, -1));
		System.out.println(findMissingRanges(new int[] { -1 }, -1, -1));
		System.out.println(findMissingRanges(new int[] { -1 }, -2, -1));
		
	}

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> list = new ArrayList<String>();
		if (nums.length == 0) {
			if (lower == upper) {
				list.add(lower + "");
			} else {

				list.add(lower + "->" + upper);
			}
			return list;
		} else {
			if (lower != nums[0]) {
				if (lower + 1 == nums[0]) {
					list.add(lower + "");
				} else {
					list.add(lower + "->" + (nums[0] - 1));
				}
			}

			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i + 1] == nums[i] + 1) {
					continue;
				} else {
					if (nums[i] + 1 != nums[i + 1] - 1) {
						list.add(nums[i] + 1 + "->" + (nums[i + 1] - 1));
					} else {
						list.add(nums[i] + 1 + "");
					}
				}
			}

			if (upper != nums[nums.length - 1]) {
				if (upper == nums[nums.length - 1] + 1) {
					list.add(upper + "");
				} else {
					list.add((nums[nums.length - 1] + 1) + "->" + upper);
				}
			}
			return list;
		}
	}

}
