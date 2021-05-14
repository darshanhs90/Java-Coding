package May2021Leetcode;

public class _0004MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays(new int[] { 0, 0 }, new int[] { 0, 0 }));
		System.out.println(findMedianSortedArrays(new int[] {}, new int[] { 1 }));
		System.out.println(findMedianSortedArrays(new int[] { 2 }, new int[] {}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int sumLength = nums1.length + nums2.length;
		boolean hasDoubleMedian = false;
		int index1Limit = 0, index2Limit = 0;
		if (sumLength % 2 == 0) {
			hasDoubleMedian = true;
			index1Limit = sumLength / 2 - 1;
			index2Limit = sumLength / 2;
		} else {
			index1Limit = sumLength / 2;
			index2Limit = index1Limit;
		}

		int index = 0;
		int leftVal = 0, rightVal = 0;
		int index1 = 0, index2 = 0;
		while (index <= index2Limit) {
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

			if (index == index1Limit) {
				leftVal = val;
			} else if (index == index2Limit) {
				rightVal = val;
				break;
			}
			index++;
		}
		return hasDoubleMedian ? (leftVal + rightVal) / (double) 2 : leftVal;
	}

}
