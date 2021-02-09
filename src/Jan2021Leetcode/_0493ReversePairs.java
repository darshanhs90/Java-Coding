package Jan2021Leetcode;

public class _0493ReversePairs {

	public static void main(String[] args) {
		System.out.println(reversePairs(new int[] { 1, 3, 2, 3, 1 }));
		System.out.println(reversePairs(new int[] { 2, 4, 3, 5, 1 }));
		System.out.println(
				reversePairs(new int[] { 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647 }));
	}

	public static int reversePairs(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((long) nums[i] > (long) 2 * nums[j])
					count++;
			}
		}
		return count;
	}

}
