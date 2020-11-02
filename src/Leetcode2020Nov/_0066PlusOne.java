package Leetcode2020Nov;

import java.util.Arrays;

public class _0066PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 0 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 9, 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9 })));
	}

	public static int[] plusOne(int[] digits) {
		boolean hasCarry = true;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + (hasCarry ? 1 : 0);
			if (sum > 9) {
				digits[i] = 10 - sum;
				hasCarry = true;
			} else {
				digits[i] = sum;
				hasCarry = false;
			}
		}
		if (hasCarry) {
			int[] newList = Arrays.copyOf(digits, digits.length + 1);
			newList[0] = 1;
			return newList;
		} else {
			return digits;
		}
	}
}
