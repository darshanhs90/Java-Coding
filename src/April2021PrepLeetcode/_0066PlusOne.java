package April2021PrepLeetcode;

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
		int[] output = new int[digits.length + 1];
		boolean hasCarry = true;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = hasCarry ? 1 : 0;
			sum += digits[i];
			hasCarry = false;
			if (sum > 9) {
				sum = sum - 10;
				hasCarry = true;
			}
			output[i+1] = sum;
		}
		if (hasCarry) {
			output[0] = 1;
			return output;
		}

		return Arrays.copyOfRange(output, 1, output.length);
	}
}
