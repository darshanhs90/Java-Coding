package April2021Leetcode;

public class _0033SearchInRotatedSortedArray {

	public static void main(String[] args) {

		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 1));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 2));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 4));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 5));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 6));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 7));
		System.out.println(search(new int[] { 1 }, 0) == -1);
		System.out.println(search(new int[] { 5, 1, 3 }, 5) == 0);
	}

	public static int search(int[] nums, int target) {

	}
}
