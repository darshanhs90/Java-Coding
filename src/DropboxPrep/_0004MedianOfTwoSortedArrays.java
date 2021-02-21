package DropboxPrep;

public class _0004MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays(new int[] { 0, 0 }, new int[] { 0, 0 }));
		System.out.println(findMedianSortedArrays(new int[] {}, new int[] { 1 }));
		System.out.println(findMedianSortedArrays(new int[] { 2 }, new int[] {}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;

		int sumLength = len1 + len2;
		boolean hasDoubleMedian = false;
		int leftIndex = 0, rightIndex = 0;
		if (sumLength % 2 == 0) {
			leftIndex = sumLength / 2 - 1;
			rightIndex = sumLength / 2;
			hasDoubleMedian = true;
		} else {
			leftIndex = sumLength / 2;
			rightIndex = sumLength / 2;
		}

		int index1 = 0, index2 = 0, index = 0;
		int leftVal = 0, rightVal = 0;
		while (index < sumLength) {
			int val = 0;
			if (index1 < nums1.length && index2 < nums2.length) {
				if (nums1[index1] < nums2[index2]) {
					val = nums1[index1];
					index1++;
				} else {
					val = nums2[index2];
					index2++;
				}
			} else if (index1 < nums1.length) {
				val = nums1[index1];
				index1++;
			} else {
				val = nums2[index2];
				index2++;
			}

			if (index == leftIndex) {
				leftVal = val;
			}
			else if (index == rightIndex) {
				rightVal = val;
				break;
			}
			index++;
		}
		return hasDoubleMedian ? (leftVal + rightVal) / (double) 2 : leftVal;
	}

}
