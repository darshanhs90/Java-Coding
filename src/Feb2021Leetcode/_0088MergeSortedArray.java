package Feb2021Leetcode;

public class _0088MergeSortedArray {
	public static void main(String[] args) {
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		merge(new int[] { 4, 5, 6, 0, 0, 0 }, 3, new int[] { 1, 2, 3 }, 3);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int nums2Index = nums2.length - 1;
		int outIndex = nums1.length - 1;
		int nums1Index = m - 1;

		while (nums1Index >= 0 || nums2Index >= 0) {

			if (nums1Index >= 0 && nums2Index >= 0) {
				if (nums1[nums1Index] > nums2[nums2Index]) {
					nums1[outIndex] = nums1[nums1Index];
					nums1Index--;
				} else {
					nums1[outIndex] = nums2[nums2Index];
					nums2Index--;
				}
			} else if (nums1Index >= 0) {
				nums1[outIndex] = nums1[nums1Index];
				nums1Index--;
			} else {
				nums1[outIndex] = nums2[nums2Index];
				nums2Index--;
			}
			outIndex--;
		}
	}
}
