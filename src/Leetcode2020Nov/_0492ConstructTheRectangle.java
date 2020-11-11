package Leetcode2020Nov;

import java.util.Arrays;

public class _0492ConstructTheRectangle {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(constructRectangle(4)));
		System.out.println(Arrays.toString(constructRectangle(37)));
		System.out.println(Arrays.toString(constructRectangle(122122)));
	}

	public static int[] constructRectangle(int area) {
		int diff = area;
		int left = 1, right = 1;
		for (int i = area; i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (i * j > area)
					break;
				if (i * j == area && i - j < diff) {
					left = i;
					right = j;
					diff = i - j;
				}
			}
		}
		return new int[] { left, right };
	}
}
