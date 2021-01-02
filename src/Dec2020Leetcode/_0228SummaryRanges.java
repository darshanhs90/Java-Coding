package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0228SummaryRanges {

	public static void main(String[] args) {
		System.out.println(summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
		System.out.println(summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
		System.out.println(summaryRanges(new int[] {}));
		System.out.println(summaryRanges(new int[] { -2147483648, -2147483647, 2147483647 }));
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> output = new ArrayList<String>();
		if (nums == null || nums.length == 0)
			return output;
		int prev = nums[0];
		int curr = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == curr + 1) {
				curr = nums[i];
			} else {
				if (prev == curr) {
					output.add(prev + "");
				} else {
					output.add(prev + "->" + curr);
				}
				prev = nums[i];
				curr = nums[i];
			}
		}

		if (prev == curr) {
			output.add(prev + "");
		} else {
			output.add(prev + "->" + curr);
		}
		return output;
	}
}
