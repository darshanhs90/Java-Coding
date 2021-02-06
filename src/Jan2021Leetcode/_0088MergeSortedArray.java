package Jan2021Leetcode;

public class _0088MergeSortedArray {
	public static void main(String[] args) {
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		merge(new int[] { 4, 5, 6, 0, 0, 0 }, 3, new int[] { 1, 2, 3 }, 3);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = nums1.length - 1;
		int mIndex = m - 1;
		int nIndex = n - 1;
		while (mIndex >= 0 || nIndex >= 0) {
			if (mIndex >= 0 && nIndex >= 0) {
				if (nums1[mIndex] > nums2[nIndex]) {
					nums1[index] = nums1[mIndex];
					mIndex--;
					index--;
				} else {
					nums1[index] = nums2[nIndex];
					nIndex--;
					index--;
				}
			} else if (mIndex >= 0) {
				nums1[index] = nums1[mIndex];
				mIndex--;
				index--;
			} else {
				nums1[index] = nums2[nIndex];
				nIndex--;
				index--;
			}
		}
	}
}
