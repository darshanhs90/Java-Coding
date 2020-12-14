package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.List;

public class _016MissingRanges {

	public static void main(String[] args) {
		System.out.println(findMissingRanges(new int[] { 0, 1, 3, 50, 75, 99 }, 0, 99));
		System.out.println(findMissingRanges(new int[] {}, 1, 1));
		System.out.println(findMissingRanges(new int[] {}, -3, -1));
		System.out.println(findMissingRanges(new int[] { -1 }, -1, -1));
		System.out.println(findMissingRanges(new int[] { -1 }, -2, -1));
		System.out.println(findMissingRanges(new int[] { -1 }, -1, 0));
	}

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> output = new ArrayList<String>();
		if (nums.length == 0) {
			if (lower == upper)
				output.add(lower + "");
			else {
				output.add(lower + "->" + upper);
			}
			return output;
		}
		if (nums[0] < lower) {
			output.add(lower + "->" + (nums[0] - 1));
		} else if (nums[0] > lower) {
			if (lower == nums[0] - 1) {
				output.add(lower + "");
			} else {
				output.add(lower + "->" + (nums[0] - 1));
			}
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1] + 1) {
				if ((nums[i - 1] + 1) == (nums[i] - 1)) {
					output.add(nums[i - 1] + 1 + "");
				} else {
					output.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
				}
			}
		}
		if (nums[nums.length - 1] < upper) {
			if (nums[nums.length - 1] + 1 == upper) {
				output.add(nums[nums.length - 1] + 1 + "");
			} else {
				output.add((nums[nums.length - 1] + 1) + "->" + upper);
			}
		}
		return output;
	}
}
