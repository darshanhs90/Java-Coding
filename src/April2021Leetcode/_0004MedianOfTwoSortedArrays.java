package April2021Leetcode;

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
		int nums1Limit = 0, nums2Limit = 0;
		int nums1Index = 0, nums2Index = 0;
		int leftVal = 0, rightVal = 0;
		int index = 0;

		boolean hasDoubleMedian = false;
		if (sumLength % 2 == 0) {
			hasDoubleMedian = true;
			nums1Limit = sumLength / 2 - 1;
			nums2Limit = sumLength / 2;
		} else {
			nums1Limit = sumLength / 2;
			nums2Limit = sumLength / 2;
		}

		while (index <= nums2Limit) {
			int val = 0;

			if (nums1Index < nums1.length && nums2Index < nums2.length) {
				if (nums1[nums1Index] < nums2[nums2Index]) {
					val = nums1[nums1Index];
					nums1Index++;
				} else {
					val = nums2[nums2Index];
					nums2Index++;
				}
			} else if (nums1Index < nums1.length) {
				val = nums1[nums1Index];
				nums1Index++;
			} else {
				val = nums2[nums2Index];
				nums2Index++;
			}

			if (index == nums1Limit) {
				leftVal = val;
			} else if (index == nums2Limit) {
				rightVal = val;
				break;
			}

			index++;
		}
		return hasDoubleMedian ? (leftVal + rightVal) / (double) 2 : leftVal;
	}

}
