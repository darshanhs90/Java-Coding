package Nov2020Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0179LargestNumber {

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[] { 10, 2 }));
		System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(largestNumber(new int[] { 1 }));
		System.out.println(largestNumber(new int[] { 10 }));
		System.out.println(largestNumber(new int[] { 1, 0, 1 }));
		System.out.println(largestNumber(new int[] { 0, 0 }));

	}

	public static String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";

		String[] str = new String[nums.length];
		for (int i = 0; i < str.length; i++) {
			str[i] = String.valueOf(nums[i] + "");
		}

		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String val1 = o1 + o2;
				String val2 = o2 + o1;

				return val2.compareTo(val1);
			}
		});

		if (str[0].contentEquals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb = sb.append(str[i]);
		}
		return sb.toString();
	}
}
