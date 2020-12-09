package Dec2020_HackerRankPrepKit;

import java.util.Arrays;

public class _006LeftRotation {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(rotLeft(new int[] { 1, 2, 3, 4, 5 }, 0)));
		System.out.println(Arrays.toString(rotLeft(new int[] { 1, 2, 3, 4, 5 }, 1)));
		System.out.println(Arrays.toString(rotLeft(new int[] { 1, 2, 3, 4, 5 }, 2)));
		System.out.println(Arrays.toString(rotLeft(new int[] { 1, 2, 3, 4, 5 }, 3)));
		System.out.println(Arrays.toString(rotLeft(new int[] { 1, 2, 3, 4, 5 }, 4)));
		System.out.println(Arrays.toString(rotLeft(new int[] { 1, 2, 3, 4, 5 }, 5)));
		System.out.println(Arrays.toString(rotLeft(new int[] { 1, 2, 3, 4, 5 }, 6)));
	}

	static int[] rotLeft(int[] a, int d) {
		if (d > a.length)
			d = d % a.length;
		if (d == 0)
			return a;

		reverse(a, 0, d - 1);
		reverse(a, d, a.length - 1);
		reverse(a, 0, a.length - 1);
		return a;
	}

	static void reverse(int[] a, int left, int right) {
		while (left < right) {
			int temp = a[left];
			a[left] = a[right];
			a[right] = temp;
			left++;
			right--;
		}
	}
}
