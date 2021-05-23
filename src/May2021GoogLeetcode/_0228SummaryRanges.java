package May2021GoogLeetcode;

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
		int start = nums[0];
		int end = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == end + 1) {
				end = nums[i];
			} else {
				if (start == end) {
					output.add(start + "");
				} else {
					output.add(start + "->" + end);
				}

				start = nums[i];
				end = nums[i];
			}
		}
		if (start == end) {
			output.add(start + "");
		} else {
			output.add(start + "->" + end);
		}
		return output;
	}
}
