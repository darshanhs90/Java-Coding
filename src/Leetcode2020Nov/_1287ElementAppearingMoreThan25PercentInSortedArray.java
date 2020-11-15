package Leetcode2020Nov;

public class _1287ElementAppearingMoreThan25PercentInSortedArray {
	public static void main(String[] args) {
		System.out.println(findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 6, 6, 7, 10 }));
	}

	public static int findSpecialInteger(int[] arr) {
		int element = arr[arr.length / 4];
		int startIndex = findStartIndex(arr, element);
		int endIndex = findEndIndex(arr, element);
		if (endIndex - startIndex > arr.length / 4)
			return element;
		element = arr[arr.length / 2];
		startIndex = findStartIndex(arr, element);
		endIndex = findEndIndex(arr, element);
		if (endIndex - startIndex > arr.length / 4)
			return element;
		element = arr[3 * arr.length / 4];
		startIndex = findStartIndex(arr, element);
		endIndex = findEndIndex(arr, element);
		if (endIndex - startIndex > arr.length / 4)
			return element;
		return -1;
	}

	public static int findStartIndex(int[] arr, int element) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] >= element) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static int findEndIndex(int[] arr, int element) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] <= element) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

}
