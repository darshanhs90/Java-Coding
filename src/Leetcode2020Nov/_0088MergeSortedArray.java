package Leetcode2020Nov;

public class _0088MergeSortedArray {
	public static void main(String[] args) {
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		merge(new int[] { 4, 5, 6, 0, 0, 0 }, 3, new int[] { 1, 2, 3 }, 3);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int mIndex = m - 1, nIndex = nums2.length - 1;
		int outIndex = nums1.length - 1;
		while (mIndex >= 0 || nIndex >= 0) {
			if (mIndex >= 0 && nIndex >= 0) {
				if (nums1[mIndex] > nums2[nIndex]) {
					nums1[outIndex] = nums1[mIndex];
					outIndex--;
					mIndex--;
				} else {
					nums1[outIndex] = nums2[nIndex];
					outIndex--;
					nIndex--;
				}
			} else if (mIndex >= 0) {
				nums1[outIndex] = nums1[mIndex];
				mIndex--;
				outIndex--;
			} else {
				nums1[outIndex] = nums2[nIndex];
				nIndex--;
				outIndex--;
			}
		}
	}
}
