package Dec2020Leetcode;

import java.util.Arrays;

public class _1317ConvertIntegerToTheSumOfTwoNoZeroIntegers {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getNoZeroIntegers(2)));
		System.out.println(Arrays.toString(getNoZeroIntegers(11)));
		System.out.println(Arrays.toString(getNoZeroIntegers(10000)));
		System.out.println(Arrays.toString(getNoZeroIntegers(1010)));
	}

	public static int[] getNoZeroIntegers(int n) {
		int left = 1;
		int right = n - 1;
		while (left <= right) {
			String str1 = String.valueOf(left);
			String str2 = String.valueOf(right);
			if (str1.indexOf("0") == -1 && str2.indexOf("0") == -1)
				break;
			else {
				left++;
				right--;
			}
		}
		return new int[] { left, right };
	}

}
