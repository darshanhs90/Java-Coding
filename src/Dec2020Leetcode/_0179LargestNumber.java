package Dec2020Leetcode;

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
		String[] str = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			str[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				// TODO Auto-generated method stub
				String str1 = a + b;
				String str2 = b + a;
				return str2.compareTo(str1);
			}
		});
		if (str[0].equals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}

		return sb.toString();
	}
}
