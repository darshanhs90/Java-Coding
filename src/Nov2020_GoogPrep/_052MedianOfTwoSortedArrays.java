package Nov2020_GoogPrep;

public class _052MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays(new int[] { 0, 0 }, new int[] { 0, 0 }));
		System.out.println(findMedianSortedArrays(new int[] {}, new int[] { 1 }));
		System.out.println(findMedianSortedArrays(new int[] { 2 }, new int[] {}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int sumLength = nums1.length + nums2.length;
		int num1Limit = 0, num2Limit = 0;
		boolean hasTwoElements = false;
		if (sumLength % 2 == 0) {
			num1Limit = sumLength / 2 - 1;
			num2Limit = sumLength / 2;
			hasTwoElements = true;
		} else {
			num1Limit = sumLength / 2;
			num2Limit = sumLength / 2;
		}

		int left = 0, right = 0;
		int index = 0;
		int indexLeft = 0, indexRight = 0;
		while (index <= num2Limit) {
			int val = 0;

			if (indexLeft < nums1.length && indexRight < nums2.length) {
				if (nums1[indexLeft] < nums2[indexRight]) {
					val = nums1[indexLeft];
					indexLeft++;
				} else {
					val = nums2[indexRight];
					indexRight++;
				}
			} else if (indexLeft < nums1.length) {
				val = nums1[indexLeft];
				indexLeft++;
			} else {
				val = nums2[indexRight];
				indexRight++;
			}

			if (index == num1Limit) {
				left = val;
			} else if (index == num2Limit) {
				right = val;
				break;
			}
			index++;
		}

		if (hasTwoElements) {
			return (left + right) / (double) 2;
		} else {
			return left;
		}
	}
}
