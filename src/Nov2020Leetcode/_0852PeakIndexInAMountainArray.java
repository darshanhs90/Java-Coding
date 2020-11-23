package Nov2020Leetcode;

public class _0852PeakIndexInAMountainArray {
	public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray(new int[] { 0, 1, 0 }));
		System.out.println(peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
		System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 5, 2 }));
		System.out.println(peakIndexInMountainArray(new int[] { 3, 4, 5, 1 }));
		System.out.println(peakIndexInMountainArray(new int[] { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 }));
	}

	public static int peakIndexInMountainArray(int[] arr) {
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
				return i;
		}
		return 0;
	}
}
