package Nov2020_GoogPrep;

import java.util.Arrays;

public class _012PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9, 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 0 })));
	}

	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0)
			return digits;
		boolean hasCarry = true;
		for (int i = digits.length - 1; i > -1; i--) {
			int sum = digits[i] + (hasCarry == true ? 1 : 0);
			hasCarry = false;
			if (sum > 9) {
				hasCarry = true;
				sum = sum - 10;
			}

			digits[i] = sum;
		}

		if (hasCarry) {
			int[] newArr = new int[digits.length + 1];
			newArr = Arrays.copyOf(digits, digits.length + 1);
			newArr[0] = 1;
			return newArr;
		} else {
			return digits;
		}
	}
}
