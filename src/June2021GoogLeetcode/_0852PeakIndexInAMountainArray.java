package June2021GoogLeetcode;

public class _0852PeakIndexInAMountainArray {
	public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray(new int[] { 0, 1, 0 }));
		System.out.println(peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
		System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 5, 2 }));
		System.out.println(peakIndexInMountainArray(new int[] { 3, 4, 5, 1 }));
		System.out.println(peakIndexInMountainArray(new int[] { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 }));
	}

	public static int peakIndexInMountainArray(int[] A) {
		int left = 0, right = A.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (A[mid] < A[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

}
