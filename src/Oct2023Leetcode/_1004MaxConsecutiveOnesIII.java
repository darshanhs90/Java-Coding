package Oct2023Leetcode;

public class _1004MaxConsecutiveOnesIII {
	public static void main(String[] args) {
		System.out.println(longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
		System.out.println(longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
	}

	public static int longestOnes(int[] nums, int k) {
		int maxOnes = 0;
		int noOfZeroesFlipped = 0;
		int left = 0, right = 0;
		while (right < nums.length) {
			if (nums[right] == 0) {
				noOfZeroesFlipped++;
			}
			while (noOfZeroesFlipped > k) {
				if (nums[left] == 0)
					noOfZeroesFlipped--;
				left++;
			}
			maxOnes = Math.max(maxOnes, right - left + 1);
			right++;
		}
		return maxOnes;
	}
}
