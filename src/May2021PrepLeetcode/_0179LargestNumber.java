package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i] + "");
		}

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String str1 = o1 + o2;
				String str2 = o2 + o1;
				return str2.compareTo(str1);
			}
		});

		String strOut = String.join("", list);
		if (strOut.charAt(0) == '0')
			return "0";
		return strOut;
	}
}
