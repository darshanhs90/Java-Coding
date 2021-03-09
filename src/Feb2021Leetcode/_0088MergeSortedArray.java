package Feb2021Leetcode;

public class _0088MergeSortedArray {
	public static void main(String[] args) {
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		merge(new int[] { 4, 5, 6, 0, 0, 0 }, 3, new int[] { 1, 2, 3 }, 3);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int outIndex = nums1.length - 1;

		int leftIndex = m - 1, rightIndex = nums2.length - 1;
		while (outIndex >= 0) {
			if (leftIndex >= 0 && rightIndex >= 0) {
				if (nums1[leftIndex] > nums2[rightIndex]) {
					nums1[outIndex] = nums1[leftIndex];
					leftIndex--;
				} else {
					nums1[outIndex] = nums2[rightIndex];
					rightIndex--;
				}
			} else if (leftIndex >= 0) {
				nums1[outIndex] = nums1[leftIndex];
				leftIndex--;
			} else {
				nums1[outIndex] = nums2[rightIndex];
				rightIndex--;
			}
			outIndex--;
		}
	}
}
