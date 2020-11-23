package Nov2020Leetcode;

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
		List<String> list = new ArrayList<String>();
		if (nums == null || nums.length == 0)
			return list;
		Integer leftVal = null;
		Integer rightVal = null;
		for (int i = 0; i < nums.length; i++) {
			if (leftVal == null) {
				leftVal = nums[i];
				rightVal = nums[i];
			} else if (nums[i] == rightVal + 1) {
				rightVal = nums[i];
			} else {
				if (leftVal - rightVal == 0) {
					list.add(leftVal + "");
				} else {
					list.add(leftVal + "->" + rightVal);
				}
				leftVal = nums[i];
				rightVal = nums[i];
			}
		}
		if (leftVal != null && rightVal != null) {
			if (leftVal - rightVal == 0) {
				list.add(leftVal + "");
			} else {
				list.add(leftVal + "->" + rightVal);
			}
		}
		return list;
	}
}
