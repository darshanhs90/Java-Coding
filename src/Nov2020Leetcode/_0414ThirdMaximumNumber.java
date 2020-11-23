package Nov2020Leetcode;

import java.util.Arrays;

public class _0414ThirdMaximumNumber {

	public static void main(String[] args) {
		System.out.println(thirdMax(new int[] { 3, 2, 1 }));
		System.out.println(thirdMax(new int[] { 1, 2 }));
		System.out.println(thirdMax(new int[] { 2, 2, 3, 1 }));
		System.out.println(thirdMax(new int[] { 1, 2, 2, 5, 3, 5 }));
	}

	public static int thirdMax(int[] nums) {
		Integer firstMaxElement = null, secondMaxElement = null, thirdMaxElement = null;
		for (int i = 0; i < nums.length; i++) {
			if (firstMaxElement == null) {
				firstMaxElement = nums[i];
			} else if (secondMaxElement == null) {
				if (firstMaxElement > nums[i]) {
					secondMaxElement = nums[i];
				} else if (firstMaxElement < nums[i]) { // swap
					secondMaxElement = firstMaxElement;
					firstMaxElement = nums[i];
				}
			} else if (thirdMaxElement == null) {
				if (firstMaxElement > nums[i]) {
					if (secondMaxElement > nums[i]) {
						thirdMaxElement = nums[i];
					} else if (secondMaxElement < nums[i]) {
						thirdMaxElement = secondMaxElement;
						secondMaxElement = nums[i];
					}
				} else if (firstMaxElement < nums[i]) { // first element less than nums[i]
					thirdMaxElement = secondMaxElement;
					secondMaxElement = firstMaxElement;
					firstMaxElement = nums[i];
				}
			} else {
				if (firstMaxElement != nums[i] && secondMaxElement != nums[i] && thirdMaxElement != nums[i]) {
					int[] out = new int[] { firstMaxElement, secondMaxElement, thirdMaxElement, nums[i] };
					Arrays.sort(out);
					firstMaxElement = out[3];
					secondMaxElement = out[2];
					thirdMaxElement = out[1];
				}
			}
		}

		return thirdMaxElement != null ? thirdMaxElement : firstMaxElement;
	}
}
