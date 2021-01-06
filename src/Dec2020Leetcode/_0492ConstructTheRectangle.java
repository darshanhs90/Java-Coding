package Dec2020Leetcode;

import java.util.Arrays;

public class _0492ConstructTheRectangle {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(constructRectangle(4)));
		System.out.println(Arrays.toString(constructRectangle(37)));
		System.out.println(Arrays.toString(constructRectangle(122122)));
	}

	public static int[] constructRectangle(int area) {

		int left = 1, right = area;
		int diff = Math.abs(left - right);
		int outleft = 1, outright = right;
		while (left <= right) {
			int out = left * right;
			if (out == area) {

				int currDiff = Math.abs(left - right);
				if (currDiff < diff) {
					diff = currDiff;
					outleft = left;
					outright = right;
				}
				left++;
				right--;
			} else if (out > area) {
				right--;
			} else {
				left++;
			}
		}
		return new int[] { outright, outleft };
	}

}
