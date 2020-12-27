package Dec2020Leetcode;

public class _0088MergeSortedArray {
	public static void main(String[] args) {
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		merge(new int[] { 4, 5, 6, 0, 0, 0 }, 3, new int[] { 1, 2, 3 }, 3);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int outputIndex = nums1.length - 1;
		m--;
		n--;
		while (m >= 0 || n >= 0) {
			if (m >= 0 && n >= 0) {
				if (nums1[m] > nums2[n]) {
					nums1[outputIndex] = nums1[m];
					m--;
				} else {
					nums1[outputIndex] = nums2[n];
					n--;
				}
			} else if (m >= 0) {
				nums1[outputIndex] = nums1[m];
				m--;
			} else {
				nums1[outputIndex] = nums2[n];
				n--;
			}
			outputIndex--;
		}
	}
}
