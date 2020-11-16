package Leetcode2020Nov;

public class _0004MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays(new int[] { 0, 0 }, new int[] { 0, 0 }));
		System.out.println(findMedianSortedArrays(new int[] {}, new int[] { 1 }));
		System.out.println(findMedianSortedArrays(new int[] { 2 }, new int[] {}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int lengthSum = nums1.length + nums2.length;
		int leftIndex = 0, rightIndex = 0;
		boolean includeTwoElements = false;
		if ((lengthSum) % 2 == 0) {
			leftIndex = lengthSum / 2 - 1;
			rightIndex = lengthSum / 2;
			includeTwoElements = true;
		} else {
			rightIndex = lengthSum / 2;
			leftIndex = rightIndex;
		}
		int index = 0;
		int leftVal = 0;
		int rightVal = 0;
		int leftArrayIndex = 0, rightArrayIndex = 0;

		while (index <= rightIndex) {
			int val = 0;
			if (leftArrayIndex < nums1.length && rightArrayIndex < nums2.length) {
				if (nums1[leftArrayIndex] < nums2[rightArrayIndex]) {
					val = nums1[leftArrayIndex];
					leftArrayIndex++;
				} else {
					val = nums2[rightArrayIndex];
					rightArrayIndex++;
				}
			} else if (leftArrayIndex < nums1.length) {
				val = nums1[leftArrayIndex];
				leftArrayIndex++;
			} else {
				val = nums2[rightArrayIndex];
				rightArrayIndex++;
			}

			if (index == leftIndex) {
				leftVal = val;
			} else if (index == rightIndex) {
				rightVal = val;
				break;
			}
			index++;
		}
		return includeTwoElements ? (double) (leftVal + rightVal) / 2 : (double) leftVal;
	}
}
