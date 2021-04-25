package April2021PrepLeetcode;

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
		int limit1 = 0, limit2 = 0;
		if (sumLength % 2 != 0) {
			limit1 = sumLength / 2;
			limit2 = sumLength / 2;
		} else {
			hasDoubleMedian = true;
			limit1 = sumLength / 2 - 1;
			limit2 = sumLength / 2;
		}

		int index = 0, index1 = 0, index2 = 0;
		int val1 = 0, val2 = 0;
		while (index <= limit2) {
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

			if (index == limit1) {
				val1 = val;
			} else if (index == limit2) {
				val2 = val;
				break;
			}
			index++;
		}
		return hasDoubleMedian ? (val1 + val2) / (double) 2 : val1;
	}

}
